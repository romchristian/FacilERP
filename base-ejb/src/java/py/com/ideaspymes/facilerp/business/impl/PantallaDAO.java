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
import py.com.ideaspymes.facilerp.business.interfaces.IPantallaDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Modulo;
import py.com.ideaspymes.facilerp.pesistencia.base.Pantalla;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PantallaDAO implements IPantallaDAO {
    
    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;
    
    @Override
    public Pantalla create(Pantalla entity, String usuario) {
        return abmService.create(entity, usuario);
    }
    
    @Override
    public Pantalla edit(Pantalla entity, String usuario) {
        return abmService.update(entity, usuario);
    }
    
    @Override
    public void remove(Pantalla entity, String usuario) {
        abmService.delete(entity, usuario);
    }
    
    @Override
    public Pantalla find(Object id) {
        return abmService.find(id, Pantalla.class);
    }
    
    public Pantalla find(String login) {
        Pantalla R = null;
        
        try {
            R = (Pantalla) abmService.getEM().createQuery("SELECT u FROM Pantalla u WHERE u.usuario = :login ")
                    .setParameter("login", login).getSingleResult();
        } catch (Exception e) {
        }
        
        return R;
    }
    
    @Override
    public List<Pantalla> findAll() {
        return abmService.getEM().createQuery("select obj from Pantalla obj").getResultList();
    }
    
    @Override
    public List<Pantalla> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }
    
    @Override
    public List<Pantalla> findAll(Modulo m) {
        return abmService.getEM().createQuery("select obj from Pantalla obj WHERE obj.modulo = ?1")
                .setParameter(1, m)
                .getResultList();
    }
    
}
