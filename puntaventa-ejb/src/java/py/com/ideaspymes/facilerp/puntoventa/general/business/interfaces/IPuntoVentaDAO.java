/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.puntoventa.general.business.interfaces;


import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.PuntoVenta;







/**
 *
 * @author Acer
 */
@Local
public interface IPuntoVentaDAO extends AbstractDAO<PuntoVenta> {

    @Override
    PuntoVenta create(PuntoVenta entity, String usuario);

    @Override
    PuntoVenta edit(PuntoVenta entity, String usuario);

    @Override
    PuntoVenta find(Object id);

    @Override
    List<PuntoVenta> findAll();

    @Override
    List<PuntoVenta> findAll(String query, QueryParameter params);

    @Override
    void remove(PuntoVenta entity, String usuario);
    
}
