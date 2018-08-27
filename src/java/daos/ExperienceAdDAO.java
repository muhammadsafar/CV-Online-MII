/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.ExperienceAd;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class ExperienceAdDAO {

    public FunctionDAO fdao;

    public ExperienceAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(ExperienceAd experienceAd){
        return this.fdao.insertOrUpdate(experienceAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from ExperienceAd");
        
    }
    
    public ExperienceAd getTechADById(String exId){
        return (ExperienceAd) this.fdao.getById("from TrainingAd where id = "+exId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from ExperienceAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from ExperienceAd");
    }
}
