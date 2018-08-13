/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrganizationDAO;
import entities.Organization;
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
        Organization oganization = new Organization(Long.parseLong(id), org);
        return this.odao.insertOrUpdate(oganization);
    }
    
    public List<Organization> convertOrgList(List<Object> dataAwal){
        List<Organization> dataOrg = new ArrayList<>();
        for (Object object : dataAwal) {
            Organization oganization = (Organization) object;
            dataOrg.add(oganization);
        }
        
        return dataOrg;
    }
    
    public List<Organization> binding(){
        return this.convertOrgList(this.odao.getAll());
    }
    
    public List<Organization> find(String category, String data){
        return this.convertOrgList(this.odao.search(category, data));
    }
    
    public Organization getById(String orgId){
        return this.odao.getOrganizationById(orgId);
    
    }
}
