/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Hr;
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
public class HrControllerTest {
    
    HrController hc;
    
    public HrControllerTest() {
        this.hc = new HrController(HibernateUtil.getSessionFactory());
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveOrEdit method, of class HrController.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        String nik = "544321";
        String nama = "tomang";
        String username = "tomang";
        String password = "tomang";
        String roleid = "1";
        HrController instance = new HrController(HibernateUtil.getSessionFactory());
        boolean expResult = true;
        boolean result = instance.saveOrEdit(nik, nama, username, password, roleid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of convertHrList method, of class HrController.
     */
    @Test
    public void testConvertHrList() {
        System.out.println("convertHrList");
        List<Object> dataAwal = null;
        HrController instance = new HrController();
        List<Hr> expResult = null;
        List<Hr> result = instance.convertHrList(dataAwal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binding method, of class HrController.
     */
    @Test
    public void testBinding() {
        System.out.println("binding");
        HrController instance = new HrController();
        List<Hr> expResult = null;
        List<Hr> result = instance.binding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class HrController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String category = "nama";
        String data = "mang";
        HrController instance = new HrController(HibernateUtil.getSessionFactory());
        List<Hr> expResult = null ;
        List<Hr> result = instance.find(category, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getbyId method, of class HrController.
     */
    @Test
    public void testGetbyId() {
        System.out.println("getbyId");
        String hrId = "";
        HrController instance = new HrController();
        Hr expResult = null;
        Hr result = instance.getbyId(hrId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getbyUser method, of class HrController.
     */
    @Test
    public void testGetbyUser() {
        System.out.println("getbyUser");
        String user = "";
        HrController instance = new HrController();
        Hr expResult = null;
        Hr result = instance.getbyUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
