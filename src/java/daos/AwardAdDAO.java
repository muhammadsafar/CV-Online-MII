/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.AwardAd;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class AwardAdDAO {
    public FunctionDAO fdao;

    public AwardAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(AwardAd awardAd){
        return this.fdao.insertOrUpdate(awardAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from AwardAd");
        
    }
    
    public AwardAd getTechADById(String awardId){
        return (AwardAd) this.fdao.getById("from AwardAd where id = "+awardId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from AwardAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from AwardAd");
    }
}
