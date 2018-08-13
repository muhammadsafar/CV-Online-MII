/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CustomerDAO;
import entities.Customer;
import entities.Site;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class CustomerController {
    
    public CustomerDAO cdao;

    public CustomerController(SessionFactory factory) {
        this.cdao = new CustomerDAO(factory);
    }

    public CustomerController() {
    }
    
    public boolean saveOrEdit(String id, String nama, String username, String pass, Role roleId, Site siteId){
    
        Customer customer = new Customer(id, nama, username, pass, roleId, siteId);
        return this.cdao.insertOrUpdate(customer);
    }
    
    public List<Customer> convertCustomerList(List<Object> dataAwal){
    
        List<Customer> dataCus = new ArrayList<>();
        for (Object object : dataAwal) {
     
            Customer customer = (Customer) object;
            dataCus.add(customer);
        }
        return dataCus;
    }
    
    public List<Customer> binding(){
    
        return this.convertCustomerList(this.cdao.getAll());
    }
    
    public List<Customer> find(String category, String data){
    
        return this.convertCustomerList(this.cdao.search(category, data));
    }
    
    public Customer getById(String cusId){
    
        return this.cdao.getCustomerById(cusId);
    }
    
    
    
}
