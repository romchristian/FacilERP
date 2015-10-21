/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;





/**
 *
 * @author Acer
 */
@Local
public interface IDepositoDAO extends AbstractDAO<Deposito> {

    @Override
    Deposito create(Deposito entity, String usuario);

    @Override
    Deposito edit(Deposito entity, String usuario);

    @Override
    Deposito find(Object id);

    @Override
    List<Deposito> findAll();

    @Override
    List<Deposito> findAll(String query, QueryParameter params);

    @Override
    void remove(Deposito entity, String usuario);
    
}
