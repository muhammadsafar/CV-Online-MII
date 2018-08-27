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
import java.util.Date;
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
    
    public boolean saveOrEdit(AppDev appDev){
        return this.appDevDAO.insertOrUpdate(appDev);
    }
    public boolean saveOrEdit(String nik, String username, String pass, String name, 
            String address, Date dob, String national, String marital, String gender, String status, 
            String email, String nope, String pict, String roleId, String religionId){
        AppDev appDev = new AppDev(nik, 
                username, 
                pass, 
                name, 
                address, 
                dob, 
                national, 
                marital, 
                gender, 
                status, 
                email, 
                nope, 
                pict, 
                new Role(Long.parseLong(roleId), ""), 
                new Religion(Short.parseShort(religionId), ""));
        return this.appDevDAO.insertOrUpdate(appDev);
    }
    
    public boolean editStatus(String nik, String value){
        AppDev appDev = new AppDev(nik, value);
        return this.appDevDAO.editStatus(appDev);
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
    
        public AppDev getByUser(String user){
        return this.appDevDAO.getAppDevByUser(user);
    }
    
    public Object autoId(){
        return this.appDevDAO.getAutoID();
    }
    
    public AppDev getByCateAppDev(String cate, String value) {
        AppDev ad = (AppDev) appDevDAO.search(cate, value).get(0);
        return this.appDevDAO.getAppDevByAId(ad.getNik());
    }
    
}
