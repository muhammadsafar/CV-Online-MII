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
 * @author Dayinta Warih Wulandari
 */
public class SiteControllerTest {
    
    public SiteControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertListSite method, of class SiteController.
     */
    @Test
    public void testConvertListSite() {
        System.out.println("convertListSite");
        List<Object> dataAwal = null;
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        List<Site> expResult = null;
        List<Site> result = instance.convertListSite(dataAwal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of binding method, of class SiteController.
     */
    @Test
    public void testBinding() {
        System.out.println("binding");
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        List<Site> expResult = null;
        List<Site> result = instance.binding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class SiteController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String category = "";
        String data = "";
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        List<Site> expResult = null;
        List<Site> result = instance.find(category, data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class SiteController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String siteId = "S0001";
        SiteController instance = new SiteController(HibernateUtil.getSessionFactory());
        Site expResult = null;
        Site result = instance.getById(siteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
