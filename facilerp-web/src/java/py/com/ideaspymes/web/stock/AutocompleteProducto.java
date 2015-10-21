/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.base.enums.Estado;
import py.com.ideaspymes.facilerp.pesistencia.stock.Producto;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IProductoDAO;

/**
 *
 * @author cromero
 */
@Named
@ViewScoped
public class AutocompleteProducto implements Serializable {

    @EJB
    private IProductoDAO dao;
    private List<Producto> lista;

    public void carga() {
        QueryParameter qp = new QueryParameter();
        qp.and("estado", Estado.ACTIVO);
        lista = dao.findAll("SELECT p FROM Producto p WHERE p.estado = :estado", qp);
    }

    public List<Producto> getLista() {
        if (lista == null) {
            carga();
        }
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public List<Producto> completar(String query) {
        List<Producto> sugerencias = new ArrayList<>();

        for (Producto p : getLista()) {
            String cadenaAComparar = p.getNombre();
            if (cadenaAComparar.trim().toUpperCase().contains(query.toUpperCase().trim())) {
                sugerencias.add(p);
            }
        }

        return sugerencias;
    }

}
