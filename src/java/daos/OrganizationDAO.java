/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Oganization;
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
    
    public boolean insertOrUpdate(Oganization organization){
    
        return this.fdao.insertOrUpdate(organization);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Oganization");
    }
    
    public Oganization getOrganizationById(String organizationId){
    
        return (Oganization) this.fdao.getById("from Oganization where id = "+organizationId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Oganization where "+category+"like '%"+data+"%'");
    }
}
