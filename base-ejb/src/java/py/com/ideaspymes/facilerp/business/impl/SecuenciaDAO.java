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
import py.com.ideaspymes.facilerp.business.interfaces.ISecuenciaDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Secuencia;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SecuenciaDAO implements ISecuenciaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Secuencia create(Secuencia entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Secuencia edit(Secuencia entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Secuencia entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Secuencia find(Object id) {
        return abmService.find(id, Secuencia.class);
    }

    @Override
    public List<Secuencia> findAll() {
        return abmService.getEM().createQuery("select obj from Secuencia obj").getResultList();
    }

    @Override
    public List<Secuencia> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
