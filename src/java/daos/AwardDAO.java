/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Award;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class AwardDAO {

    public FunctionDAO fdao;

    public AwardDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public boolean insertOrUpdate(Award award) {
        return this.fdao.insertOrUpdate(award);
    }

    public List<Object> getAll() {
        return this.fdao.get("from Award");
    }

    public Award getAwardById(String awardId) {
        return (Award) this.fdao.getById("from Award where id = " + awardId + "");
    }

    public List<Object> search(String category, String data) {
        return this.fdao.get("from Award where " + category + " like '%" + data + "%'");
    }

    public String getAutoID() {
        return (String) this.fdao.getAutoId("select to_char(to_number(max(id))+1) from Award");
    }
}
