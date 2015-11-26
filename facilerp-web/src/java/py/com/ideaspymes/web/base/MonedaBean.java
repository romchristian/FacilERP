/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.business.interfaces.IMonedaDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.base.Moneda;


/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class MonedaBean extends BeanGenerico<Moneda> implements Serializable{

    @EJB private IMonedaDAO ejb;
    
    
    @Override
    public AbstractDAO<Moneda> getEjb() {
        return ejb;
    }

    @Override
    public Moneda getNuevo() {
        return new Moneda();
    }

    
}
