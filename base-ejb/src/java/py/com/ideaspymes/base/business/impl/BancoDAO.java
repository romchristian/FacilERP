/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.base.business.impl;

import py.com.ideaspymes.base.generico.ABMService;
import py.com.ideaspymes.base.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.base.business.interfaces.IBancoDAO;
import py.com.ideaspymes.base.persistencia.Banco;




/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BancoDAO implements IBancoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Banco create(Banco entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Banco edit(Banco entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Banco entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Banco find(Object id) {
        return abmService.find(id, Banco.class);
    }

    @Override
    public List<Banco> findAll() {
        return abmService.getEM().createQuery("select obj from Banco obj").getResultList();
    }

    @Override
    public List<Banco> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
