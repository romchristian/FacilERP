/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import py.com.ideaspymes.facilerp.generico.ABMService;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.ideaspymes.facilerp.pesistencia.stock.LoteExistencia;
import py.com.ideaspymes.facilerp.stock.business.interfaces.ILoteExistenciaDAO;





/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LoteExistenciaDAO implements ILoteExistenciaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public LoteExistencia create(LoteExistencia entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public LoteExistencia edit(LoteExistencia entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(LoteExistencia entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public LoteExistencia find(Object id) {
        return abmService.find(id, LoteExistencia.class);
    }

    @Override
    public List<LoteExistencia> findAll() {
        return abmService.getEM().createQuery("select obj from LoteExistencia obj").getResultList();
    }

    @Override
    public List<LoteExistencia> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
