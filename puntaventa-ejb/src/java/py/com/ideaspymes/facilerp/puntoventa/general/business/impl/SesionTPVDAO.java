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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;
import py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces.ISesionTPVDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SesionTPVDAO implements ISesionTPVDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public SesionTPV create(SesionTPV entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public SesionTPV edit(SesionTPV entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(SesionTPV entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public SesionTPV find(Object id) {
        return abmService.find(id, SesionTPV.class);
    }

    @Override
    public List<SesionTPV> findAll() {
        return abmService.getEM().createQuery("select obj from SesionTPV obj").getResultList();
    }

    @Override
    public List<SesionTPV> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
