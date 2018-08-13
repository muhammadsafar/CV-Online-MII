/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AppDevDAO;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class AppDevController {
    
    public AppDevDAO appDevDAO;

    public AppDevController() {
    }

    public AppDevController(SessionFactory factory) {
        this.appDevDAO = new AppDevDAO(factory);
    }
    
}
