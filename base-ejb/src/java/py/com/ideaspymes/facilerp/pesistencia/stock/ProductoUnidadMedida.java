/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.stock;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;

/**
 *
 * @author Acer
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"producto_id","unidadmedidade_id","unidadmedidaa_id"}))
public class ProductoUnidadMedida implements Serializable, Auditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private UnidadMedida unidadMedidaDe;
    @ManyToOne
    private UnidadMedida unidadMedidaA;
    private Double cantidadDe;
    private Double cantidadA;
    
    

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public UnidadMedida getUnidadMedidaDe() {
        return unidadMedidaDe;
    }

    public void setUnidadMedidaDe(UnidadMedida unidadMedidaDe) {
        this.unidadMedidaDe = unidadMedidaDe;
    }

    public UnidadMedida getUnidadMedidaA() {
        return unidadMedidaA;
    }

    public void setUnidadMedidaA(UnidadMedida unidadMedidaA) {
        this.unidadMedidaA = unidadMedidaA;
    }

    public Double getCantidadDe() {
        return cantidadDe;
    }

    public void setCantidadDe(Double cantidadDe) {
        this.cantidadDe = cantidadDe;
    }

    public Double getCantidadA() {
        return cantidadA;
    }

    public void setCantidadA(Double cantidadA) {
        this.cantidadA = cantidadA;
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
        if (!(object instanceof ProductoUnidadMedida)) {
            return false;
        }
        ProductoUnidadMedida other = (ProductoUnidadMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.stock.persistencia.ProductoUnidadMedida[ id=" + id + " ]";
    }

    @Override
    public Long getVersion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_STOCK;
    }
}
