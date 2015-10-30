/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.contabilidad.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;

/**
 *
 * @author Acer
 */
@Local
public interface IProveedorDAO extends AbstractDAO<Proveedor> {

    @Override
    Proveedor create(Proveedor entity, String usuario);

    @Override
    Proveedor edit(Proveedor entity, String usuario);

    @Override
    Proveedor find(Object id);

    @Override
    List<Proveedor> findAll();

    @Override
    List<Proveedor> findAll(String query, QueryParameter params);

    @Override
    void remove(Proveedor entity, String usuario);

}
