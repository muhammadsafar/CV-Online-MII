/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EducationDAO;
import entities.Education;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class EducationController {
    public EducationDAO edao;

    public EducationController(SessionFactory factory) {
        this.edao = new EducationDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String edu){
        Education education = new Education(Long.parseLong(id), edu);
        return this.edao.insertOrUpdate(education);
    }
    
    private List<Education> convertEduList(List<Object> list){
        List<Education> dataEdu = new ArrayList<>();
        for (Object object : list) {
            Education education = (Education) object;
            dataEdu.add(education);
        }
        return dataEdu;
    }
    
    public List<Education> binding(){
        return this.convertEduList(this.edao.getAll());
    }
    
    public List<Education> find(String category, String data){
        return this.convertEduList(this.edao.search(category, data));
    }
    
    public Education getById(String eduId){
        return this.edao.getEducationById(eduId);
    }
}
