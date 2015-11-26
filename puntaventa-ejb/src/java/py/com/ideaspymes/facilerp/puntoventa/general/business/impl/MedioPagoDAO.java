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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IMedioPagoDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MedioPagoDAO implements IMedioPagoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public MedioPago create(MedioPago entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public MedioPago edit(MedioPago entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(MedioPago entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public MedioPago find(Object id) {
        return abmService.find(id, MedioPago.class);
    }

    @Override
    public List<MedioPago> findAll() {
        return abmService.getEM().createQuery("select obj from MedioPago obj").getResultList();
    }

    @Override
    public List<MedioPago> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
