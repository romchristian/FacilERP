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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.Comprobante;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;







/**
 *
 * @author Acer
 */
@Local
public interface IComprobanteDAO extends AbstractDAO<Comprobante> {

    @Override
    Comprobante create(Comprobante entity, String usuario);
    
   
    Comprobante create(Comprobante entity, SesionTPV sesion, MedioPago medioPago,String usuario);

    @Override
    Comprobante edit(Comprobante entity, String usuario);

    @Override
    Comprobante find(Object id);

    @Override
    List<Comprobante> findAll();

    @Override
    List<Comprobante> findAll(String query, QueryParameter params);

    @Override
    void remove(Comprobante entity, String usuario);
    
}
