/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.listeners;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFP;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.pesistencia.stock.DetComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoComprobanteStock;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IComprobanteStockDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaService;

/**
 *
 * @author cromero
 */
@Stateless
@LocalBean
public class FacturaProveedorListener {

    @EJB
    private ILoteExistenciaService loteExistenciaService;
    @EJB
    private IComprobanteStockDAO comprobanteStockDAO;

    public void creacionFacturaProveedor(@Observes(during = TransactionPhase.AFTER_SUCCESS) @EventoFP EventoFacturaProveedor event) {
        System.out.println("En el listener : " + event.getFacturaProveedor());
        if (event.getFacturaProveedor() != null) {

            boolean conLoteAConfirmar = true;
            if (conLoteAConfirmar) {
                for (DetFacturaProveedor d : event.getFacturaProveedor().getDetalles()) {
                    creaLote(d, EstadoLote.PENDIENTE_CONFIRMACION,null);
                }
            } else {
                for (DetFacturaProveedor d : event.getFacturaProveedor().getDetalles()) {
                    creaLote(d, EstadoLote.ABIERTO,getDepositoDefault());
                }

                ComprobanteStock c = new ComprobanteStock();

                c.setTipo(TipoComprobanteStock.COMPRA);
                c.setFecha(new Date());
                c.setRefDocumento(event.getFacturaProveedor().getClass().getName() + ":" + event.getFacturaProveedor().getId());
                c.setRefOrigen("Proveedor:1");
                c.setRefDestino("py.com.ideaspymes.facilerp.pesistencia.stock.Deposito:1");
                //c.setUsuario(credencial.getUsuario());
                c.setDetalles(new ArrayList<DetComprobanteStock>());
                for (DetFacturaProveedor d : event.getFacturaProveedor().getDetalles()) {
                    DetComprobanteStock ds = new DetComprobanteStock();
                    ds.setComprobanteStock(c);
                    ds.setProducto(d.getProducto());
                    ds.setUnidadMedida(d.getUnidadMedida());
                    ds.setCantidad(d.getCantidad());
                    ds.setValor(d.getTotal());
                    c.getDetalles().add(ds);
                }

                comprobanteStockDAO.create(c, "");
            }
        }
    }

    private void creaLote(DetFacturaProveedor d, EstadoLote estadoLote, Deposito dp) {
        LoteExistencia l = null;
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
//                    l.setRefProveedor(event.getFacturaProveedor().getProveedor().getClass().getName()+":"+event.getFacturaProveedor().getProveedor().getId());
            loteExistenciaService.creaLoteExitencia(l);
        }

    }

    private Deposito getDepositoDefault() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
