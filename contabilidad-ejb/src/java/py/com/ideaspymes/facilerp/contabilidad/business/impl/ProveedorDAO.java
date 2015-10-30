/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.contabilidad.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.contabilidad.business.interfaces.IProveedorDAO;
import py.com.ideaspymes.facilerp.pesistencia.contabilidad.Proveedor;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProveedorDAO implements IProveedorDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Proveedor create(Proveedor entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Proveedor edit(Proveedor entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Proveedor entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Proveedor find(Object id) {
        return abmService.find(id, Proveedor.class);
    }

    @Override
    public List<Proveedor> findAll() {
        return abmService.getEM().createQuery("select obj from Proveedor obj").getResultList();
    }

    @Override
    public List<Proveedor> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
