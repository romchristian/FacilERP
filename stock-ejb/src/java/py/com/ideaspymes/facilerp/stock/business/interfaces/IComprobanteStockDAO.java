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
import py.com.ideaspymes.facilerp.generico.exceptions.SinDetallesException;
import py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;

/**
 *
 * @author Acer
 */
@Local
public interface IComprobanteStockDAO extends AbstractDAO<ComprobanteStock> {

    @Override
    ComprobanteStock create(ComprobanteStock entity, String usuario);

    ComprobanteStock create(ComprobanteStock entity, List<LoteExistencia> lotes,String usuario)  throws SinDetallesException;

    @Override
    ComprobanteStock edit(ComprobanteStock entity, String usuario);

    @Override
    ComprobanteStock find(Object id);

    @Override
    List<ComprobanteStock> findAll();

    @Override
    List<ComprobanteStock> findAll(String query, QueryParameter params);

    @Override
    void remove(ComprobanteStock entity, String usuario);

}
