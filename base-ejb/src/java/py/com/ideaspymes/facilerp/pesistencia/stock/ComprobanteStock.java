/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.stock;

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
import py.com.ideaspymes.facilerp.pesistencia.base.Usuario;
import py.com.ideaspymes.facilerp.pesistencia.stock.enums.TipoComprobanteStock;

/**
 *
 * @author Acer
 */
@Entity
public class ComprobanteStock implements Serializable, Auditable {

    @OneToMany(mappedBy = "comprobanteStock",cascade = CascadeType.PERSIST)
    private List<DetComprobanteStock> detalles;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Enumerated(EnumType.STRING)
    private TipoComprobanteStock tipo;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    private String refOrigen;// Debe ser Entidad:id ej.: "Cliente:123" o "Deposito:1":
    private String refDestino;
    @ManyToOne
    private Usuario usuario;
    private String refDocumento;

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

    public TipoComprobanteStock getTipo() {
        return tipo;
    }

    public void setTipo(TipoComprobanteStock tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRefOrigen() {
        return refOrigen;
    }

    public void setRefOrigen(String refOrigen) {
        this.refOrigen = refOrigen;
    }

    public String getRefDestino() {
        return refDestino;
    }

    public void setRefDestino(String refDestino) {
        this.refDestino = refDestino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetComprobanteStock> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetComprobanteStock> detalles) {
        this.detalles = detalles;
    }

    public String getRefDocumento() {
        return refDocumento;
    }

    public void setRefDocumento(String refDocumento) {
        this.refDocumento = refDocumento;
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
        if (!(object instanceof ComprobanteStock)) {
            return false;
        }
        ComprobanteStock other = (ComprobanteStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.stock.ComprobanteStock[ id=" + id + " ]";
    }

}
