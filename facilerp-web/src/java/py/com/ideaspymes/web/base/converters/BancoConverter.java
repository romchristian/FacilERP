/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base.converters;

import py.com.ideaspymes.web.generico.ConverterGenerico;
import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.base.Banco;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Banco.class)
public class BancoConverter extends ConverterGenerico<Banco>{

    @Override
    public String getBeanName() {
        return "bancoBean";
    }
}
