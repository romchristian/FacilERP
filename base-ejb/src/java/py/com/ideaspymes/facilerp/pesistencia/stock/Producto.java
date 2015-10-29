/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import py.com.ideaspymes.facilerp.pesistencia.base.Auditable;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;
import py.com.ideaspymes.facilerp.pesistencia.base.Impuesto;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoCosto;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoProducto;

/**
 *
 * @author christian
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"codigo"}))
public class Producto implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String codigo;
    private String nombre;
    private TipoProducto tipoProducto;
    @ManyToOne
    private Impuesto impuesto;
    @Enumerated(EnumType.STRING)
    private TipoCosto tipoCosto;
    private boolean costoCalculado;
    private Double costoDirecto;
    private Double costoFifo;
    private Double costoLifo;
    private Double costoPonderado;
    private Double costo;
    private Double precioVenta;
    private boolean inventariable;
    private boolean vendible;
    private boolean tieneVencimiento;
    private Double stockMinimo;
    private Double stock;

    @ManyToOne
    private UnidadMedida unidadMedidaBase;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private boolean generarCodigo;

    @ManyToMany
    private List<Familia> familias;

    @Lob
    private byte[] imagen;
    @OneToMany(mappedBy = "productoPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes;

    public Producto() {
        this.estado = Estado.ACTIVO;
    }

    public Producto(Long id, String codigo, String nombre) {
        this();
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Producto(Long id, String codigo, String nombre, Impuesto iva, Double precioVenta) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.impuesto = iva;
        this.precioVenta = precioVenta;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public boolean isCostoCalculado() {
        return costoCalculado;
    }

    public void setCostoCalculado(boolean costoCalculado) {
        this.costoCalculado = costoCalculado;
    }

    public Double getCostoDirecto() {
        return costoDirecto;
    }

    public void setCostoDirecto(Double costoDirecto) {
        this.costoDirecto = costoDirecto;
    }

    public Double getCostoFifo() {
        return costoFifo;
    }

    public void setCostoFifo(Double costoFifo) {
        this.costoFifo = costoFifo;
    }

    public Double getCostoLifo() {
        return costoLifo;
    }

    public void setCostoLifo(Double costoLifo) {
        this.costoLifo = costoLifo;
    }

    public Double getCostoPonderado() {
        return costoPonderado;
    }

    public void setCostoPonderado(Double costoPonderado) {
        this.costoPonderado = costoPonderado;
    }

    public boolean isInventariable() {
        return inventariable;
    }

    public void setInventariable(boolean inventariable) {
        this.inventariable = inventariable;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto iva) {
        this.impuesto = iva;
    }

    public TipoCosto getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(TipoCosto tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    public Double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public UnidadMedida getUnidadMedidaBase() {
        return unidadMedidaBase;
    }

    public void setUnidadMedidaBase(UnidadMedida unidadMedidaBase) {
        this.unidadMedidaBase = unidadMedidaBase;
    }

    public List<Familia> getFamilias() {
        if (familias == null) {
            familias = new ArrayList<>();
        }
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public boolean isGenerarCodigo() {
        return generarCodigo;
    }

    public void setGenerarCodigo(boolean generarCodigo) {
        this.generarCodigo = generarCodigo;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public boolean isVendible() {
        return vendible;
    }

    public void setVendible(boolean vendible) {
        this.vendible = vendible;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isTieneVencimiento() {
        return tieneVencimiento;
    }

    public void setTieneVencimiento(boolean tieneVencimiento) {
        this.tieneVencimiento = tieneVencimiento;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gestionpymes.jpa.stock.Producto[id=" + id + "]";
    }
}
