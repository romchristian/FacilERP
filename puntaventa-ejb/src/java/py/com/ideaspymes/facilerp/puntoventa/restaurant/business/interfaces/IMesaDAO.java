/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.puntoventa.restaurant.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Mesa;






/**
 *
 * @author Acer
 */
@Local
public interface IMesaDAO extends AbstractDAO<Mesa> {

    @Override
    Mesa create(Mesa entity, String usuario);

    @Override
    Mesa edit(Mesa entity, String usuario);

    @Override
    Mesa find(Object id);

    @Override
    List<Mesa> findAll();

    @Override
    List<Mesa> findAll(String query, QueryParameter params);

    @Override
    void remove(Mesa entity, String usuario);
    
}
