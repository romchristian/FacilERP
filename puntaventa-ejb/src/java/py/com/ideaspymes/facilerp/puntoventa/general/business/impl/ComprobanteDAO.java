/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.puntoventa.general.business.impl;

import java.util.Date;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.Comprobante;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MovimientoTPV;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IComprobanteDAO;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IMovimientoTPVDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ComprobanteDAO implements IComprobanteDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @EJB
    private IMovimientoTPVDAO movimientoTPVDAO;

    @Override
    public Comprobante create(Comprobante entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Comprobante edit(Comprobante entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Comprobante entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Comprobante find(Object id) {
        return abmService.find(id, Comprobante.class);
    }

    @Override
    public List<Comprobante> findAll() {
        return abmService.getEM().createQuery("select obj from Comprobante obj").getResultList();
    }

    @Override
    public List<Comprobante> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    /**
     * Custom
     *
     * @param entity
     * @param sesion
     * @param medioPago
     * @param usuario
     * @return
     *
     */
    @Override
    public Comprobante create(Comprobante entity, SesionTPV sesion, MedioPago medioPago, String usuario) {
        entity = create(entity, usuario);
        
        MovimientoTPV m = new MovimientoTPV();
        m.setFecha(new Date());
        m.setSesion(sesion);
        m.setComprobante(entity);
        m.setMedioPago(medioPago);
        m.setMonto(entity.getTotal());
        m.setUsuario(sesion.getUsuario());
        m.setTipo(entity.getTipoMovimiento());
        m.setMoneda(entity.getMoneda());

        movimientoTPVDAO.create(m, usuario);

        return entity;
    }

}
