/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.TechnicalQualification;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class TechQualificationDAO {
    
    public FunctionDAO fdao;

    public TechQualificationDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(TechnicalQualification tq){
    
        return this.fdao.insertOrUpdate(tq);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from TechnicalQualification");
    }
    
    public TechnicalQualification getTqById(String techId){
    
        return (TechnicalQualification) this.fdao.getById("from TechnicalQualification where id = "+techId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from TechnicalQualification where "+category+" like '%"+data+"%'");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from TechnicalQualification");
    }
}
