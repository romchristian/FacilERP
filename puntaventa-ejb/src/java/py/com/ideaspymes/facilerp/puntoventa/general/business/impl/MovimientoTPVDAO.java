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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MovimientoTPV;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.IMovimientoTPVDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MovimientoTPVDAO implements IMovimientoTPVDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public MovimientoTPV create(MovimientoTPV entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public MovimientoTPV edit(MovimientoTPV entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(MovimientoTPV entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public MovimientoTPV find(Object id) {
        return abmService.find(id, MovimientoTPV.class);
    }

    @Override
    public List<MovimientoTPV> findAll() {
        return abmService.getEM().createQuery("select obj from MovimientoTPV obj").getResultList();
    }

    @Override
    public List<MovimientoTPV> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
