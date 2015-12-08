/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.base;

import py.com.ideaspymes.facilerp.generico.Auditable;
import java.io.Serializable;
import javax.persistence.*;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;

/**
 *
 * @author elias
 */
@Entity
public class Categoria implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;

    private float ddm;
    private float promAtrazo;
    private float maxAtrazo;
    private int cantidadDePagos;//debe ser por lo menos mayor a 4

    public Categoria() {
    }

    public Categoria(float ddm, float promAtrazo, float maxAtrazo, int cantidadDePagos) {
        this.ddm = ddm;
        this.promAtrazo = promAtrazo;
        this.maxAtrazo = maxAtrazo;
        this.cantidadDePagos = cantidadDePagos;
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

    public float getDdm() {
        return ddm;
    }

    public void setDdm(float ddm) {
        this.ddm = ddm;
    }

    public float getPromAtrazo() {
        return promAtrazo;
    }

    public void setPromAtrazo(float promAtrazo) {
        this.promAtrazo = promAtrazo;
    }

    public float getMaxAtrazo() {
        return maxAtrazo;
    }

    public void setMaxAtrazo(float maxAtrazo) {
        this.maxAtrazo = maxAtrazo;
    }

    public int getCantidadDePagos() {
        return cantidadDePagos;
    }

    public void setCantidadDePagos(int cantidadDePagos) {
        this.cantidadDePagos = cantidadDePagos;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String getNombreModulo() {
        return ConfigModulo.MODULO_BASE;
    }

}
