/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.stock;

import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoMovimientoStock;
import javax.persistence.Entity;

/**
 *
 * @author Acer
 */
@Entity
public class MovimientoStockConsumoMateriaPrima extends MovimientoStock {

   

    public MovimientoStockConsumoMateriaPrima() {
        setTipo(TipoMovimientoStock.SALIDA);
    }


    @Override
    public Double cantidadAAfectar() {
        return (getCantidad() == null ? 0d : getCantidad())*-1;
    }

}
