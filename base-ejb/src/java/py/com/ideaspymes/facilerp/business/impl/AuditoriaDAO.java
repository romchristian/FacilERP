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
import javax.persistence.EntityManager;
import py.com.ideaspymes.facilerp.business.interfaces.IAuditoriaDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Auditoria;

/**
 *
 * @author Elias Melgarejo
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AuditoriaDAO implements IAuditoriaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Auditoria create(Auditoria entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    public void crear(Auditoria aud) {
        System.out.println("Simulando Log");
        System.out.println("crear : ");
        EntityManager em = abmService.getEM();
        System.out.println("EM : " + em);
        System.out.println("Mi objeto : " + aud);
        System.out.println("desc : " + aud.getTablaAfectada());
        em.persist(aud);
        System.out.println("Mi objeto despues de persist: " + aud);
    }
    
    @Override
    public Auditoria edit(Auditoria entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Auditoria entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Auditoria find(Object id) {
        return abmService.find(id, Auditoria.class);
    }

    @Override
    public List<Auditoria> findAll() {
        return abmService.getEM().createQuery("select obj from Auditoria obj").getResultList();
    }

    @Override
    public List<Auditoria> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
