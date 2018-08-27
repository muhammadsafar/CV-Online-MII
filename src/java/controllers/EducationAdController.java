/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import daos.EducationAdDAO;
import entities.AppDev;
import entities.Education;
import entities.EducationAd;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class EducationAdController {
    public EducationAdDAO adDAO;

    public EducationAdController(SessionFactory factory) {
        this.adDAO = new EducationAdDAO(factory);
    }

    public EducationAdController() {
    }
    public boolean insertOrUpdate(int id, String gpa, String periode, String adid, String trainid) {
        EducationAd educationAd = new EducationAd(id, gpa, periode,
                new AppDev(adid, ""),
                new Education(Integer.parseInt(trainid))
                );
        return this.adDAO.insertOrUpdate(educationAd);
    }

    public Object autoId() {
        return this.adDAO.getAutoID();
    }
}
