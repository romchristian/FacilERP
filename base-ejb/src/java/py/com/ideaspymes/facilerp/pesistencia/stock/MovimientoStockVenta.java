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
public class MovimientoStockVenta extends MovimientoStock {

    private String comprobante;

    public MovimientoStockVenta() {
        setTipo(TipoMovimientoStock.SALIDA);
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public Double cantidadAAfectar() {
        return (getCantidad() == null ? 0d: getCantidad()) * -1;
    }

}
