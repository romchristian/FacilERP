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
import py.com.ideaspymes.facilerp.business.interfaces.IClienteDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Cliente;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClienteDAO implements IClienteDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cliente create(Cliente entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Cliente edit(Cliente entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Cliente entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Cliente find(Object id) {
        return abmService.find(id, Cliente.class);
    }

    @Override
    public List<Cliente> findAll() {
        return abmService.getEM().createQuery("select obj from Cliente obj").getResultList();
    }

    @Override
    public List<Cliente> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
