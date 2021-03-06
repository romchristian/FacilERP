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
import py.com.ideaspymes.facilerp.pesistencia.base.Pantalla;

/**
 *
 * @author Acer
 */
@Local
public interface IPantallaDAO extends AbstractDAO<Pantalla> {

    @Override
    Pantalla create(Pantalla entity, String usuario);

    @Override
    Pantalla edit(Pantalla entity, String usuario);

    @Override
    Pantalla find(Object id);

    @Override
    List<Pantalla> findAll();

    @Override
    List<Pantalla> findAll(String query, QueryParameter params);

    @Override
    void remove(Pantalla entity, String usuario);

    public Pantalla find(String login);
    
    List<Pantalla> findAll(Modulo m);
    
}
