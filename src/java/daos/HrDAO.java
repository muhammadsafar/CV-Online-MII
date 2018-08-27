/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Hr;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class HrDAO {
    
    public FunctionDAO fdao;

    public HrDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public boolean insertOrUpdate(Hr hr){
        return this.fdao.insertOrUpdate(hr);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Hr");
        
    }
    
    public Hr getHrById(String hrId){
    
        return (Hr) this.fdao.getById("from Hr where nik = "+hrId+"");
    }
    
        public Hr getHrByUser(String user){
    
        return (Hr) this.fdao.getById("from Hr where username = "+user+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Hr where "+category+ " like '%"+data+"%' ");
    }
    
}
