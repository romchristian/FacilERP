/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.base;

import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author christian
 */
@Entity
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String ruc;
    private Integer dv;
    private String razonSocial;
    private String rucRepLegal;
    private Integer dvRepLegal;
    private String nombreRepLegal;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;

    public Empresa() {
        this.estado = Estado.ACTIVO;
    }

    public Empresa(String razonSocial, String ruc) {
        this();
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }

    public Empresa(String ruc, Integer dv, String razonSocial, String rucRepLegal, Integer dvRepLegal, String nombreRepLegal) {
        this(razonSocial, ruc);
        this.dv = dv;
        this.rucRepLegal = rucRepLegal;
        this.dvRepLegal = dvRepLegal;
        this.nombreRepLegal = nombreRepLegal;
    }

    public Integer getDv() {
        return dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }

    public String getRucRepLegal() {
        return rucRepLegal;
    }

    public void setRucRepLegal(String rucRepLegal) {
        this.rucRepLegal = rucRepLegal;
    }

    public Integer getDvRepLegal() {
        return dvRepLegal;
    }

    public void setDvRepLegal(Integer dvRepLegal) {
        this.dvRepLegal = dvRepLegal;
    }

    public String getNombreRepLegal() {
        return nombreRepLegal;
    }

    public void setNombreRepLegal(String nombreRepLegal) {
        this.nombreRepLegal = nombreRepLegal;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return razonSocial;
    }
}
