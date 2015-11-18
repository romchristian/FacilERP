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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Salon;






/**
 *
 * @author Acer
 */
@Local
public interface ISalonDAO extends AbstractDAO<Salon> {

    @Override
    Salon create(Salon entity, String usuario);

    @Override
    Salon edit(Salon entity, String usuario);

    @Override
    Salon find(Object id);

    @Override
    List<Salon> findAll();

    @Override
    List<Salon> findAll(String query, QueryParameter params);

    @Override
    void remove(Salon entity, String usuario);
    
}
