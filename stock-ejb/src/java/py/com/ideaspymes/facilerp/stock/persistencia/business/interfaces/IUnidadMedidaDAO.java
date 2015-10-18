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
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;





/**
 *
 * @author Acer
 */
@Local
public interface IUnidadMedidaDAO extends AbstractDAO<UnidadMedida> {

    @Override
    UnidadMedida create(UnidadMedida entity, String usuario);

    @Override
    UnidadMedida edit(UnidadMedida entity, String usuario);

    @Override
    UnidadMedida find(Object id);

    @Override
    List<UnidadMedida> findAll();

    @Override
    List<UnidadMedida> findAll(String query, QueryParameter params);

    @Override
    void remove(UnidadMedida entity, String usuario);
    
}
