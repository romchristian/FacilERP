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
import py.com.ideaspymes.facilerp.pesistencia.base.Usuario;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.Comprobante;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IComprobanteDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ComprobanteBean extends BeanGenerico<Comprobante> implements Serializable {

    @EJB
    private IComprobanteDAO ejb;

    @Override
    public AbstractDAO<Comprobante> getEjb() {
        return ejb;
    }

    @Override
    public Comprobante getNuevo() {
        return new Comprobante();
    }

    
    public void create(SesionTPV sesionTPV, MedioPago medioPago,Usuario u){
        ejb.create(getActual(),sesionTPV,medioPago,u.getUsuario());
    }
}
