/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TrainingDAO;
import entities.Training;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class TrainingController {
    
    public TrainingDAO tdao;

    public TrainingController(SessionFactory factory) {
        this.tdao = new TrainingDAO(factory);
    }

    public TrainingController() {
    }
    
    public boolean saveOrEdit(String id, String trainingId){
        Training training = new Training(Long.parseLong(id), trainingId);
        return this.tdao.insertOrUpdate(training);
    }
    
    public List<Training> convertTrainigList(List<Object> dataAwal){
        List<Training> dataTraining = new ArrayList<>();
        for (Object object : dataAwal) {
            Training training = (Training) object;
            dataTraining.add(training);
        }
        return dataTraining;
    }
    
    public List<Training> binding(){
        return this.convertTrainigList(this.tdao.getAll());
    }
    
    public List<Training> find(String category, String data){
        return this.convertTrainigList(this.tdao.search(category, data));
    }
    
    public Training getById(String trainingId){
        return this.tdao.getTrainingById(trainingId);
    }
    
}
