/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.general.converters;


import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.PuntoVenta;


import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = PuntoVenta.class)
public class PuntoVentaConverter extends ConverterGenerico<PuntoVenta> {

    @Override
    public String getBeanName() {
        return "puntoVentaBean";
    }

}
