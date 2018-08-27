/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import daos.ExperienceAdDAO;
import entities.AppDev;
import entities.Experience;
import entities.ExperienceAd;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class ExperienceAdController {
    public ExperienceAdDAO eadao;

    public ExperienceAdController(SessionFactory factory) {
        this.eadao = new ExperienceAdDAO(factory);
    }

    public ExperienceAdController() {
    }
    public boolean insertOrUpdate(int id, String syear, String eyear, String posisi, String adid, String exid) {
        ExperienceAd experienceAd = new ExperienceAd(id, syear, eyear, posisi,
                new AppDev(adid, ""),
                new Experience(Integer.parseInt(exid))
                );
        return this.eadao.insertOrUpdate(experienceAd);
    }

    public Object autoId() {
        return this.eadao.getAutoID();
    }
}
