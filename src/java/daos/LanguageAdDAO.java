/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.LanguageAd;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class LanguageAdDAO {
    
    public FunctionDAO fdao;

    public LanguageAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(LanguageAd languageAd){
        return this.fdao.insertOrUpdate(languageAd);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from LanguageAd");
        
    }
    
    public LanguageAd getLanguageADById(String langId){
    
        return (LanguageAd) this.fdao.getById("from LanguageAd where id = "+langId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from LanguageAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from LanguageAd");
    }
}
