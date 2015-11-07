/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author elias
 */
@FacesConverter(forClass = LoteExistencia.class)
public class LoteExistenciaConverter extends ConverterGenerico<LoteExistencia> {

    @Override
    public String getBeanName() {
        return "loteExistenciaBean";
    }

}
