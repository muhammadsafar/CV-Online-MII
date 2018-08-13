/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.AppDev;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class AppDevDAO {

    private final FunctionDAO fdao;

    public AppDevDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(AppDev appDev){
        return this.fdao.insertOrUpdate(appDev);
    }
    
    public  List<Object> getAll(){
        return this.fdao.get("from AppDev");
    }
    
    public AppDev getAppDevByAId(String appDevId){
        return (AppDev) this.fdao.getById("from AppDev WHERE nik = "+ appDevId + "");
    }
    
    public List<Object> search(String category, String data){
    
        return this.fdao.get("from AppDev where "+category+ " like '%"+data+"%' ");
    }
    
    
}
