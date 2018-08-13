/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TechQualificationDAO;
import entities.TechQualification;
import org.hibernate.SessionFactory;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class TechQualificationController {
    
    public TechQualificationDAO  tqdao;

    public TechQualificationController(SessionFactory factory) {
        this.tqdao = new TechQualificationDAO(factory);
    }

    public TechQualificationController() {
    }
    
    public boolean saveOrEdit(String id, String tq){
        TechQualification tq1 = new TechQualification
    }
    
}
