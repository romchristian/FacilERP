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
import py.com.ideaspymes.facilerp.pesistencia.base.Modulo;

/**
 *
 * @author Acer
 */
@Local
public interface IModuloDAO extends AbstractDAO<Modulo> {

    @Override
    Modulo create(Modulo entity, String usuario);

    @Override
    Modulo edit(Modulo entity, String usuario);

    @Override
    Modulo find(Object id);

    @Override
    List<Modulo> findAll();

    @Override
    List<Modulo> findAll(String query, QueryParameter params);

    @Override
    void remove(Modulo entity, String usuario);

    public Modulo find(String login);
    
}
