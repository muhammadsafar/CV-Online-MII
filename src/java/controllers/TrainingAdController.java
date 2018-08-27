/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import daos.TrainingAdDAO;
import entities.AppDev;
import entities.Training;
import entities.TrainingAd;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class TrainingAdController {
    public TrainingAdDAO tadao;

    public TrainingAdController(SessionFactory factory) {
        this.tadao = new TrainingAdDAO(factory);
    }

    public TrainingAdController() {
    }
    public boolean insertOrUpdate(int id, String year, String adid, String trainid) {
        TrainingAd trainingAd = new TrainingAd(id, year, 
                new AppDev(adid, ""),
                new Training(Integer.parseInt(trainid))
                );
        return this.tadao.insertOrUpdate(trainingAd);
    }

    public Object autoId() {
        return this.tadao.getAutoID();
    }
}
