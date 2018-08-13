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
        
//        RoleController rc = new RoleController(HibernateUtil.getSessionFactory());
//        
//        for (Role role : rc.binding()) {
//            
//            System.out.println(role.getId()+"___"+role.getRole());
//            
//        }
//        
//        CustomerController cc = new CustomerController(HibernateUtil.getSessionFactory());
//          
//        for (Customer customer : cc.binding()) {
//            System.out.println(customer.getNama()+""+customer.getPassword());
//            
//        }

//          AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
//          
//          for (AppDev appDev : adc.binding()) {
//              
//              System.out.println(appDev.getNama()+"---"+appDev.getAlamat()+"---"+appDev.getNationality());
//            
//        }

        SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
        
        for (Site site : sc.binding()) {
            System.out.println(site.getStatus()+"--"+site.getSite());
        }
        
    }
}
