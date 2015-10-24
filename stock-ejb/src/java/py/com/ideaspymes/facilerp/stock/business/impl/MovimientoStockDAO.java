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
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IMovimientoStockDAO;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MovimientoStockDAO implements IMovimientoStockDAO {

    @EJB
    private ABMService abms;

    @Override
    public void creaMovimientoStock(MovimientoStock m) {
        abms.getEM().merge(m);
        Producto p = m.getProducto();
        afectaStock(p, m.cantidadAAfectar());
    }

    private void afectaStock(Producto p, Double cantidadAAfectar) {
        if (p != null) {
            Double stockActual = p.getStock() == null ? 0d : p.getStock();
            p.setStock(stockActual + cantidadAAfectar);
            abms.getEM().merge(p);
        }
    }

}
