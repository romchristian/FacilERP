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
import py.com.ideaspymes.facilerp.pesistencia.base.Categoria;





/**
 *
 * @author Acer
 */
@Local
public interface ICategoriaDAO extends AbstractDAO<Categoria> {

    @Override
    Categoria create(Categoria entity, String usuario);

    @Override
    Categoria edit(Categoria entity, String usuario);

    @Override
    Categoria find(Object id);

    @Override
    List<Categoria> findAll();

    @Override
    List<Categoria> findAll(String query, QueryParameter params);

    @Override
    void remove(Categoria entity, String usuario);
    
}
