/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class LoteExistenciaBean extends BeanGenerico<LoteExistencia> implements Serializable {
    
    @EJB
    private ILoteExistenciaDAO ejb;
    private List<LoteExistencia> pendientes;
    private boolean todos;
    
    public boolean isTodos() {
        return todos;
    }
    
    public void setTodos(boolean todos) {
        this.todos = todos;
    }
    
    public List<LoteExistencia> getPendientes() {
        if (pendientes == null) {
            pendientes = ejb.findAll("select l from LoteExistencia l where l.estado = :estado",
                    QueryParameter.where("estado", EstadoLote.PENDIENTE_CONFIRMACION));
        }
        return pendientes;
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
    
}
