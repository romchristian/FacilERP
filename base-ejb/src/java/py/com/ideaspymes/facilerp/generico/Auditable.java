/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.generico;

/**
 *
 * @author Acer
 */
public interface Auditable {
    Long getId();
    Long getVersion();
    String getNombreModulo();
}