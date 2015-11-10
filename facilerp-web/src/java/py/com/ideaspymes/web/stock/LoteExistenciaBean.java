/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.generico.exceptions.SinDetallesException;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.pesistencia.stock.DetComprobanteStock;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoComprobanteStock;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IComprobanteStockDAO;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaDAO;
import py.com.ideaspymes.web.generico.Credencial;
import py.com.ideaspymes.web.generico.JsfUtil;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class LoteExistenciaBean extends BeanGenerico<LoteExistencia> implements Serializable {

    @EJB
    private ILoteExistenciaDAO ejb;
    @EJB
    private IComprobanteStockDAO ejbComprobanteStockDAO;
    @EJB
    private ILoteExistenciaDAO ejbLoteExistenciaDAO;
    private List<LoteExistencia> pendientes;
    private boolean todos;
    private boolean editar;
    @Inject
    private Credencial credencial;

    public boolean isTodos() {
        return todos;
    }

    public void setTodos(boolean todos) {
        this.todos = todos;
    }

    public List<LoteExistencia> getPendientes() {
        if (pendientes == null) {
            cargaPendientes();
        }
        return pendientes;
    }

    public void cargaPendientes() {
        pendientes = ejb.findAll("select l from LoteExistencia l where l.estado = :estado",
                QueryParameter.where("estado", EstadoLote.PENDIENTE_CONFIRMACION));
    }

    public void setPendientes(List<LoteExistencia> pendientes) {
        this.pendientes = pendientes;
    }

    @Override
    public AbstractDAO<LoteExistencia> getEjb() {
        return ejb;
    }

    @Override
    public LoteExistencia getNuevo() {
        return new LoteExistencia();
    }

    public void toggleTodos() {

        System.out.println("Todos: " + todos);
        for (LoteExistencia l : pendientes) {
            l.setSeleccionado(todos);
        }
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public void habilitaEdicion() {
        editar = true;
    }

    public void cancelaEdicion() {
        editar = false;
    }

    public void guardaLista() {
        for (LoteExistencia l : pendientes) {
            ejb.edit(l, credencial.getUsuario().getUsuario());
        }
        cancelaEdicion();
    }

    public boolean isHaySeleccion() {
        boolean R = false;
        if (pendientes != null) {
            for (LoteExistencia l : pendientes) {
                if (l.isSeleccionado()) {
                    R = true;
                    break;
                }
            }
        }
        return R;
    }

    public void generarComprobante() {

        ComprobanteStock c = new ComprobanteStock();
        c.setTipo(TipoComprobanteStock.COMPRA);
        c.setFecha(new Date());
        c.setRefDocumento("");
        c.setRefOrigen("");
        c.setRefDestino("");

        c = agregaDetalleDesdeLote(c, pendientes);
        System.out.println("Creo los detalles del comprobante a partir de los lotes!");
        ejbComprobanteStockDAO.create(c, credencial.getUsuario().getUsuario());

        for (LoteExistencia lt : pendientes) {
            lt.setEstado(EstadoLote.ABIERTO);
            ejbLoteExistenciaDAO.edit(lt, credencial.getUsuario().getUsuario());
            System.out.println("Cambio estado de los lotes!");
        }

//        
//        List<Deposito> depositos = new ArrayList<>();
//
//        for (LoteExistencia l : pendientes) {
//            if (l.isSeleccionado() && l.getDeposito() != null) {
//                System.out.println("Agrege deposito!");
//                depositos.add(l.getDeposito());
//            }
//        }
//
//        for (Deposito d : depositos) {
//            List<LoteExistencia> lotesACrear = new ArrayList<>();
//
//            String refProveedor = "";
//            String refFactura = "";
//            String refDeposito = d.getClass().getName() + ":" + d.getId();
//            for (LoteExistencia l : pendientes) {
//                System.out.println("Recorro lotes!");
//                if (l.isSeleccionado() && d.equals(l.getDeposito())) {
//                    System.out.println("Agrego el lote con el matcheo de deposito");
//                    lotesACrear.add(l);
//                    refProveedor = l.getRefProveedor();
//                    refFactura = l.getRefFactura();
//
//                }
//            }
//
//            if (!lotesACrear.isEmpty()) {
//                System.out.println("Empiezo a crear el comprobante!");
//                ComprobanteStock c = new ComprobanteStock();
//                c.setTipo(TipoComprobanteStock.COMPRA);
//                c.setFecha(new Date());
//                c.setRefDocumento(refFactura);
//                c.setRefOrigen(refProveedor);
//                c.setRefDestino(refDeposito);
//
//                c = agregaDetalleDesdeLote(c, lotesACrear);
//                System.out.println("Creo los detalles del comprobante a partir de los lotes!");
//                ejbComprobanteStockDAO.create(c, credencial.getUsuario().getUsuario());
//                System.out.println("Despues de crear el comprobante!");
//
//                for (LoteExistencia lt : lotesACrear) {
//                    lt.setEstado(EstadoLote.ABIERTO);
//                    ejbLoteExistenciaDAO.edit(lt, credencial.getUsuario().getUsuario());
//                    System.out.println("Cambio estado de los lotes!");
//                }
//            }
//        }
        cargaPendientes();
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
}
