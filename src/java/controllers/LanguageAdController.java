/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LanguageAdDAO;
import entities.LanguageAd;
import entities.AppDev;
import entities.ForeignLanguage;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Dayinta Warih Wulandari
 */
public class LanguageAdController {

    public LanguageAdDAO ladao;

    public LanguageAdController(SessionFactory factory) {
        this.ladao = new LanguageAdDAO(factory);
    }

    public LanguageAdController() {
    }

    public boolean insertOrUpdate(int id, String adid, String flid) {
        LanguageAd ad = new LanguageAd(id, new AppDev(adid, ""),
                new ForeignLanguage(Integer.parseInt(flid)));
        return this.ladao.insertOrUpdate(ad);
    }

    public Object autoId() {
        return this.ladao.getAutoID();
    }
}
