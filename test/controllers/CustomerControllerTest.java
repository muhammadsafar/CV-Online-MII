/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Customer;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.HibernateUtil;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class CustomerControllerTest {
    
    public CustomerControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveOrEdit method, of class CustomerController.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        String id = "";
        String nama = "";
        String username = "";
        String pass = "";
        String roleId = "";
        String siteId = "";
        CustomerController instance = new CustomerController();
        boolean expResult = false;
        boolean result = instance.saveOrEdit(id, nama, username, pass, roleId, siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertCustomerList method, of class CustomerController.
     */
    @Test
    public void testConvertCustomerList() {
        System.out.println("convertCustomerList");
        List<Object> dataAwal = null;
        CustomerController instance = new CustomerController();
        List<Customer> expResult = null;
        List<Customer> result = instance.convertCustomerList(dataAwal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binding method, of class CustomerController.
     */
    @Test
    public void testBinding() {
        System.out.println("binding");
        CustomerController instance = new CustomerController();
        List<Customer> expResult = null;
        List<Customer> result = instance.binding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CustomerController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String category = "";
        String data = "";
        CustomerController instance = new CustomerController();
        List<Customer> expResult = null;
        List<Customer> result = instance.find(category, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class CustomerController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String cusId = "50";
        CustomerController instance = new CustomerController(HibernateUtil.getSessionFactory());
        Customer expResult = null;
        Customer result = instance.getById(cusId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
