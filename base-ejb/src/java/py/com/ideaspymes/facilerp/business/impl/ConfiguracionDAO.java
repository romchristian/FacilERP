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
import py.com.ideaspymes.facilerp.business.interfaces.IConfiguracionDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Configuracion;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConfiguracionDAO implements IConfiguracionDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Configuracion create(Configuracion entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Configuracion edit(Configuracion entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Configuracion entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Configuracion find(Object id) {
        return abmService.find(id, Configuracion.class);
    }

    @Override
    public List<Configuracion> findAll() {
        return abmService.getEM().createQuery("select obj from Configuracion obj").getResultList();
    }

    @Override
    public List<Configuracion> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public String getValor(String modulo, String nombre) {
        String R = null;
        try {
            R = (String) abmService.getEM().createQuery("SELECT c.valor FROM Configuracion c WHERE c.modulo = ?1 and c.nombreClave = ?2 ")
                    .setParameter(1, modulo)
                    .setParameter(2, nombre)
                    .getSingleResult();
            
        } catch (Exception e) {
        }
        return R;
    }

}
