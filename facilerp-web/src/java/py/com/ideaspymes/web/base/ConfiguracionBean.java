/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.web.base;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import py.com.ideaspymes.facilerp.business.interfaces.IConfiguracionDAO;
import py.com.ideaspymes.facilerp.generico.AbstractDAO;
import py.com.ideaspymes.facilerp.generico.QueryParameter;

import py.com.ideaspymes.web.generico.BeanGenerico;
import py.com.ideaspymes.facilerp.pesistencia.base.Configuracion;
import py.com.ideaspymes.web.generico.Credencial;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ConfiguracionBean extends BeanGenerico<Configuracion> implements Serializable {

    @Inject
    private Credencial credencial;

    @EJB
    private IConfiguracionDAO ejb;
    private List<Configuracion> configuracionesStock;

    @Override
    public AbstractDAO<Configuracion> getEjb() {
        return ejb;
    }

    @Override
    public Configuracion getNuevo() {
        return new Configuracion();
    }

    public SelectItem[] getItemsOpciones(String opciones) {
        SelectItem[] items = null;
        if (opciones != null) {
            String[] ops = opciones.split(",");
            items = new SelectItem[ops.length];
            for (int i = 0; i < ops.length; i++) {
                items[i] = new SelectItem(ops[i], ops[i]);
            }
        }
        return items;
    }

    public List<Configuracion> getConfiguracionesStock() {
        if (configuracionesStock == null) {
            configuracionesStock = ejb.findAll("select c from Configuracion c where c.modulo = :modulo",
                    QueryParameter.where("modulo", "stock"));
        }
        return configuracionesStock;
    }

    public void setConfiguracionesStock(List<Configuracion> configuracionesStock) {
        this.configuracionesStock = configuracionesStock;
    }

    public void guardaConfiguracionStock() {
        for (Configuracion c : configuracionesStock) {
            ejb.edit(c, credencial.getUsuario().getUsuario());
        }
    }
}
