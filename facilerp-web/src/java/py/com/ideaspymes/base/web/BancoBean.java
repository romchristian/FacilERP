/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.base.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.base.business.interfaces.IBancoDAO;
import py.com.ideaspymes.base.generico.AbstractDAO;
import py.com.ideaspymes.base.persistencia.Banco;
import py.com.ideaspymes.base.web.generico.BeanGenerico;




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
