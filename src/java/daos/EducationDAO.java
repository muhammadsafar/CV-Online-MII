/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Education;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class EducationDAO {
    
    public FunctionDAO fdao;

    public EducationDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Education education){
    
        return this.fdao.insertOrUpdate(education);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Education");
    }
    
    public Education getEducationById(String educationId){
    
        return (Education) this.fdao.getById("from Education where id = "+educationId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Education where "+category+"like '%"+data+"%'");
    }
}
