/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.pesistencia.stock.Ingrediente;
import py.com.ideaspymes.facilerp.pesistencia.stock.MovimientoStock;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoProducto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IMovimientoStock;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MovimientoStockDAO implements IMovimientoStock {

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
            /** 
             * En caso de que el producto sea un trago elaborado en el mostrador
             * no debería afectar al stock del trago, sino solo a sus ingredientes
             */
            if (p.getTipoProducto() != TipoProducto.ELABORACION_EN_CANTINA) {
                p.setStock(stockActual + cantidadAAfectar);
                abms.getEM().merge(p);
            }
            /**
             * Solo se afecta los ingredientes de los tragos elaborados en mostrador
             * y en caso de que exista otros tipos de productos de esta índole
             */
            if (p.getTipoProducto() == TipoProducto.ELABORACION_EN_CANTINA) {
                afectarStockIngredientes(p.getIngredientes(), cantidadAAfectar);
            }
        }
    }

    private void afectarStockIngredientes(List<Ingrediente> ingredientes, Double cantidadAAfectar) {
        if (ingredientes != null && cantidadAAfectar != null && cantidadAAfectar > 0) {

            for (Ingrediente i : ingredientes) {
                Double stockActual = i.getProducto().getStock() == null ? 0d : i.getProducto().getStock();
                Double cant = i.getCantidad() * cantidadAAfectar;
                i.getProducto().setStock(stockActual + cant);
            }
        }
    }
}
