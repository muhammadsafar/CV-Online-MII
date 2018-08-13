/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Organization;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class OrganizationDAO {
    
    public FunctionDAO fdao;

    public OrganizationDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Organization organization){
    
        return this.fdao.insertOrUpdate(organization);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Organization");
    }
    
    public Organization getOrganizationById(String organizationId){
    
        return (Organization) this.fdao.getById("from Organization where id = "+organizationId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Organization where "+category+"like '%"+data+"%'");
    }
}
