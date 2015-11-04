/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad;


import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;
import py.com.ideaspymes.facilerp.contabilidad.business.interfaces.IFacturaProveedorDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.Ingrediente;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.web.generico.BeanGenerico;




/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class FacturaProveedorBean extends BeanGenerico<FacturaProveedor> implements Serializable{

    @EJB private IFacturaProveedorDAO ejb;
    private DetFacturaProveedor detalleSeleccionado;
    
    
    @Override
    public AbstractDAO<FacturaProveedor> getEjb() {
        return ejb;
    }

    @Override
    public FacturaProveedor getNuevo() {
        return new FacturaProveedor();
    }

    public DetFacturaProveedor getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    public void setDetalleSeleccionado(DetFacturaProveedor detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }

    
    
  
    public void addDetalle() {
        if (getActual().getDetalles() == null) {
            getActual().setDetalles(new ArrayList<DetFacturaProveedor>());
        }
        detalleSeleccionado = new DetFacturaProveedor();
        detalleSeleccionado.setFacturaProveedor(getActual());
        detalleSeleccionado.setCantidad(0d);
        

        getActual().getDetalles().add(detalleSeleccionado);

    }

    public void removeDetalle(DetFacturaProveedor d) {
        int indexARemover = 0;

        for (DetFacturaProveedor dt : getActual().getDetalles()) {
            if (dt.getProducto().equals(d.getProducto()) && dt.getCantidad().equals(d.getCantidad())) {
                break;
            }
            indexARemover++;
        }

        getActual().getDetalles().remove(indexARemover);
    }

    public void autoCompleteSelectProducto(SelectEvent event) {
        Producto p = (Producto) event.getObject();
        detalleSeleccionado.setProducto(p);
        detalleSeleccionado.setUnidadMedida(p.getUnidadMedidaBase());
    }

    public void inputTextBlurCantidad(AjaxBehaviorEvent event) {
        if (event.getSource() instanceof InputText) {
            InputText input = (InputText) event.getSource();
            Double cantidad = (Double) input.getValue();
    //        calculaCosto(cantidad);
        }
    }

    public void calculaTotal(DetFacturaProveedor d) {
        if (d != null && d.getProducto() != null) {
            if ((d.getCantidad() != null && d.getCantidad() > 0) && 
                    (d.getPrecioUnitario() != null && d.getPrecioUnitario() > 0)) {
                
                d.setTotal(d.getCantidad() * d.getPrecioUnitario());
            }else{
                d.setTotal(0d);
            }
        }
    }
    
}
