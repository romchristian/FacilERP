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
import py.com.ideaspymes.facilerp.pesistencia.base.Banco;





/**
 *
 * @author Acer
 */
@Local
public interface IBancoDAO extends AbstractDAO<Banco> {

    @Override
    Banco create(Banco entity, String usuario);

    @Override
    Banco edit(Banco entity, String usuario);

    @Override
    Banco find(Object id);

    @Override
    List<Banco> findAll();

    @Override
    List<Banco> findAll(String query, QueryParameter params);

    @Override
    void remove(Banco entity, String usuario);
    
}
