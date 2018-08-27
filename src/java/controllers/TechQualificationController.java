/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TechQualificationDAO;
import entities.TechnicalQualification;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class TechQualificationController {

    public TechQualificationDAO tqdao;

    public TechQualificationController(SessionFactory factory) {
        this.tqdao = new TechQualificationDAO(factory);
    }

    public TechQualificationController() {
    }

    public boolean saveOrEdit(String id, String tq) {
        TechnicalQualification tq1 = new TechnicalQualification(Integer.parseInt(id), tq);
        return this.tqdao.insertOrUpdate(tq1);
    }

    public List<TechnicalQualification> convertTqList(List<Object> dataAwal) {
        List<TechnicalQualification> dataTech = new ArrayList<>();
        for (Object object : dataAwal) {
            TechnicalQualification tq = (TechnicalQualification) object;
            dataTech.add(tq);
        }
        return dataTech;
    }

    public List<TechnicalQualification> binding() {
        return this.convertTqList(this.tqdao.getAll());
    }

    public List<TechnicalQualification> find(String category, String data) {
        return this.convertTqList(this.tqdao.search(category, data));
    }

    public TechnicalQualification getById(String techId) {
        return this.tqdao.getTqById(techId);
    }

    public Object autoId() {
        return this.tqdao.getAutoID();
    }
}
