/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.business.interfaces.ISecuenciaDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.base.Secuencia;


/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class SecuenciaBean extends BeanGenerico<Secuencia> implements Serializable{

    @EJB private ISecuenciaDAO ejb;
    
    
    @Override
    public AbstractDAO<Secuencia> getEjb() {
        return ejb;
    }

    @Override
    public Secuencia getNuevo() {
        return new Secuencia();
    }

    
}
