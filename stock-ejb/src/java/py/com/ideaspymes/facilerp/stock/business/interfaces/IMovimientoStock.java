/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.interfaces;

import javax.ejb.Local;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;

/**
 *
 * @author Acer
 */


@Local
public interface IMovimientoStock {
    public void creaMovimientoStockVenta(Producto producto, Double cantidad,  UnidadMedida unidadMedida,String comprobante);
}
