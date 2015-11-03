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
import py.com.ideaspymes.facilerp.pesistencia.base.Configuracion;





/**
 *
 * @author Acer
 */
@Local
public interface IConfiguracionDAO extends AbstractDAO<Configuracion> {

    @Override
    Configuracion create(Configuracion entity, String usuario);

    @Override
    Configuracion edit(Configuracion entity, String usuario);

    @Override
    Configuracion find(Object id);

    @Override
    List<Configuracion> findAll();

    @Override
    List<Configuracion> findAll(String query, QueryParameter params);

    @Override
    void remove(Configuracion entity, String usuario);
    
    String getValor(String modulo, String nombre);
    
}
