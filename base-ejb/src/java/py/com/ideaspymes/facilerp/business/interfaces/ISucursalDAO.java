/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.base.Sucursal;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface ISucursalDAO extends AbstractDAO<Sucursal> {

    @Override
    Sucursal create(Sucursal entity, String usuario);

    @Override
    Sucursal edit(Sucursal entity, String usuario);

    @Override
    Sucursal find(Object id);

    @Override
    List<Sucursal> findAll();

    @Override
    List<Sucursal> findAll(String query, QueryParameter params);

    @Override
    void remove(Sucursal entity, String usuario);
    
}
