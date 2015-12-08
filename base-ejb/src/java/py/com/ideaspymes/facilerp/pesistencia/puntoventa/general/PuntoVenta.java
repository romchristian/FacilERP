/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.puntoventa.general;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;
import py.com.ideaspymes.facilerp.pesistencia.base.Secuencia;
import py.com.ideaspymes.facilerp.pesistencia.base.Usuario;

/**
 *
 * @author Acer
 */
@Entity
public class PuntoVenta implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String nombre;
    @ManyToOne
    private Secuencia secuencia;
    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PuntoVenta other = (PuntoVenta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_PUNTO_VENTA;
    }
    
}
