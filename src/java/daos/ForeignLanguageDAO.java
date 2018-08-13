/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.ForeignLanguage;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class ForeignLanguageDAO {
    
    public FunctionDAO fdao;

    public ForeignLanguageDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(ForeignLanguage fl){
    
        return this.fdao.insertOrUpdate(fl);
    }
    
    public List<Object> getAll(){
    
        return this.fdao.get("from Foreignlanguage");
    }
    
    public ForeignLanguage getForeignLanguageById(String foreignLanguageId){
    
        return (ForeignLanguage) this.fdao.getById("from ForeignLanguage where id = "+foreignLanguageId+"");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from ForeignLanguage where "+category+"like '%"+data+"%'");
    }
}
