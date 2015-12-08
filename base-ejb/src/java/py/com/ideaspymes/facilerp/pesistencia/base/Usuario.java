/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.base;


import py.com.ideaspymes.facilerp.generico.Auditable;
import py.com.ideaspymes.facilerp.generico.Encryptador;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;


/**
 *
 * @author elias
 */
@Entity
public class Usuario implements Serializable, Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String nombres;
    private String apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    @NotNull
    private String usuario;
    @NotNull
    private String clave;
    @ManyToOne
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @Transient
    private String plainClave;

    public Usuario() {
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


    public String getPlainClave() {
        return plainClave;
    }

    public void setPlainClave(String plainClave) {
        this.plainClave = plainClave;
    }   

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        
        this.clave = Encryptador.encrypta(clave);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return this.nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getNombreModulo() {
       return ConfigModulo.MODULO_BASE;
    }

      
    
}
