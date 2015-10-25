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
import py.com.ideaspymes.facilerp.business.interfaces.ICobradorDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Cobrador;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CobradorDAO implements ICobradorDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cobrador create(Cobrador entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Cobrador edit(Cobrador entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Cobrador entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Cobrador find(Object id) {
        return abmService.find(id, Cobrador.class);
    }

    @Override
    public List<Cobrador> findAll() {
        return abmService.getEM().createQuery("select obj from Cobrador obj").getResultList();
    }

    @Override
    public List<Cobrador> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
