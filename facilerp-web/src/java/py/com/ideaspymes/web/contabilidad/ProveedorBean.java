/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.contabilidad.business.interfaces.IProveedorDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;
import py.com.ideaspymes.web.generico.BeanGenerico;




/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ProveedorBean extends BeanGenerico<Proveedor> implements Serializable{

    @EJB private IProveedorDAO ejb;
    
    
    @Override
    public AbstractDAO<Proveedor> getEjb() {
        return ejb;
    }

    @Override
    public Proveedor getNuevo() {
        return new Proveedor();
    }

    
}
