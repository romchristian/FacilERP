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
import py.com.ideaspymes.facilerp.pesistencia.base.Secuencia;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface ISecuenciaDAO extends AbstractDAO<Secuencia> {

    @Override
    Secuencia create(Secuencia entity, String usuario);

    @Override
    Secuencia edit(Secuencia entity, String usuario);

    @Override
    Secuencia find(Object id);

    @Override
    List<Secuencia> findAll();

    @Override
    List<Secuencia> findAll(String query, QueryParameter params);

    @Override
    void remove(Secuencia entity, String usuario);
    
}
