/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.AdSite;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class AdSiteDAO {
    public FunctionDAO fdao;

    public AdSiteDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(AdSite as){
        return this.fdao.insertOrUpdate(as);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from AdSite");
        
    }
    
    public AdSite getAdSiteById(String adsiteId){
        return (AdSite) this.fdao.getById("from AdSite where id = "+adsiteId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from AdSite where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from AdSite");
    }
}
