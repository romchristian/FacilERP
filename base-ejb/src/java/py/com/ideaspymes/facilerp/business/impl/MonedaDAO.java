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
import py.com.ideaspymes.facilerp.business.interfaces.IMonedaDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Moneda;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MonedaDAO implements IMonedaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Moneda create(Moneda entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Moneda edit(Moneda entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Moneda entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Moneda find(Object id) {
        return abmService.find(id, Moneda.class);
    }

    @Override
    public List<Moneda> findAll() {
        return abmService.getEM().createQuery("select obj from Moneda obj").getResultList();
    }

    @Override
    public List<Moneda> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
