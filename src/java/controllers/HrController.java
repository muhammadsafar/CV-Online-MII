/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.HrDAO;
import entities.Hr;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class HrController {
    
    public HrDAO hrDAO;

    public HrController(SessionFactory factory) {
        this.hrDAO = new HrDAO(factory);
    }

    public HrController() {
    }
    
    public boolean saveOrEdit(String nik, String nama, String username, String password, Role roleid){
        Hr humanResearch = new Hr(nik, nama, username, password, roleid);
        return this.hrDAO.insertOrUpdate(humanResearch);
    }
    
    public List<Hr> convertHrList(List<Object> dataAwal){
        List<Hr> dataHuman = new ArrayList<>();
        for (Object object : dataAwal) {
            Hr hr = (Hr) object;
            dataHuman.add(hr);
        }
        
        return dataHuman;
    }
    
    public List<Hr> binding(){
    
        return this.convertHrList(this.hrDAO.getAll());
    }
    
    public List<Hr> find(String category, String data){
    
        return this.convertHrList(this.hrDAO.search(category, data));
    }
    
    public Hr getbyId(String hrId){
    
        return this.hrDAO.getHrById(hrId);
    }
}
