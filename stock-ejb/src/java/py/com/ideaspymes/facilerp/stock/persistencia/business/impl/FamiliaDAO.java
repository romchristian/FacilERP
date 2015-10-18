/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.persistencia.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.Familia;
import py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces.IFamiliaDAO;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FamiliaDAO implements IFamiliaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Familia create(Familia entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Familia edit(Familia entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Familia entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Familia find(Object id) {
        return abmService.find(id, Familia.class);
    }

    @Override
    public List<Familia> findAll() {
        return abmService.getEM().createQuery("select obj from Familia obj").getResultList();
    }

    @Override
    public List<Familia> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
