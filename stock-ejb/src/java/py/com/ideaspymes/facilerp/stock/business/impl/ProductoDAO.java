/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IProductoDAO;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductoDAO implements IProductoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Producto create(Producto entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Producto edit(Producto entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Producto entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Producto find(Object id) {
        return abmService.find(id, Producto.class);
    }

    @Override
    public List<Producto> findAll() {
        return abmService.getEM().createQuery("select obj from Producto obj").getResultList();
    }

    @Override
    public List<Producto> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
