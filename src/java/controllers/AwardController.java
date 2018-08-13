/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AwardDAO;
import entities.Award;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class AwardController {
    
    public AwardDAO adao;

    public AwardController(SessionFactory factory) {
        this.adao = new AwardDAO(factory);
    }

    public AwardController() {
    }
    
    
    public boolean saveOrEdit(String id, String award){
        Award award1 = new Award(Long.parseLong(id), award);
        return this.adao.insertOrUpdate(award1);
    }
    
    public List<Award> converAwardList(List<Object> dataAwal){
        List<Award> dataAward = new ArrayList<>();
        for (Object object : dataAwal) {
            Award award = (Award) object;
            dataAward.add(award);
        }
        return dataAward;
    }
    
    public List<Award> binding(){
    
        return this.converAwardList(this.adao.getAll());
    }
    
    public List<Award> find(String category, String data){
    
        return this.converAwardList(this.adao.search(category, data));
    }
    
    public Award getById(String awardId){
        return this.adao.getAwardById(awardId);
    }
}
