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
import py.com.ideaspymes.facilerp.pesistencia.base.Impuesto;





/**
 *
 * @author Acer
 */
@Local
public interface IImpuestoDAO extends AbstractDAO<Impuesto> {

    @Override
    Impuesto create(Impuesto entity, String usuario);

    @Override
    Impuesto edit(Impuesto entity, String usuario);

    @Override
    Impuesto find(Object id);

    @Override
    List<Impuesto> findAll();

    @Override
    List<Impuesto> findAll(String query, QueryParameter params);

    @Override
    void remove(Impuesto entity, String usuario);
    
}
