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
import py.com.ideaspymes.facilerp.pesistencia.base.Auditoria;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface IAuditoriaDAO extends AbstractDAO<Auditoria> {

    @Override
    Auditoria create(Auditoria entity, String usuario);

    @Override
    Auditoria edit(Auditoria entity, String usuario);

    @Override
    Auditoria find(Object id);

    @Override
    List<Auditoria> findAll();

    @Override
    List<Auditoria> findAll(String query, QueryParameter params);

    @Override
    void remove(Auditoria entity, String usuario);
    
}
