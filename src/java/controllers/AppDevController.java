/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AppDevDAO;
import entities.AppDev;
import entities.Religion;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
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
    
    public boolean saveOrEdit(String nik, String username, String pass, String name, 
            String address, String dob, String national, String marital, String gender, String status, 
            Role roleId, Religion religionId){
        
        AppDev appDev = new AppDev(nik, username, pass, name, address, java.sql.Date.valueOf(dob), 
                national, marital, gender, status, 
                religionId, 
                roleId);
        
        return this.appDevDAO.insertOrUpdate(appDev);
    }
    
    /**
     * 
     * @param dataAwal
     * @return 
     */
    public List<AppDev> convertApp(List<Object> dataAwal){
        List<AppDev> dataApp = new ArrayList<>();
        for (Object object : dataAwal) {
            AppDev ad = (AppDev) object;
            dataApp.add(ad);
            
        }
        
        return dataApp;
    }
    
    public List<AppDev> binding(){
        return this.convertApp(this.appDevDAO.getAll());
    }
    
    /**
     * 
     * @param category
     * @param data
     * @return 
     */
    public List<AppDev> find(String category, String data){
        return this.convertApp(this.appDevDAO.search(category, data));
    } 
    
    /**
     * 
     * @param appId
     * @return 
     */
    public AppDev getById(String appId){
        return this.appDevDAO.getAppDevByAId(appId);
    }
    
    
    
}
