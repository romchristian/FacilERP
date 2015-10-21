/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStockVenta;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IMovimientoStock;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MovimientoStockDAO implements IMovimientoStock {

    @EJB
    private ABMService abms;
    @Override
    public void creaMovimientoStockVenta(Producto producto, Double cantidad, UnidadMedida unidadMedida,String comprobante) {
        MovimientoStockVenta m = new MovimientoStockVenta();
        m.setProducto(producto);
        m.setCantidad(cantidad);
        m.setComprobante(comprobante);
        m.setUnidadMedida(unidadMedida);
        abms.getEM().merge(m);
    }
}
