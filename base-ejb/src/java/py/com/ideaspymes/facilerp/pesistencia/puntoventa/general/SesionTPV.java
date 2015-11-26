/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.puntoventa.general;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.pesistencia.base.Auditable;
import py.com.ideaspymes.facilerp.pesistencia.base.Usuario;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.enums.EstadoSesionTPV;

/**
 *
 * @author Acer
 */
@Entity
public class SesionTPV implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private PuntoVenta puntoVenta;
    @Enumerated(EnumType.STRING)
    private EstadoSesionTPV estado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaApertura;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCierre;
    private BigDecimal saldoInicial;
    private BigDecimal saldoCierre;
    private BigDecimal diferencia;
    private BigDecimal totalTransacciones;

    private boolean cerrarConDiferencia;

    public SesionTPV() {
        fechaApertura = new Date();
        estado = EstadoSesionTPV.NUEVA;
    }

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

    public BigDecimal getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(BigDecimal diferencia) {
        this.diferencia = diferencia;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public EstadoSesionTPV getEstado() {
        return estado;
    }

    public void setEstado(EstadoSesionTPV estado) {
        this.estado = estado;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoCierre() {
        return saldoCierre;
    }

    public void setSaldoCierre(BigDecimal saldoCierre) {
        this.saldoCierre = saldoCierre;
    }

    public BigDecimal getTotalTransacciones() {
        return totalTransacciones;
    }

    public void setTotalTransacciones(BigDecimal totalTransacciones) {
        this.totalTransacciones = totalTransacciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isCerrarConDiferencia() {
        return cerrarConDiferencia;
    }

    public void setCerrarConDiferencia(boolean cerrarConDiferencia) {
        this.cerrarConDiferencia = cerrarConDiferencia;
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
        if (!(object instanceof SesionTPV)) {
            return false;
        }
        SesionTPV other = (SesionTPV) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.syscvsa.puntoventa.persisitencia.SesionTPV[ id=" + id + " ]";
    }
}
