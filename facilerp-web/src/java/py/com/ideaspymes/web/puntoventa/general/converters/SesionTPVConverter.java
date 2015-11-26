/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.puntoventa.general.converters;


import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.puntoventa.general.SesionTPV;


import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = SesionTPV.class)
public class SesionTPVConverter extends ConverterGenerico<SesionTPV> {

    @Override
    public String getBeanName() {
        return "sesionBean";
    }

}
