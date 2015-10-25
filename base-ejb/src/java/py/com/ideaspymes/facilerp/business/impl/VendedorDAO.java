/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.business.interfaces.IVendedorDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Vendedor;

/**
 *
 * @author Elias Melgarejo
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class VendedorDAO implements IVendedorDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Vendedor create(Vendedor entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Vendedor edit(Vendedor entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Vendedor entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Vendedor find(Object id) {
        return abmService.find(id, Vendedor.class);
    }

    @Override
    public List<Vendedor> findAll() {
        return abmService.getEM().createQuery("select obj from Vendedor obj").getResultList();
    }

    @Override
    public List<Vendedor> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
