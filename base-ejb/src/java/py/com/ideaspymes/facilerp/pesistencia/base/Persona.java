/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.base;

import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.TipoDocumento;

/**
 *
 * @author christian
 */
@Entity
public class Persona implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Column(updatable = false)
    private String nroDocumento;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private Sucursal sucursal;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vigencia;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Override
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

    public Persona() {
        this.estado = Estado.ACTIVO;
    }

    public Persona(TipoDocumento tipoDocumento, String nroDocumento) {
        this();
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if ((this.nroDocumento == null) ? (other.nroDocumento != null) : !this.nroDocumento.equals(other.nroDocumento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.nroDocumento != null ? this.nroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.base.Persona[ id=" + id + " ]";
    }
}
