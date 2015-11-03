/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IDepositoDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DepositoDAO implements IDepositoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Deposito create(Deposito entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Deposito edit(Deposito entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Deposito entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Deposito find(Object id) {
        return abmService.find(id, Deposito.class);
    }

    @Override
    public List<Deposito> findAll() {
        return abmService.getEM().createQuery("select obj from Deposito obj").getResultList();
    }

    @Override
    public List<Deposito> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    public Deposito findDefault() {
        Deposito R = null;
        try {
            R = (Deposito) abmService.getEM().createQuery("SELECT d FROM Deposito d")
                    .setMaxResults(1).getSingleResult();
            
        } catch (Exception e) {
        }
        return R;
    }

}
