/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.ManagedType;
import py.com.ideaspymes.facilerp.business.interfaces.IModuloFacade;
import py.com.ideaspymes.facilerp.generico.ConfigModulo;
import py.com.ideaspymes.facilerp.pesistencia.base.Modulo;
import py.com.ideaspymes.facilerp.pesistencia.base.Pantalla;

/**
 *
 * @author Acer
 */
@Stateless
public class ModuloFacade implements IModuloFacade {

    public static final String PUNTO_VENTA = "puntoVenta";
    public static final String STOCK = "stock";
    public static final String CONTABILIDAD = "contabilidad";

    @PersistenceContext(unitName = "FacilERPPesistenUnit")
    private EntityManager em;

    // @EJB
    //private IModuloDAO moduloDAO;
    //@EJB
    //private IPantallaDAO pantallaDAO;
    @Override
    public void inicializaModulos() {
        for (String m : ConfigModulo.getInstance().getModulos()) {
            System.out.println("Modulo Nombre: " + m);
        }
        for (ManagedType mt : em.getEntityManagerFactory().getMetamodel().getManagedTypes()) {
            String modulo = "";
            try {
                Method getNombreModulo = mt.getJavaType().getMethod("getNombreModulo");
                Object obj = mt.getJavaType().newInstance();
                
                modulo = (String) getNombreModulo.invoke(obj);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ModuloFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Entidad Nombre: " + mt.getJavaType().getSimpleName() + ", Modulo: " + modulo);

        }
    }

    @Override
    public List<Modulo> findModulos() {
        return null;//moduloDAO.findAll();
    }

    @Override
    public List<Pantalla> findPantallas(Modulo m) {
        return null;//pantallaDAO.findAll(m);
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
