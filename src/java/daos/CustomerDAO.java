/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Customer;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class CustomerDAO {

    public FunctionDAO fdao;

    public CustomerDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public boolean insertOrUpdate(Customer customer) {
        return this.fdao.insertOrUpdate(customer);
    }

    public List<Object> getAll() {
        return this.fdao.get("from Customer order by id");
    }

    public Customer getCustomerById(String customerId) {
        return (Customer) this.fdao.getById("from Customer where id = " + customerId + "");
    }

    public List<Object> search(String category, String data) {

        return this.fdao.get("from Customer where " + category + " like '%" + data + "%' ");
    }

    public String getAutoID() {
        return (String) this.fdao.getAutoId("select concat('C', LPAD((TO_NUMBER(SUBSTR(MAX(id), 2, 5))+1), 4, '0')) from Customer");
    }
}
