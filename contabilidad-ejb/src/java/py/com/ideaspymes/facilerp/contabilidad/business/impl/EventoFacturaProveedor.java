/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.contabilidad.business.impl;

import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;

/**
 *
 * @author Acer
 */
public class EventoFacturaProveedor {

    private FacturaProveedor facturaProveedor;

    public EventoFacturaProveedor() {
    }

    public EventoFacturaProveedor(FacturaProveedor facturaProveedor) {
        this.facturaProveedor = facturaProveedor;
    }

    public FacturaProveedor getFacturaProveedor() {
        return facturaProveedor;
    }

    public void setFacturaProveedor(FacturaProveedor facturaProveedor) {
        this.facturaProveedor = facturaProveedor;
    }

}
