/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.business.interfaces.IBancoDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.base.Banco;


/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class BancoBean extends BeanGenerico<Banco> implements Serializable{

    @EJB private IBancoDAO ejb;
    
    
    @Override
    public AbstractDAO<Banco> getEjb() {
        return ejb;
    }

    @Override
    public Banco getNuevo() {
        return new Banco();
    }

    
}
