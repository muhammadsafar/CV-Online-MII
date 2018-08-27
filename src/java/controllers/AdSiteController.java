/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import daos.AdSiteDAO;
import entities.AdSite;
import entities.AppDev;
import entities.Site;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class AdSiteController {
    public AdSiteDAO asdao;

    public AdSiteController(SessionFactory factory) {
        this.asdao = new AdSiteDAO(factory);
    }

    public AdSiteController() {
    }
    
    public boolean saveOrEdit(String id, String review, int stat, String siteId, String adid){
        AdSite adSite = new AdSite(Integer.parseInt(id), review, stat,
                new AppDev(adid, ""),
                new Site(siteId));
        return this.asdao.insertOrUpdate(adSite);
    }
    
    public List<AdSite> convertAdSiteList(List<Object> dataAwal){
        List<AdSite> dataTraining = new ArrayList<>();
        for (Object object : dataAwal) {
            AdSite adSite = (AdSite) object;
            dataTraining.add(adSite);
        }
        return dataTraining;
    }
    
    public List<AdSite> binding(){
        return convertAdSiteList(this.asdao.getAll());
    }
    
    public List<AdSite> find(String category, String data){
        return this.convertAdSiteList(this.asdao.search(category, data));
    }
    
    public AdSite getById(String asId){
        return this.asdao.getAdSiteById(asId);
    }

    public Object autoId() {
        return this.asdao.getAutoID();
    }
}
