/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.SiteDAO;
import entities.Site;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class SiteController {
    
    public SiteDAO sdao;

    public SiteController() {
    }

    public SiteController(SessionFactory factory) {
        this.sdao = new SiteDAO(factory);
    }
    
    boolean saveOrEdit(String id, String site, String status){
        Site site1 = new Site(id, site, Short.parseShort(status));
        return this.sdao.insertOrUpdate(site1);
    }
    
    public List<Site> convertListSite(List<Object> dataAwal){
        List<Site> dataSite = new ArrayList<>();
        for (Object object : dataAwal) {
            Site site = (Site) object;
            dataSite.add(site);
        }
        
        return dataSite;
    }
    
    public List<Site> binding(){
    
        return this.convertListSite(this.sdao.getAll());
    }
    
    public List<Site> find(String category, String data){
    
        return this.convertListSite(this.sdao.search(category, data));
    }
    
    public Site getById(String siteId){
    
        return this.sdao.getSiteById(siteId);
    }
    
}
