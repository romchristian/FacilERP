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
import py.com.ideaspymes.facilerp.pesistencia.base.Cotizacion;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface ICotizacionDAO extends AbstractDAO<Cotizacion> {

    @Override
    Cotizacion create(Cotizacion entity, String usuario);

    @Override
    Cotizacion edit(Cotizacion entity, String usuario);

    @Override
    Cotizacion find(Object id);

    @Override
    List<Cotizacion> findAll();

    @Override
    List<Cotizacion> findAll(String query, QueryParameter params);

    @Override
    void remove(Cotizacion entity, String usuario);
    
}
