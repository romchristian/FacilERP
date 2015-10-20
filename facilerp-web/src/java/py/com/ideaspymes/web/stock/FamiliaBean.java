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
import py.com.ideaspymes.facilerp.pesistencia.stock.Familia;
import py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces.IFamiliaDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class FamiliaBean extends BeanGenerico<Familia> implements Serializable{

    @EJB private IFamiliaDAO ejb;
    
    
    @Override
    public AbstractDAO<Familia> getEjb() {
        return ejb;
    }

    @Override
    public Familia getNuevo() {
        return new Familia();
    }

    
}
