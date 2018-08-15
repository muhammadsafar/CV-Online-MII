/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AppDevController;
import controllers.CustomerController;
import controllers.RoleController;
import controllers.SiteController;
import controllers.AwardController;
import controllers.HrController;
import controllers.EducationController;

import entities.AppDev;
import entities.Award;
import entities.Customer;
import entities.Role;
import entities.Site;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class MyTester {

    public static void main(String[] args) {

        HibernateUtil hibernateUtil = new HibernateUtil();
        System.out.println(HibernateUtil.getSessionFactory());

//        AwardController ac = new AwardController(HibernateUtil.getSessionFactory());
//        
//        for (Award award : ac.binding()) {
//            
//            System.out.println("Award name :"+award.getAwardName()+"====award Id: "+award.getId());
//        }
//CustomerController cc = new CustomerController(HibernateUtil.getSessionFactory());
//        for (Customer customer : cc.binding()) {
//            System.out.println(customer.getSiteId().getSite());
//        }
//        SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
//        for (Site site : sc.binding()) {
//            System.out.println(site.getCustomerList().size());
//        }
//        AppDevController ac = new AppDevController(HibernateUtil.getSessionFactory());
//        for (AppDev appDev : ac.find("nik", "001100")) {
//            System.out.println("Nama:" + appDev.getNama());
//        }
    }
}
