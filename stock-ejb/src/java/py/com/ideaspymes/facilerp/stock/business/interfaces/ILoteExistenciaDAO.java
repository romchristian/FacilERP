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
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;





/**
 *
 * @author Acer
 */
@Local
public interface ILoteExistenciaDAO extends AbstractDAO<LoteExistencia> {

    @Override
    LoteExistencia create(LoteExistencia entity, String usuario);

    @Override
    LoteExistencia edit(LoteExistencia entity, String usuario);

    @Override
    LoteExistencia find(Object id);

    @Override
    List<LoteExistencia> findAll();

    @Override
    List<LoteExistencia> findAll(String query, QueryParameter params);

    @Override
    void remove(LoteExistencia entity, String usuario);
    
}
