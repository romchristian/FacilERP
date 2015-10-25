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
import py.com.ideaspymes.facilerp.business.interfaces.ICotizacionDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Cotizacion;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CotizacionDAO implements ICotizacionDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cotizacion create(Cotizacion entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Cotizacion edit(Cotizacion entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Cotizacion entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Cotizacion find(Object id) {
        return abmService.find(id, Cotizacion.class);
    }

    @Override
    public List<Cotizacion> findAll() {
        return abmService.getEM().createQuery("select obj from Cotizacion obj").getResultList();
    }

    @Override
    public List<Cotizacion> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
