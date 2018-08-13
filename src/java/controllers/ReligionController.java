/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Religion;
import daos.ReligionDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class ReligionController {
    
    public ReligionDAO rdao;

    public ReligionController() {
    }

    
    public ReligionController(SessionFactory factory) {
        this.rdao = new ReligionDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String religion){
    
        Religion religion1 = new Religion(Short.parseShort(id), religion);
        return this.rdao.insertOrUpdate(religion1);
    }
    
    public List<Religion> convertReligionList(List<Object> dataAwal){
    
        List<Religion> dataReligion = new ArrayList<>();
        for (Object object : dataAwal) {
            Religion religion = (Religion) object;
            dataReligion.add(religion);
        }
        
        return dataReligion;
    }
    
    public List<Religion> binding(){
    
        return this.convertReligionList(this.rdao.getAll());
    }
    
    public List<Religion> find(String category, String data){
        return this.convertReligionList(this.rdao.search(category, data));
    }
    
    public Religion getById(String religionId){
    
        return this.rdao.getReligionById(religionId);
    }
    
}
