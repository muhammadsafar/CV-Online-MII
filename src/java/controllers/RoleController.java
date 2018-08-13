/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoleDAO;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class RoleController {
    
    public RoleDAO roleDAO;

    public RoleController() {
    }

    public RoleController(SessionFactory factory) {
        this.roleDAO = new RoleDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String role){
    
        Role role1 = new Role(Long.parseLong(id), role);
        return this.roleDAO.insertOrUpdate(role1);
    }
    
    public List<Role> convertRoleList(List<Object> dataAwal){
        List<Role> dataRole = new ArrayList<>();
        
        for (Object object : dataAwal) {
            
            Role role = (Role) object;
            dataRole.add(role);
        }
        return dataRole;
    }
    
    public List<Role> binding(){
    
        return this.convertRoleList(this.roleDAO.getAll());
    }
    
    public List<Role> find(String category, String data){
    
        return this.convertRoleList(this.roleDAO.search(category, data));
    }
    
    public Role getbyId(String roleId){
    
        return this.roleDAO.getRoleById(roleId);
    }
    
}
