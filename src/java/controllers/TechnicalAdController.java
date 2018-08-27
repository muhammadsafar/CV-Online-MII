/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import daos.TechnicalAdDAO;
import entities.AppDev;
import entities.TechnicalQualification;
import entities.TechnicalAd;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class TechnicalAdController {

    public TechnicalAdDAO tadao;

    public TechnicalAdController(SessionFactory factory) {
        this.tadao = new TechnicalAdDAO(factory);
    }

    public TechnicalAdController() {
    }

    public boolean insertOrUpdate(int id, String tecid, String adid) {
        TechnicalAd technicalAd = new TechnicalAd(id, 
                new AppDev(adid, ""),
                new TechnicalQualification(Integer.parseInt(tecid))
                );
        return this.tadao.insertOrUpdate(technicalAd);
    }

    public Object autoId() {
        return this.tadao.getAutoID();
    }
}
