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
import py.com.ideaspymes.facilerp.pesistencia.base.Canal;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface ICanalDAO extends AbstractDAO<Canal> {

    @Override
    Canal create(Canal entity, String usuario);

    @Override
    Canal edit(Canal entity, String usuario);

    @Override
    Canal find(Object id);

    @Override
    List<Canal> findAll();

    @Override
    List<Canal> findAll(String query, QueryParameter params);

    @Override
    void remove(Canal entity, String usuario);
    
}
