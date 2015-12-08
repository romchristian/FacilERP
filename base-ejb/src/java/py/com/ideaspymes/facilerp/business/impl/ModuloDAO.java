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
import py.com.ideaspymes.facilerp.business.interfaces.IModuloDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Modulo;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ModuloDAO implements IModuloDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Modulo create(Modulo entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Modulo edit(Modulo entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Modulo entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Modulo find(Object id) {
        return abmService.find(id, Modulo.class);
    }
    
    public Modulo find(String login) {
        Modulo R = null;
        
        try {
            R = (Modulo) abmService.getEM().createQuery("SELECT u FROM Modulo u WHERE u.usuario = :login ")
                    .setParameter("login", login).getSingleResult();
        } catch (Exception e) {
        }
        
        return R;
    }

    @Override
    public List<Modulo> findAll() {
        return abmService.getEM().createQuery("select obj from Modulo obj").getResultList();
    }

    @Override
    public List<Modulo> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
