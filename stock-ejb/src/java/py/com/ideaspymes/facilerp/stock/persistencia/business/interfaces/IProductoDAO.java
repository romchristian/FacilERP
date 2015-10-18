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
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;





/**
 *
 * @author Acer
 */
@Local
public interface IProductoDAO extends AbstractDAO<Producto> {

    @Override
    Producto create(Producto entity, String usuario);

    @Override
    Producto edit(Producto entity, String usuario);

    @Override
    Producto find(Object id);

    @Override
    List<Producto> findAll();

    @Override
    List<Producto> findAll(String query, QueryParameter params);

    @Override
    void remove(Producto entity, String usuario);
    
}
