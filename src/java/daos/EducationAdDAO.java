/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.EducationAd;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class EducationAdDAO {
    public FunctionDAO fdao;

    public EducationAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(EducationAd trainingAd){
        return this.fdao.insertOrUpdate(trainingAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from Education");
    }
    
    public EducationAd getTechADById(String edId){
        return (EducationAd) this.fdao.getById("from Education where id = "+edId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from TrainingAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from EducationAd");
    }
}
