/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.stock.Familia;





/**
 *
 * @author Acer
 */
@Local
public interface IFamiliaDAO extends AbstractDAO<Familia> {

    @Override
    Familia create(Familia entity, String usuario);

    @Override
    Familia edit(Familia entity, String usuario);

    @Override
    Familia find(Object id);

    @Override
    List<Familia> findAll();

    @Override
    List<Familia> findAll(String query, QueryParameter params);

    @Override
    void remove(Familia entity, String usuario);
    
}
