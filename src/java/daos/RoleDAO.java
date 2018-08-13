/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Role;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class RoleDAO {
    
    public FunctionDAO fdao;

    public RoleDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public boolean insertOrUpdate(Role role){
    
        return this.fdao.insertOrUpdate(role);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Role");
    }
    
    public Role getRoleById(String roleId){
    
        return (Role) this.fdao.getById("from Role where id = "+roleId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Role where "+category+"like '%"+data+"%'");
    }
    
}
