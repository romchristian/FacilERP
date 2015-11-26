/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.general;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.PuntoVenta;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IPuntoVentaDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class PuntoVentaBean extends BeanGenerico<PuntoVenta> implements Serializable {

    @EJB
    private IPuntoVentaDAO ejb;

    @Override
    public AbstractDAO<PuntoVenta> getEjb() {
        return ejb;
    }

    @Override
    public PuntoVenta getNuevo() {
        return new PuntoVenta();
    }

}
