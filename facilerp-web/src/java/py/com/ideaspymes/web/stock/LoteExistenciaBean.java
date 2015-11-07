/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import com.sun.org.apache.xpath.internal.operations.Lte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.generico.exceptions.SinDetallesException;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;

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
        Map<Deposito, List<LoteExistencia>> mapa = new HashMap<>();

        //Agrupo
        for (LoteExistencia l : pendientes) {
            if (l.isSeleccionado()) {
                if (mapa.get(l.getDeposito()) == null) {
                    List<LoteExistencia> lotes = new ArrayList<>();
                    lotes.add(l);
                    mapa.put(l.getDeposito(), lotes);
                } else {
                    mapa.get(l.getDeposito()).add(l);
                }
            }
        }

        boolean todoBien = false;
        for (Map.Entry<Deposito, List<LoteExistencia>> e : mapa.entrySet()) {

            String refProveedor = e.getValue().get(0).getRefProveedor();
            String refFactura = e.getValue().get(0).getRefFactura();
            String refDeposito = e.getKey().getClass().getName() + ":" + e.getKey().getId();

            ComprobanteStock c = new ComprobanteStock();
            c.setTipo(TipoComprobanteStock.COMPRA);
            c.setFecha(new Date());
            c.setRefDocumento(refFactura);
            c.setRefOrigen(refProveedor);
            c.setRefDestino(refDeposito);

            try {
                ejbComprobanteStockDAO.create(c, e.getValue(), credencial.getUsuario().getUsuario());
                todoBien = true;
            } catch (SinDetallesException ex) {
                JsfUtil.addErrorMessage("El comprobante para el deposito " + e.getKey().getNombre() + " no pudo crearse. Error: " + ex.getMessage());
                todoBien = false;

            }

        }

        cargaPendientes();
    }

}
