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
import py.com.ideaspymes.facilerp.pesistencia.base.Cliente;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface IClienteDAO extends AbstractDAO<Cliente> {

    @Override
    Cliente create(Cliente entity, String usuario);

    @Override
    Cliente edit(Cliente entity, String usuario);

    @Override
    Cliente find(Object id);

    @Override
    List<Cliente> findAll();

    @Override
    List<Cliente> findAll(String query, QueryParameter params);

    @Override
    void remove(Cliente entity, String usuario);
    
}
