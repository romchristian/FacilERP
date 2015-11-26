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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;







/**
 *
 * @author Acer
 */
@Local
public interface IMedioPagoDAO extends AbstractDAO<MedioPago> {

    @Override
    MedioPago create(MedioPago entity, String usuario);

    @Override
    MedioPago edit(MedioPago entity, String usuario);

    @Override
    MedioPago find(Object id);

    @Override
    List<MedioPago> findAll();

    @Override
    List<MedioPago> findAll(String query, QueryParameter params);

    @Override
    void remove(MedioPago entity, String usuario);
    
}
