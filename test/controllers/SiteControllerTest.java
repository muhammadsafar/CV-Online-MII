/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Site;
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
public class SiteControllerTest {
    
    SiteController sc;
    
    public SiteControllerTest() {
        this.sc = new SiteController(HibernateUtil.getSessionFactory());
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveOrEdit method, of class SiteController.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        String id = "S007";
        String site = "Bayer";
        String status = "1";
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        boolean expResult = true;
        boolean result = instance.saveOrEdit(id, site, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of convertListSite method, of class SiteController.
     */
    @Test
    public void testConvertListSite() {
        System.out.println("convertListSite");
        List<Object> dataAwal = null;
        SiteController instance = new SiteController();
        List<Site> expResult = null;
        List<Site> result = instance.convertListSite(dataAwal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binding method, of class SiteController.
     */
    @Test
    public void testBinding() {
        System.out.println("binding");
        SiteController instance = new SiteController();
        List<Site> expResult = null;
        List<Site> result = instance.binding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class SiteController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String category = "id";
        String data = "S";
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        List<Site> expResult = null;
        List<Site> result = instance.find(category, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class SiteController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String siteId = "S002";
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        Site expResult = null;
        Site result = instance.getById(siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of AutoId method, of class SiteController.
     */
    @Test
    public void testAutoId() {
        System.out.println("AutoId");
        SiteController instance = new SiteController();
        Object expResult = null;
        Object result = instance.AutoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
