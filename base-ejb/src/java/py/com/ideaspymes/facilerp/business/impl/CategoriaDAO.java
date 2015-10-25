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
import py.com.ideaspymes.facilerp.business.interfaces.ICategoriaDAO;
import py.com.ideaspymes.facilerp.pesistencia.base.Categoria;

/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CategoriaDAO implements ICategoriaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Categoria create(Categoria entity,String usuario) {
        return abmService.create(entity,usuario);
    }

    @Override
    public Categoria edit(Categoria entity,String usuario) {
        return abmService.update(entity,usuario);
    }

    @Override
    public void remove(Categoria entity,String usuario) {
         abmService.delete(entity,usuario);
    }

    @Override
    public Categoria find(Object id) {
        return abmService.find(id, Categoria.class);
    }

    @Override
    public List<Categoria> findAll() {
        return abmService.getEM().createQuery("select obj from Categoria obj").getResultList();
    }

    @Override
    public List<Categoria> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

   
}
