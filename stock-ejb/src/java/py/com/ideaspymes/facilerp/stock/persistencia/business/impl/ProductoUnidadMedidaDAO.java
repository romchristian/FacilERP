/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.persistencia.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.ProductoUnidadMedida;
import py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces.IProductoUnidadMedidaDAO;


/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProductoUnidadMedidaDAO implements IProductoUnidadMedidaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public ProductoUnidadMedida create(ProductoUnidadMedida entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public ProductoUnidadMedida edit(ProductoUnidadMedida entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(ProductoUnidadMedida entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public ProductoUnidadMedida find(Object id) {
        return abmService.find(id, ProductoUnidadMedida.class);
    }

    @Override
    public List<ProductoUnidadMedida> findAll() {
        return abmService.getEM().createQuery("select obj from ProductoUnidadMedida obj").getResultList();
    }

    @Override
    public List<ProductoUnidadMedida> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
