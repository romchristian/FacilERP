/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.contabilidad.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author elias
 */
@FacesConverter(forClass = Proveedor.class)
public class ProveedorConverter extends ConverterGenerico<Proveedor> {

    @Override
    public String getBeanName() {
        return "proveedorBean";
    }

}
