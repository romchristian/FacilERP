/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.business.interfaces.ICanalDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Canal;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CanalDAO implements ICanalDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Canal create(Canal entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Canal edit(Canal entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Canal entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Canal find(Object id) {
        return abmService.find(id, Canal.class);
    }

    @Override
    public List<Canal> findAll() {
        return abmService.getEM().createQuery("select obj from Canal obj").getResultList();
    }

    @Override
    public List<Canal> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
