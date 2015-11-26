/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base.converters;

import py.com.ideaspymes.web.generico.ConverterGenerico;
import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.base.Moneda;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Moneda.class)
public class MonedaConverter extends ConverterGenerico<Moneda>{

    @Override
    public String getBeanName() {
        return "monedaBean";
    }
}
