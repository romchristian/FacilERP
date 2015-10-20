/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.business.interfaces.IImpuestoDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.base.Impuesto;


/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ImpuestoBean extends BeanGenerico<Impuesto> implements Serializable{

    @EJB private IImpuestoDAO ejb;
    
    
    @Override
    public AbstractDAO<Impuesto> getEjb() {
        return ejb;
    }

    @Override
    public Impuesto getNuevo() {
        return new Impuesto();
    }

    
}
