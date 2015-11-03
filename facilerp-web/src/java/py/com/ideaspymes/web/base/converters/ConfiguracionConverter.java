/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base.converters;

import py.com.ideaspymes.web.generico.ConverterGenerico;
import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.base.Configuracion;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Configuracion.class)
public class ConfiguracionConverter extends ConverterGenerico<Configuracion>{

    @Override
    public String getBeanName() {
        return "configuracionBean";
    }
}
