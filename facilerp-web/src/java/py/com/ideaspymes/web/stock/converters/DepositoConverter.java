/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author elias
 */
@FacesConverter(forClass = Deposito.class)
public class DepositoConverter extends ConverterGenerico<Deposito> {

    @Override
    public String getBeanName() {
        return "familiaBean";
    }

}
