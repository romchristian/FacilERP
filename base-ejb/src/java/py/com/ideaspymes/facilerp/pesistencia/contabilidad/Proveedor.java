/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.pesistencia.contabilidad;

import javax.persistence.Entity;
import py.com.ideaspymes.facilerp.pesistencia.base.Persona;

/**
 *
 * @author Acer
 */
@Entity
public class Proveedor extends Persona {

    private String nombres;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return nombres;
    }
    
    
    
    
}
