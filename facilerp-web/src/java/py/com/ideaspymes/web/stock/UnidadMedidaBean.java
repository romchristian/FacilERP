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
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;
import py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces.IUnidadMedidaDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class UnidadMedidaBean extends BeanGenerico<UnidadMedida> implements Serializable{

    @EJB private IUnidadMedidaDAO ejb;
    
    
    @Override
    public AbstractDAO<UnidadMedida> getEjb() {
        return ejb;
    }

    @Override
    public UnidadMedida getNuevo() {
        return new UnidadMedida();
    }

    
}
