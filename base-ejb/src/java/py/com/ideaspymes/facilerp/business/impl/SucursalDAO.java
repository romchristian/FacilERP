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
import py.com.ideaspymes.facilerp.business.interfaces.ISucursalDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Sucursal;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SucursalDAO implements ISucursalDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Sucursal create(Sucursal entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Sucursal edit(Sucursal entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Sucursal entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Sucursal find(Object id) {
        return abmService.find(id, Sucursal.class);
    }

    @Override
    public List<Sucursal> findAll() {
        return abmService.getEM().createQuery("select obj from Sucursal obj").getResultList();
    }

    @Override
    public List<Sucursal> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
