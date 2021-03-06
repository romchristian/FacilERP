/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;

/**
 *
 * @author Acer
 */
@Entity
public class FacturaVentaDetalle implements Serializable,Auditable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @ManyToOne
    private FacturaVenta facturaVenta;
    private int nrolinea;
    private BigDecimal cantidad;
    private String descripcion;
    private BigDecimal precioUnitario;
    private BigDecimal impuesto = new BigDecimal(10);
    private BigDecimal exenta;
    private BigDecimal gravada05;
    private BigDecimal gravada10;
    

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public int getNrolinea() {
        return nrolinea;
    }

    public void setNrolinea(int nrolinea) {
        this.nrolinea = nrolinea;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getExenta() {
        return exenta;
    }

    public void setExenta(BigDecimal exenta) {
        this.exenta = exenta;
    }

    public BigDecimal getGravada05() {
        return gravada05;
    }

    public void setGravada05(BigDecimal gravada05) {
        this.gravada05 = gravada05;
    }

    public BigDecimal getGravada10() {
        return gravada10;
    }

    public void setGravada10(BigDecimal gravada10) {
        this.gravada10 = gravada10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVentaDetalle)) {
            return false;
        }
        FacturaVentaDetalle other = (FacturaVentaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_CONTABILIDAD;
    }
}
