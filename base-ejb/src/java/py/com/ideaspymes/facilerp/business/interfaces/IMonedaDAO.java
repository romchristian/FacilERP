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
import py.com.ideaspymes.facilerp.pesistencia.base.Moneda;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface IMonedaDAO extends AbstractDAO<Moneda> {

    @Override
    Moneda create(Moneda entity, String usuario);

    @Override
    Moneda edit(Moneda entity, String usuario);

    @Override
    Moneda find(Object id);

    @Override
    List<Moneda> findAll();

    @Override
    List<Moneda> findAll(String query, QueryParameter params);

    @Override
    void remove(Moneda entity, String usuario);
    
}
