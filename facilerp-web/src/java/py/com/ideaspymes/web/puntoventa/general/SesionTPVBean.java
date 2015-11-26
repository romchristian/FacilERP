/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.general;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Moneda;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.TipoMovimiento;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.Comprobante;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.PuntoVenta;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.enums.EstadoSesionTPV;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.ISesionTPVDAO;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.web.generico.Credencial;
import py.com.ideaspymes.web.generico.JsfUtil;

/**
 *
 * @author christian
 */
@Named
@SessionScoped
public class SesionTPVBean extends BeanGenerico<SesionTPV> implements Serializable {

    @EJB
    private ISesionTPVDAO ejb;
    @Inject
    private ComprobanteBean comprobanteBean;
    @Inject
    private Credencial credencial;
    @Inject
    private PuntoVentaBean puntoVentaBean;

    private Moneda moneda;
    private PuntoVenta puntoVenta;
    private MedioPago medioPago;
    private Comprobante comprobante;

    @Override
    public AbstractDAO<SesionTPV> getEjb() {
        return ejb;
    }

    @Override
    public SesionTPV getNuevo() {
        return new SesionTPV();
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Comprobante getComprobante() {
        if (comprobante == null) {
            comprobante = new Comprobante();
        }
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public String abrirSesion() {
        String R = null;
        if (validaInicioSesion()) {
            getActual().setEstado(EstadoSesionTPV.ABIERTA);
            getActual().setUsuario(credencial.getUsuario());
            getActual().setFechaApertura(new Date());
            getActual().setPuntoVenta(puntoVenta);
            setActual(ejb.create(getActual(), credencial.getUsuario().getUsuario()));
            
            System.out.println("Sesion ID : " + getActual().getId());
            return "tpv.xhtml";
        } else {
            JsfUtil.addErrorMessage("Inicio de sesión invalido!");
        }

        return R;
    }

    private boolean validaInicioSesion() {
        return true;
    }

    public String crearComprobante() {
        comprobanteBean.setActual(comprobante);
        comprobanteBean.getActual().setMoneda(moneda);
        comprobanteBean.getActual().setTipoMovimiento(TipoMovimiento.SALIDA);
        comprobanteBean.create(getActual(), medioPago, credencial.getUsuario());
        comprobante = null;
        
        return null;
    }
}
