/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock.converters;

import javax.faces.convert.FacesConverter;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.web.generico.ConverterGenerico;

/**
 *
 * @author elias
 */
@FacesConverter(forClass = Producto.class, value = "productoConverter")
public class ProductoConverter extends ConverterGenerico<Producto> {

    @Override
    public String getBeanName() {
        return "productoBean";
    }

}
