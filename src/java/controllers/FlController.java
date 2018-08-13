/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.ForeignLanguage;
import daos.ForeignLanguageDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class FlController {
    
    public ForeignLanguageDAO fldao;

    public FlController(SessionFactory factory) {
        this.fldao = new ForeignLanguageDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String fl){
        ForeignLanguage language  = new ForeignLanguage(Integer.parseInt(id), fl);
        return this.fldao.insertOrUpdate(language);
    }
    
    public List<ForeignLanguage> convertFlList(List<Object> list){
        List<ForeignLanguage> dataFl = new ArrayList<>();
        for (Object object : list) {
            ForeignLanguage fl = (ForeignLanguage) object;
            dataFl.add(fl);
        }
        
        return dataFl;
    }
    
    public List<ForeignLanguage> binding(){
        return this.convertFlList(this.fldao.getAll());
    }
    
    public List<ForeignLanguage> find(String category, String data){
        return this.convertFlList(this.fldao.search(category, data));
    }
    
    public ForeignLanguage getById(String flId){
        return this.fldao.getForeignLanguageById(flId);
    }
}
