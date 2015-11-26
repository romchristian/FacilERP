/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad.converters;


import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.MedioPago;


import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = MedioPago.class)
public class MedioPagoConverter extends ConverterGenerico<MedioPago> {

    @Override
    public String getBeanName() {
        return "medioPagoBean";
    }

}
