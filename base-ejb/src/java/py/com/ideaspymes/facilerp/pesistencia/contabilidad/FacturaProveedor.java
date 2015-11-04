/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.contabilidad;

import py.com.ideaspymes.facilerp.pesistencia.contabilidad.enums.EstadoFacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.enums.TipoFactura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.pesistencia.base.Auditable;

/**
 *
 * @author Acer
 */
@Entity
public class FacturaProveedor implements Serializable, Auditable {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String timbrado;
    private String numero;
    private String establecimiento;
    private String puntoExpedicion;
    private String rucProveedor;
    @Enumerated(EnumType.STRING)
    private TipoFactura tipoFactura;
    private Integer cantidadCuotas;
    private EstadoFacturaProveedor estado;
    @ManyToOne
    private Proveedor proveedor;
    private Double totalGravada10;
    private Double totalGravada5;
    private Double totalIva;
    private Double totalIva10;
    private Double totalIva5;
    private Double totalExcenta;
    private Double total;
    private Double totalDescuento;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEmision;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCancelacion;
    @OneToMany(mappedBy = "facturaProveedor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetFacturaProveedor> detalles;

    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetFacturaProveedor> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetFacturaProveedor> detalles) {
        this.detalles = detalles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    
    
    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getPuntoExpedicion() {
        return puntoExpedicion;
    }

    public void setPuntoExpedicion(String puntoExpedicion) {
        this.puntoExpedicion = puntoExpedicion;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public EstadoFacturaProveedor getEstado() {
        return estado;
    }

    public void setEstado(EstadoFacturaProveedor estado) {
        this.estado = estado;
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

    public Double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        if (!(object instanceof FacturaProveedor)) {
            return false;
        }
        FacturaProveedor other = (FacturaProveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor[ id=" + id + " ]";
    }

}
