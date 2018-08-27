/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.OrganizationAd;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class OrganizationAdDAO {

    public FunctionDAO fdao;
    
    public OrganizationAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(OrganizationAd organizationAd){
        return this.fdao.insertOrUpdate(organizationAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from OrganizationAd");
        
    }
    
    public OrganizationAd getTechADById(String orgId){
        return (OrganizationAd) this.fdao.getById("from OrganizationAd where id = "+orgId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from OrganizationAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from OrganizationAd");
    }
}
