/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.restaurante;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Mesa;
import py.com.ideaspymes.facilerp.puntoventa.restaurant.business.interfaces.IMesaDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class MesaBean extends BeanGenerico<Mesa> implements Serializable {

    @EJB
    private IMesaDAO ejb;

    @Override
    public AbstractDAO<Mesa> getEjb() {
        return ejb;
    }

    @Override
    public Mesa getNuevo() {
        return new Mesa();
    }

}
