/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entities.Religion;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class ReligionDAO {
    
    public FunctionDAO fdao;

    public ReligionDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public boolean insertOrUpdate(Religion religion){
        return this.fdao.insertOrUpdate(religion);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from Religion");
    }
    
    public Religion getReligionById(String religionId){
        return (Religion) this.fdao.getById("from Religion where id = "+religionId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from Religion where "+category+"like '%"+data+"%'");
    }
}
