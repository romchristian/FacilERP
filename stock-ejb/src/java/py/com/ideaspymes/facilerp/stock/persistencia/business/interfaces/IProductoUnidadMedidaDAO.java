/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.stock.ProductoUnidadMedida;





/**
 *
 * @author Acer
 */
@Local
public interface IProductoUnidadMedidaDAO extends AbstractDAO<ProductoUnidadMedida> {

    @Override
    ProductoUnidadMedida create(ProductoUnidadMedida entity, String usuario);

    @Override
    ProductoUnidadMedida edit(ProductoUnidadMedida entity, String usuario);

    @Override
    ProductoUnidadMedida find(Object id);

    @Override
    List<ProductoUnidadMedida> findAll();

    @Override
    List<ProductoUnidadMedida> findAll(String query, QueryParameter params);

    @Override
    void remove(ProductoUnidadMedida entity, String usuario);
    
}
