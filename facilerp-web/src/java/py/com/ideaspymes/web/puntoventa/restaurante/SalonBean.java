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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Salon;
import py.com.ideaspymes.facilerp.puntoventa.restaurant.business.interfaces.ISalonDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;


/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class SalonBean extends BeanGenerico<Salon> implements Serializable {

    @EJB
    private ISalonDAO ejb;

    @Override
    public AbstractDAO<Salon> getEjb() {
        return ejb;
    }

    @Override
    public Salon getNuevo() {
        return new Salon();
    }

}
