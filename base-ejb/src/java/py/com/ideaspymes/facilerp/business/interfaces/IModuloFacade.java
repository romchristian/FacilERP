/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.business.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.ideaspymes.facilerp.pesistencia.base.Modulo;
import py.com.ideaspymes.facilerp.pesistencia.base.Pantalla;

/**
 *
 * @author Acer
 */
@Local
public interface IModuloFacade {

    void inicializaModulos();

    List<Modulo> findModulos();

    List<Pantalla> findPantallas(Modulo m);
}
