/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.puntoventa.restaurant.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Salon;
import py.com.ideaspymes.facilerp.puntoventa.restaurant.business.interfaces.ISalonDAO;








/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SalonDAO implements ISalonDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Salon create(Salon entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Salon edit(Salon entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Salon entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Salon find(Object id) {
        return abmService.find(id, Salon.class);
    }

    @Override
    public List<Salon> findAll() {
        return abmService.getEM().createQuery("select obj from Salon obj").getResultList();
    }

    @Override
    public List<Salon> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
