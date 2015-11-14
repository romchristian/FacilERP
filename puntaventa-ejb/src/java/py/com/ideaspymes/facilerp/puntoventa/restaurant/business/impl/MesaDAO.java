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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Mesa;
import py.com.ideaspymes.facilerp.puntoventa.restaurant.business.interfaces.IMesaDAO;








/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MesaDAO implements IMesaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Mesa create(Mesa entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Mesa edit(Mesa entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Mesa entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Mesa find(Object id) {
        return abmService.find(id, Mesa.class);
    }

    @Override
    public List<Mesa> findAll() {
        return abmService.getEM().createQuery("select obj from Mesa obj").getResultList();
    }

    @Override
    public List<Mesa> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
