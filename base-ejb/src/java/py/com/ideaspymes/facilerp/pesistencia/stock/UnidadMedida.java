/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.ideaspymes.facilerp.pesistencia.stock;

import java.io.Serializable;
import javax.persistence.*;
import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;



/**
 *
 * @author christian
 */
@Entity
public class UnidadMedida implements Serializable, Auditable{
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Version
    private Long version;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public UnidadMedida() {
        this.estado = Estado.ACTIVO;
    }

    public UnidadMedida(String nombre) {
        this();
        this.nombre = nombre;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_STOCK;
    }
}
