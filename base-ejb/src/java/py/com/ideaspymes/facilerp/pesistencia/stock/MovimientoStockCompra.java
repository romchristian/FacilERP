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
public class MovimientoStockCompra extends MovimientoStock{
    private String comprobante;
    
    public MovimientoStockCompra() {
        setTipo(TipoMovimientoStock.ENTRADA);
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }
    
    
    
}
