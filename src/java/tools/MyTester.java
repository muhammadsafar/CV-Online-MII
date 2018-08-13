/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
    }
}
