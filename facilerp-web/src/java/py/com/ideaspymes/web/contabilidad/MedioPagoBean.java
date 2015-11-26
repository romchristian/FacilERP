/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IMedioPagoDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@SessionScoped
public class MedioPagoBean extends BeanGenerico<MedioPago> implements Serializable {

    @EJB
    private IMedioPagoDAO ejb;
   
    @Override
    public AbstractDAO<MedioPago> getEjb() {
        return ejb;
    }

    @Override
    public MedioPago getNuevo() {
        return new MedioPago();
    }

   
}
