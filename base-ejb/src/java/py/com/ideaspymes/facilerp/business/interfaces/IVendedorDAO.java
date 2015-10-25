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
import py.com.ideaspymes.facilerp.pesistencia.base.Vendedor;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface IVendedorDAO extends AbstractDAO<Vendedor> {

    @Override
    Vendedor create(Vendedor entity, String usuario);

    @Override
    Vendedor edit(Vendedor entity, String usuario);

    @Override
    Vendedor find(Object id);

    @Override
    List<Vendedor> findAll();

    @Override
    List<Vendedor> findAll(String query, QueryParameter params);

    @Override
    void remove(Vendedor entity, String usuario);
    
}
