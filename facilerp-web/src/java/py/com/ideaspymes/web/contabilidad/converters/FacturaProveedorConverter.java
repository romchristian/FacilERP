/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.FacturaProveedor;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author elias
 */
@FacesConverter(forClass = FacturaProveedor.class)
public class FacturaProveedorConverter extends ConverterGenerico<FacturaProveedor> {

    @Override
    public String getBeanName() {
        return "facturaProveedorBean";
    }

}
