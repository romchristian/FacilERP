/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.base.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.base.generico.AbstractDAO;
import py.com.ideaspymes.base.generico.QueryParameter;
import py.com.ideaspymes.base.persistencia.Usuario;




/**
 *
 * @author Acer
 */
@Local
public interface IUsuarioDAO extends AbstractDAO<Usuario> {

    @Override
    Usuario create(Usuario entity, String usuario);

    @Override
    Usuario edit(Usuario entity, String usuario);

    @Override
    Usuario find(Object id);

    @Override
    List<Usuario> findAll();

    @Override
    List<Usuario> findAll(String query, QueryParameter params);

    @Override
    void remove(Usuario entity, String usuario);

    public Usuario find(String login);
    
}
