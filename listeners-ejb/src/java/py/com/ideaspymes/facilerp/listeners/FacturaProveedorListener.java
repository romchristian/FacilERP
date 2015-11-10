/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.listeners;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import py.com.ideaspymes.facilerp.business.interfaces.IConfiguracionDAO;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFP;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFacturaProveedor;
import py.com.ideaspymes.facilerp.generico.exceptions.SinDetallesException;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.pesistencia.stock.DetComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoComprobanteStock;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IComprobanteStockDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IDepositoDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaDAO;

/**
 *
 * @author cromero
 */
@Stateless
@LocalBean
public class FacturaProveedorListener {

    @EJB
    private IComprobanteStockDAO comprobanteStockDAO;
    @EJB
    private IConfiguracionDAO configuracionDAO;
    @EJB
    private IDepositoDAO depositoDAO;
    @EJB
    private ILoteExistenciaDAO loteExistenciaDAO;

    public void creacionFacturaProveedor(@Observes(during = TransactionPhase.AFTER_SUCCESS) @EventoFP EventoFacturaProveedor event) {
        System.out.println("En el listener : " + event.getFacturaProveedor());
        if (event.getFacturaProveedor() != null) {

            List<LoteExistencia> lista = new ArrayList<>();

            for (DetFacturaProveedor d : event.getFacturaProveedor().getDetalles()) {
                lista.add(creaLote(d, EstadoLote.PENDIENTE_CONFIRMACION, null));
            }

            String multipleDepositos = configuracionDAO.getValor("stock", "MULTIPLE_DEPOSITO");

            if (multipleDepositos.compareToIgnoreCase("INHABILITADO") == 0) {

                List<LoteExistencia> listaACrear = new ArrayList<>();

                for (LoteExistencia l : lista) {
                    if (!l.getProducto().isTieneVencimiento()) {
                        listaACrear.add(l);
                    }
                }

                if (!listaACrear.isEmpty()) {

                    Deposito defaultDeposito = getDepositoDefault();

                    ComprobanteStock c = new ComprobanteStock();

                    c.setTipo(TipoComprobanteStock.COMPRA);
                    c.setFecha(new Date());
                    c.setRefDocumento(event.getFacturaProveedor().getClass().getName() + ":" + event.getFacturaProveedor().getId());
                    c.setRefOrigen(event.getFacturaProveedor().getProveedor().getClass().getName() + ":" + event.getFacturaProveedor().getProveedor().getId());
                    c.setRefDestino(defaultDeposito.getClass().getName() + ":" + defaultDeposito.getId());

                    c = agregaDetalleDesdeLote(c, listaACrear);
                    //c.setUsuario(credencial.getUsuario());

                    comprobanteStockDAO.create(c, "");

                    for (LoteExistencia lt : listaACrear) {
                        lt.setDeposito(defaultDeposito);
                        lt.setEstado(EstadoLote.ABIERTO);
                        loteExistenciaDAO.edit(lt, "");
                    }

                }

            }

        }
    }

    public ComprobanteStock agregaDetalleDesdeLote(ComprobanteStock entity, List<LoteExistencia> lotesPendientes) {
        entity.setDetalles(new ArrayList<DetComprobanteStock>());
        for (LoteExistencia lt : lotesPendientes) {
            if (lt.getEstado() == EstadoLote.PENDIENTE_CONFIRMACION) {
                DetComprobanteStock ds = new DetComprobanteStock();
                ds.setComprobanteStock(entity);
                ds.setProducto(lt.getProducto());
                ds.setUnidadMedida(lt.getUnidadMedida());
                ds.setCantidad(lt.getCantidadIngresada());
                ds.setValor(lt.getCosto());
                entity.getDetalles().add(ds);
            }
        }

        return entity;
    }

    private LoteExistencia creaLote(DetFacturaProveedor d, EstadoLote estadoLote, Deposito dp) {
        LoteExistencia l = null;
        LoteExistencia R = null;
        if (d.getProducto().isInventariable()) {
            l = new LoteExistencia();
            l.setEstado(estadoLote);
            l.setIngreso(new Date());
            l.setProducto(d.getProducto());
            l.setUnidadMedida(d.getUnidadMedida());
            l.setCantidadIngresada(d.getCantidad());
            l.setCantidadSaldo(d.getCantidad());
            l.setCosto(d.getPrecioUnitario());
            l.setDeposito(dp);
            l.setRefFactura(d.getFacturaProveedor().getClass().getName() + ":" + d.getFacturaProveedor().getId());
            l.setRefProveedor(d.getFacturaProveedor().getProveedor().getClass().getName() + ":" + d.getFacturaProveedor().getProveedor().getId());
            R = loteExistenciaDAO.edit(l, null);
        }
        return R;
    }

    private Deposito getDepositoDefault() {
        return depositoDAO.findDefault();
    }
}
