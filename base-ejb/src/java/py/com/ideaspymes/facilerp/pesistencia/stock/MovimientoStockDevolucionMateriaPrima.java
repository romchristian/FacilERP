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
public class MovimientoStockDevolucionMateriaPrima extends MovimientoStock {

   

    public MovimientoStockDevolucionMateriaPrima() {
        setTipo(TipoMovimientoStock.ENTRADA);
    }

  
    @Override
    public Double cantidadAAfectar() {
        return (getCantidad() == null ? 0d : getCantidad())*-1;
    }

}
