/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.TechQualification;
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
    
    public boolean insertOrUpdate(TechQualification tq){
    
        return this.fdao.insertOrUpdate(tq);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from TechQualification");
    }
    
    public TechQualification getTqById(String techId){
    
        return (TechQualification) this.fdao.getById("from TechQualification where id = "+techId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from TechQualification where "+category+"like '%"+data+"%'");
    }
}
