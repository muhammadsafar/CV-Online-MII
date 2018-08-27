/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Experience;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class ExperienceDAO {
    
    public FunctionDAO fdao;

    public ExperienceDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Experience experience){
        return this.fdao.insertOrUpdate(experience);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from Experience");
    }
    
    public Experience getExperienceById(String experienceId){
        return (Experience) this.fdao.getById("from Experience where id = "+experienceId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from Experience where "+category+" like '%"+data+"%'");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from Experience");
    }
}
