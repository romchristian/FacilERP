/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IDepositoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class DepositoBean extends BeanGenerico<Deposito> implements Serializable{

    @EJB private IDepositoDAO ejb;
    
    
    @Override
    public AbstractDAO<Deposito> getEjb() {
        return ejb;
    }

    @Override
    public Deposito getNuevo() {
        return new Deposito();
    }

    
}
