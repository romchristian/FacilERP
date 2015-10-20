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
import py.com.ideaspymes.facilerp.business.interfaces.IImpuestoDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Impuesto;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ImpuestoDAO implements IImpuestoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Impuesto create(Impuesto entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Impuesto edit(Impuesto entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Impuesto entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Impuesto find(Object id) {
        return abmService.find(id, Impuesto.class);
    }

    @Override
    public List<Impuesto> findAll() {
        return abmService.getEM().createQuery("select obj from Impuesto obj").getResultList();
    }

    @Override
    public List<Impuesto> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
