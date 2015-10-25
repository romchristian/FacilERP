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
import py.com.ideaspymes.facilerp.pesistencia.base.Rol;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface IRolDAO extends AbstractDAO<Rol> {

    @Override
    Rol create(Rol entity, String usuario);

    @Override
    Rol edit(Rol entity, String usuario);

    @Override
    Rol find(Object id);

    @Override
    List<Rol> findAll();

    @Override
    List<Rol> findAll(String query, QueryParameter params);

    @Override
    void remove(Rol entity, String usuario);
    
}
