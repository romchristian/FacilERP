/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.puntoventa.general.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.PuntoVenta;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IPuntoVentaDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PuntoVentaDAO implements IPuntoVentaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public PuntoVenta create(PuntoVenta entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public PuntoVenta edit(PuntoVenta entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(PuntoVenta entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public PuntoVenta find(Object id) {
        return abmService.find(id, PuntoVenta.class);
    }

    @Override
    public List<PuntoVenta> findAll() {
        return abmService.getEM().createQuery("select obj from PuntoVenta obj").getResultList();
    }

    @Override
    public List<PuntoVenta> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
