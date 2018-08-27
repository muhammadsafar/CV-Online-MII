/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrganizationAdDAO;
import daos.OrganizationDAO;
import entities.AppDev;
import entities.Organization;
import entities.OrganizationAd;
import org.hibernate.SessionFactory;

/**
 *
 * @author Dayinta Warih Wulandari
 */
public class OrganizationAdController {

    public OrganizationAdDAO odao;

    public OrganizationAdController(SessionFactory factory) {
        this.odao = new OrganizationAdDAO(factory);
    }

    public OrganizationAdController() {
    }

    public boolean insertOrUpdate(int id, String adid, String trainid) {
        OrganizationAd organizationAd = new OrganizationAd(id, 
                new AppDev(adid, ""),
                new Organization(Integer.parseInt(trainid)));
        return this.odao.insertOrUpdate(organizationAd);
    }

    public Object autoId() {
        return this.odao.getAutoID();
    }
}
