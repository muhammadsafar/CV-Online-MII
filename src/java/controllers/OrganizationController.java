/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrganizationDAO;
import entities.Oganization;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class OrganizationController {
    
    public OrganizationDAO odao;

    public OrganizationController(SessionFactory factory) {
        this.odao = new OrganizationDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String org){
        Oganization oganization = new Oganization(Long.parseLong(id), org);
        return this.odao.insertOrUpdate(oganization);
    }
    
    public List<Oganization> convertOrgList(List<Object> dataAwal){
        List<Oganization> dataOrg = new ArrayList<>();
        for (Object object : dataAwal) {
            Oganization oganization = (Oganization) object;
            dataOrg.add(oganization);
        }
        
        return dataOrg;
    }
    
    public List<Oganization> binding(){
        return this.convertOrgList(this.odao.getAll());
    }
    
    public List<Oganization> find(String category, String data){
        return this.convertOrgList(this.odao.search(category, data));
    }
    
    public Oganization getById(String orgId){
        return this.odao.getOrganizationById(orgId);
    
    }
}
