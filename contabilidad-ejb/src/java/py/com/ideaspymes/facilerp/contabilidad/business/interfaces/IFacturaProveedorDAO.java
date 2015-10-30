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
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;

/**
 *
 * @author Acer
 */
@Local
public interface IFacturaProveedorDAO extends AbstractDAO<FacturaProveedor> {

    @Override
    FacturaProveedor create(FacturaProveedor entity, String usuario);

    @Override
    FacturaProveedor edit(FacturaProveedor entity, String usuario);

    @Override
    FacturaProveedor find(Object id);

    @Override
    List<FacturaProveedor> findAll();

    @Override
    List<FacturaProveedor> findAll(String query, QueryParameter params);

    @Override
    void remove(FacturaProveedor entity, String usuario);

}
