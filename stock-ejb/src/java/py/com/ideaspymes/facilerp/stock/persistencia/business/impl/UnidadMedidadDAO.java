/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.persistencia.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.UnidadMedida;
import py.com.ideaspymes.facilerp.stock.persistencia.business.interfaces.IUnidadMedidaDAO;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UnidadMedidadDAO implements IUnidadMedidaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public UnidadMedida create(UnidadMedida entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public UnidadMedida edit(UnidadMedida entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(UnidadMedida entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public UnidadMedida find(Object id) {
        return abmService.find(id, UnidadMedida.class);
    }

    @Override
    public List<UnidadMedida> findAll() {
        return abmService.getEM().createQuery("select obj from UnidadMedida obj").getResultList();
    }

    @Override
    public List<UnidadMedida> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
