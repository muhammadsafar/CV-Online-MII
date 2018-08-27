/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Training;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class TrainingDAO {
    
    public FunctionDAO fdao;

    public TrainingDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Training training){
    
        return this.fdao.insertOrUpdate(training);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Training");
    }
    
    public Training getTrainingById(String trainingId){
    
        return (Training) this.fdao.getById("from Training where id = "+trainingId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from Training where "+category+" like '%"+data+"%'");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from Training");
    }
}
