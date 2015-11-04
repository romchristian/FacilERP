/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.contabilidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.pesistencia.base.Auditable;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;

/**
 *
 * @author Acer
 */
@Entity
public class DetFacturaProveedor implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;    
    @ManyToOne
    private FacturaProveedor facturaProveedor;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private UnidadMedida unidadMedida;
    private Double cantidad;
    private Double precioUnitario;
    private Double totalGravada10;
    private Double totalGravada5;
    private Double totalIva;
    private Double totalIva10;
    private Double totalIva5;
    private Double totalExcenta;
    private Double total;
    private Double descuento;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public FacturaProveedor getFacturaProveedor() {
        return facturaProveedor;
    }

    public void setFacturaProveedor(FacturaProveedor facturaProveedor) {
        this.facturaProveedor = facturaProveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalGravada10() {
        return totalGravada10;
    }

    public void setTotalGravada10(Double totalGravada10) {
        this.totalGravada10 = totalGravada10;
    }

    public Double getTotalGravada5() {
        return totalGravada5;
    }

    public void setTotalGravada5(Double totalGravada5) {
        this.totalGravada5 = totalGravada5;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Double getTotalIva10() {
        return totalIva10;
    }

    public void setTotalIva10(Double totalIva10) {
        this.totalIva10 = totalIva10;
    }

    public Double getTotalIva5() {
        return totalIva5;
    }

    public void setTotalIva5(Double totalIva5) {
        this.totalIva5 = totalIva5;
    }

    public Double getTotalExcenta() {
        return totalExcenta;
    }

    public void setTotalExcenta(Double totalExcenta) {
        this.totalExcenta = totalExcenta;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
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
        if (!(object instanceof DetFacturaProveedor)) {
            return false;
        }
        DetFacturaProveedor other = (DetFacturaProveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.contabilidad.DetFacturaProveedor[ id=" + id + " ]";
    }

}
