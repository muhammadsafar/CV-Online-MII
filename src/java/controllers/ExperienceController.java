/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Experience;
import daos.ExperienceDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class ExperienceController {
    public ExperienceDAO experienceDAO;

    public ExperienceController(SessionFactory factory) {
        this.experienceDAO = new ExperienceDAO(factory);
    }

    public boolean saveOrEdit(String id, String expe){
        Experience exp = new Experience(Long.parseLong(id), expe);
        return this.experienceDAO.insertOrUpdate(exp);
    }
    
    private List<Experience> convertExperList(List<Object> list){
        List<Experience> dataExper = new ArrayList<>();
        for (Object object : list) {
            Experience experience = (Experience) object;
            dataExper.add(experience);
        }
        return dataExper;
    }
    
    public List<Experience> binding(){
        return this.convertExperList(this.experienceDAO.getAll());
    }
    
    public List<Experience> find(String category, String data){
        return this.convertExperList(this.experienceDAO.search(category, data));
    }
    
    public Experience getById(String exId){
        return this.experienceDAO.getExperienceById(exId);
    }
}
