/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.contabilidad.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import py.com.ideaspymes.facilerp.contabilidad.business.interfaces.IFacturaProveedorDAO;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;
import javax.enterprise.event.Event;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FacturaProveedorDAO implements IFacturaProveedorDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;
    
    @Inject
    @EventoFP
    private Event<EventoFacturaProveedor> evento;

    @Override
    public FacturaProveedor create(FacturaProveedor entity, String usuario) {
        FacturaProveedor f = abmService.create(entity, usuario);
        EventoFacturaProveedor ev = new EventoFacturaProveedor(f);
        evento.fire(ev);
        return f;
    }

    @Override
    public FacturaProveedor edit(FacturaProveedor entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(FacturaProveedor entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public FacturaProveedor find(Object id) {
        return abmService.find(id, FacturaProveedor.class);
    }

    @Override
    public List<FacturaProveedor> findAll() {
        return abmService.getEM().createQuery("select obj from FacturaProveedor obj").getResultList();
    }

    @Override
    public List<FacturaProveedor> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
