/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Site;
import java.sql.CallableStatement;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class SiteDAO {
    
    public FunctionDAO fdao;
    private SessionFactory factory;

    public SiteDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
        this.factory = factory;
    }

    public boolean insertOrUpdate(Site site){
        return this.fdao.insertOrUpdate(site);
    }
    public boolean executeProcedure(String query){
        try {
            //CallableStatement cs = factory.
            
        } catch (Exception e) {
        }
        return false;
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from Site order by id");
    }
    
    public Site getSiteById(String siteId){
        return (Site) this.fdao.getById("from Site where id = "+ siteId +"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from Site where "+category+ "like '%"+data+"%'");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select concat('S', LPAD((TO_NUMBER(SUBSTR(MAX(id), 2, 5))+1), 4, '0')) from Site");
    }
    
}
