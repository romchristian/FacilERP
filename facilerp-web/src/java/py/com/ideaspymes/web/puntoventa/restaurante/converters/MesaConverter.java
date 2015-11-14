/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.restaurante.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.restaurant.Mesa;

import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Mesa.class)
public class MesaConverter extends ConverterGenerico<Mesa> {

    @Override
    public String getBeanName() {
        return "mesaBean";
    }

}
