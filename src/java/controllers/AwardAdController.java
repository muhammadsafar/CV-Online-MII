/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import daos.AwardAdDAO;
import entities.AppDev;
import entities.Award;
import entities.AwardAd;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class AwardAdController {
    public AwardAdDAO adDAO;

    public AwardAdController(SessionFactory factory) {
        this.adDAO = new AwardAdDAO(factory);
    }

    public AwardAdController() {
    }
    public boolean insertOrUpdate(int id, String year, String adid, String trainid) {
        AwardAd awardAd = new AwardAd(id, year, 
                new AppDev(adid, ""),
                new Award(Integer.parseInt(trainid))
                );
        return this.adDAO.insertOrUpdate(awardAd);
    }

    public Object autoId() {
        return this.adDAO.getAutoID();
    }
}
