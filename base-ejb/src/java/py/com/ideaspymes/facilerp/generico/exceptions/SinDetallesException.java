/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.generico.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Acer
 */
@ApplicationException(rollback = true)
public class SinDetallesException extends Exception {

    public SinDetallesException() {
        super("No hay detalles que guardar!");
    }

}
