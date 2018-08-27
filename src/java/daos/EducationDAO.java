/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Education;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.jboss.logging.Logger;
import tools.HibernateUtil;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class EducationDAO {
    
    public FunctionDAO fdao;

    public EducationDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Education education){
        return this.fdao.insertOrUpdate(education);
    }
    
    public List<Object> getAll(){
        return this.fdao.get("from Education");
    }
    
    public Education getEducationById(String educationId){
        return (Education) this.fdao.getById("from Education where id = "+educationId+"");
    }
    
    public List<Object> search(String category, String data){
        return this.fdao.get("from Education where "+category+" like '%"+data+"%'");
    }
    
    public String getAutoID(){
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from Education");
    }
}
