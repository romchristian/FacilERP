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
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;







/**
 *
 * @author Acer
 */
@Local
public interface ISesionTPVDAO extends AbstractDAO<SesionTPV> {

    @Override
    SesionTPV create(SesionTPV entity, String usuario);

    @Override
    SesionTPV edit(SesionTPV entity, String usuario);

    @Override
    SesionTPV find(Object id);

    @Override
    List<SesionTPV> findAll();

    @Override
    List<SesionTPV> findAll(String query, QueryParameter params);

    @Override
    void remove(SesionTPV entity, String usuario);
    
}
