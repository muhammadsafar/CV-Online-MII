/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.AppDev;
import java.util.Date;
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
public class AppDevControllerTest {
    
    AppDevController adc;
    public AppDevControllerTest() {
        this.adc = new AppDevController(HibernateUtil.getSessionFactory());
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveOrEdit method, of class AppDevController.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        String nik = "";
        String username = "";
        String pass = "";
        String name = "";
        String address = "";
        Date dob = null;
        String national = "";
        String marital = "";
        String gender = "";
        String status = "";
        String nope = "";
        String email = "";
        String pict = "";
        String roleId = "";
        String religionId = "";
        AppDevController instance = new AppDevController();
        boolean expResult = false;
        boolean result = instance.saveOrEdit(nik, username, pass, name, address, dob, national, marital, gender, status, nope, email, pict, roleId, religionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertApp method, of class AppDevController.
     */
    @Test
    public void testConvertApp() {
        System.out.println("convertApp");
        List<Object> dataAwal = null;
        AppDevController instance = new AppDevController();
        List<AppDev> expResult = null;
        List<AppDev> result = instance.convertApp(dataAwal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binding method, of class AppDevController.
     */
    @Test
    public void testBinding() {
        System.out.println("binding");
        AppDevController instance = new AppDevController();
        List<AppDev> expResult = null;
        List<AppDev> result = instance.binding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class AppDevController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String category = "username";
        String data = "hamm";
        AppDevController instance = new AppDevController(HibernateUtil.getSessionFactory());
        List<AppDev> expResult = null;
        List<AppDev> result = instance.find(category, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class AppDevController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String appId = "";
        AppDevController instance = new AppDevController();
        AppDev expResult = null;
        AppDev result = instance.getById(appId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByUser method, of class AppDevController.
     */
    @Test
    public void testGetByUser() {
        System.out.println("getByUser");
        String user = "";
        AppDevController instance = new AppDevController();
        AppDev expResult = null;
        AppDev result = instance.getByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autoId method, of class AppDevController.
     */
    @Test
    public void testAutoId() {
        System.out.println("autoId");
        AppDevController instance = new AppDevController();
        Object expResult = null;
        Object result = instance.autoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
