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
import py.com.ideaspymes.facilerp.business.interfaces.IRolDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Rol;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RolDAO implements IRolDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Rol create(Rol entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Rol edit(Rol entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Rol entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Rol find(Object id) {
        return abmService.find(id, Rol.class);
    }

    @Override
    public List<Rol> findAll() {
        return abmService.getEM().createQuery("select obj from Rol obj").getResultList();
    }

    @Override
    public List<Rol> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
