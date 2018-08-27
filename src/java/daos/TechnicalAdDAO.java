/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.TechnicalAd;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class TechnicalAdDAO {

        public FunctionDAO fdao;

    public TechnicalAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(TechnicalAd technicalAd){
        return this.fdao.insertOrUpdate(technicalAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from TechnicalAd");
        
    }
    
    public TechnicalAd getTechADById(String techId){
        return (TechnicalAd) this.fdao.getById("from TechnicalAd where id = "+techId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from TechnicalAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from TechnicalAd");
    }
}
