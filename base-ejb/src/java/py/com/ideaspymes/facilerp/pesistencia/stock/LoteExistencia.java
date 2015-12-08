/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.stock;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.EstadoLote;

/**
 *
 * @author cromero
 */
@Entity
public class LoteExistencia implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String codigo;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ingreso;
    private String ubicacion;
    private String refProveedor;
    private String refFactura;
    @ManyToOne
    private ComprobanteStock comprobanteStock;
    @ManyToOne
    private Deposito deposito;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private UnidadMedida unidadMedida;
    private Double cantidadIngresada;
    private Double cantidadUsada;
    private Double cantidadReservada;
    private Double cantidadSaldo;
    private Double costo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date elaboracion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencimiento;
    @Enumerated(EnumType.STRING)
    private EstadoLote estado;
    @Transient
    private boolean seleccionado = false;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ComprobanteStock getComprobanteStock() {
        return comprobanteStock;
    }

    public void setComprobanteStock(ComprobanteStock comprobanteStock) {
        this.comprobanteStock = comprobanteStock;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
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

    public Double getCantidadIngresada() {
        return cantidadIngresada;
    }

    public void setCantidadIngresada(Double cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    public Double getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(Double cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    public Double getCantidadSaldo() {
        return cantidadSaldo;
    }

    public void setCantidadSaldo(Double cantidadSaldo) {
        this.cantidadSaldo = cantidadSaldo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Date elaboracion) {
        this.elaboracion = elaboracion;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Double getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(Double cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }

    public EstadoLote getEstado() {
        return estado;
    }

    public void setEstado(EstadoLote estado) {
        this.estado = estado;
    }

    public String getRefProveedor() {
        return refProveedor;
    }

    public void setRefProveedor(String refProveedor) {
        this.refProveedor = refProveedor;
    }

    public String getRefFactura() {
        return refFactura;
    }

    public void setRefFactura(String refFactura) {
        this.refFactura = refFactura;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
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
        if (!(object instanceof LoteExistencia)) {
            return false;
        }
        LoteExistencia other = (LoteExistencia) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return codigo;
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_STOCK;
    }
}
