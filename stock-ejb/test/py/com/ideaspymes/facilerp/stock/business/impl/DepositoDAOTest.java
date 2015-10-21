/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ideaspymes.facilerp.stock.business.impl;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import py.com.ideaspymes.facilerp.generico.QueryParameter;
import py.com.ideaspymes.facilerp.pesistencia.stock.Deposito;
import py.com.ideaspymes.facilerp.stock.business.interfaces.IDepositoDAO;

/**
 *
 * @author cromero
 */
public class DepositoDAOTest {
    
    public DepositoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DepositoDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Deposito entity = null;
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        Deposito expResult = null;
        Deposito result = instance.create(entity, usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class DepositoDAO.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Deposito entity = null;
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        Deposito expResult = null;
        Deposito result = instance.edit(entity, usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class DepositoDAO.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Deposito entity = null;
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        instance.remove(entity, usuario);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DepositoDAO.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        Deposito expResult = null;
        Deposito result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DepositoDAO.
     */
    @Test
    public void testFindAll_0args() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        List<Deposito> expResult = null;
        List<Deposito> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DepositoDAO.
     */
    @Test
    public void testFindAll_String_QueryParameter() throws Exception {
        System.out.println("findAll");
        String query = "";
        QueryParameter params = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IDepositoDAO instance = (IDepositoDAO)container.getContext().lookup("java:global/classes/DepositoDAO");
        List<Deposito> expResult = null;
        List<Deposito> result = instance.findAll(query, params);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
