/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.base;

import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;
import java.io.Serializable;
import javax.persistence.*;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;


/**
 *
 * @author christian
 */
@Entity
public class Moneda implements Serializable,Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String nombre;
    private String abreviacion;
    private int decimales;
    private boolean monedaLocal;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Moneda() {
        this.estado = Estado.ACTIVO;
    }

    public Moneda(String nombre, String abreviacion, int decimales, boolean monedaLocal) {
        this();
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.decimales = decimales;
        this.monedaLocal = monedaLocal;
    }



    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public int getDecimales() {
        return decimales;
    }

    public void setDecimales(int decimales) {
        this.decimales = decimales;
    }

    public boolean isMonedaLocal() {
        return monedaLocal;
    }

    public void setMonedaLocal(boolean monedaLocal) {
        this.monedaLocal = monedaLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
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
       return ConfigModulo.MODULO_BASE;
    }
}
