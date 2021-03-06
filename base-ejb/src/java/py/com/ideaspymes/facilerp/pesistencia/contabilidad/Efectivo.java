/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.contabilidad;

import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 *
 * @author christian
 */
@Entity
public class Efectivo extends AplicacionPago{

    private BigDecimal montoPagado;
    private BigDecimal cambio;

    public Efectivo() {
        super.setDescripcion("EFECTIVO");
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public BigDecimal getCambio() {
        if (montoPagado != null && getMonto() != null) {
            cambio = montoPagado.subtract(getMonto());
        }
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

}
