/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = UnidadMedida.class)
public class UnidadMedidaConverter extends ConverterGenerico<UnidadMedida> {

    @Override
    public String getBeanName() {
        return "unidadMedidaBean";
    }

}
