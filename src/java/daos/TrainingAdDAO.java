/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;
import entities.TrainingAd;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class TrainingAdDAO {

    public FunctionDAO fdao;

    public TrainingAdDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(TrainingAd trainingAd){
        return this.fdao.insertOrUpdate(trainingAd);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from TrainingAd");
        
    }
    
    public TrainingAd getTechADById(String trainId){
        return (TrainingAd) this.fdao.getById("from TrainingAd where id = "+trainId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from TrainingAd where "+category+ " like '%"+data+"%' ");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from TrainingAd");
    }
}
