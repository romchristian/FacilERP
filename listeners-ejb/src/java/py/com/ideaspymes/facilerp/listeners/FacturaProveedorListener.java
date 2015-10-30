/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.listeners;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFP;
import py.com.ideaspymes.facilerp.contabilidad.business.impl.EventoFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaService;

/**
 *
 * @author cromero
 */
@Stateless
@LocalBean
public class FacturaProveedorListener {

    @EJB
    private ILoteExistenciaService loteExistenciaService;

    public void creacionFacturaProveedor(@Observes(during = TransactionPhase.AFTER_SUCCESS) @EventoFP EventoFacturaProveedor event) {
        System.out.println("En el listener : " + event.getFacturaProveedor());
        if (event.getFacturaProveedor() != null) {
            for (DetFacturaProveedor d : event.getFacturaProveedor().getDetalles()) { 
                if (d.getProducto().isInventariable() && (d.getProducto().isTieneVencimiento() || d.getProducto().isCostoCalculado())) {
                    LoteExistencia l = new LoteExistencia();
                    l.setEstado(EstadoLote.PENDIENTE_CONFIRMACION);
                    l.setIngreso(new Date());
                    l.setProducto(d.getProducto());
                    l.setUnidadMedida(d.getUnidadMedida());
                    l.setCantidadIngresada(d.getCantidad());
                    l.setCantidadSaldo(d.getCantidad());
                    l.setCosto(d.getPrecioUnitario());
                    l.setRefFactura(event.getFacturaProveedor().getClass().getName()+":"+event.getFacturaProveedor().getId());
//                    l.setRefProveedor(event.getFacturaProveedor().getProveedor().getClass().getName()+":"+event.getFacturaProveedor().getProveedor().getId());
                    loteExistenciaService.creaLoteExitencia(l);
                }
            }
        }

    }
}
