/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.stock.Ingrediente;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IProductoDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ProductoBean extends BeanGenerico<Producto> implements Serializable {

    @EJB
    private IProductoDAO ejb;
    private Ingrediente ingredienteSeleccionado;

    @Override
    public AbstractDAO<Producto> getEjb() {
        return ejb;
    }

    @Override
    public Producto getNuevo() {
        return new Producto();
    }

    public Ingrediente getIngredienteSeleccionado() {
        return ingredienteSeleccionado;
    }

    public void setIngredienteSeleccionado(Ingrediente ingredienteSeleccionado) {
        this.ingredienteSeleccionado = ingredienteSeleccionado;
    }

    public void addIngrediente() {
        if (getActual().getIngredientes() == null) {
            getActual().setIngredientes(new ArrayList<Ingrediente>());
        }
        ingredienteSeleccionado = new Ingrediente();
        ingredienteSeleccionado.setProductoPadre(getActual());
        ingredienteSeleccionado.setCantidad(0d);
        ingredienteSeleccionado.setCosto(0d);

        getActual().getIngredientes().add(ingredienteSeleccionado);

    }

    public void removeIngrediente(Ingrediente i) {
        int indexARemover = 0;

        for (Ingrediente ig : getActual().getIngredientes()) {
            if (ig.getProducto().equals(i.getProducto())) {
                break;
            }
            indexARemover++;
        }

        getActual().getIngredientes().remove(indexARemover);
    }

    public void autoCompleteSelectProducto(SelectEvent event) {
        Producto p = (Producto) event.getObject();
        ingredienteSeleccionado.setProducto(p);
        ingredienteSeleccionado.setUnidadMedida(p.getUnidadMedidaBase());
    }

    public void inputTextBlurCantidad(AjaxBehaviorEvent event) {
        if (event.getSource() instanceof InputText) {
            InputText input = (InputText) event.getSource();
            Double cantidad = (Double) input.getValue();
    //        calculaCosto(cantidad);
        }
    }

    public void calculaCosto(Double cantidad, Ingrediente i) {
        if (i != null && i.getProducto() != null) {
            if (cantidad != null && cantidad > 0) {
                i.setCosto(cantidad * (i.getProducto().getCosto() == null ? 0d : i.getProducto().getCosto()));
                System.out.println("Costo: " + i.getCosto());
            }
        }
    }

}
