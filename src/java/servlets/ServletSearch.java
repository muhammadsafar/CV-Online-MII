/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controllers.AppDevController;
import controllers.AwardController;
import controllers.EducationController;
import controllers.ExperienceController;
import controllers.TrainingController;
import controllers.OrganizationController;
import controllers.TechQualificationController;
import entities.Award;
import entities.AwardAd;
import entities.Education;
import entities.EducationAd;
import entities.Experience;
import entities.ExperienceAd;
import entities.Organization;
import entities.OrganizationAd;
import entities.TechnicalAd;
import entities.TechnicalQualification;
import entities.Training;
import entities.TrainingAd;
import tools.HibernateUtil;

/**
 *
 * @author Dayinta Warih Wulandari
 */
@WebServlet(name = "ServletSearch", urlPatterns = {"/servletSearch"})
public class ServletSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        String table = request.getParameter("cbKategori");
        String keyword = request.getParameter("txtData");
        AwardController awardController = new AwardController(HibernateUtil.getSessionFactory());
        EducationController educationController = new EducationController(HibernateUtil.getSessionFactory());
        ExperienceController experienceController = new ExperienceController(HibernateUtil.getSessionFactory());
        OrganizationController organizationController = new OrganizationController(HibernateUtil.getSessionFactory());
        TrainingController trainingController = new TrainingController(HibernateUtil.getSessionFactory());
        TechQualificationController tqc = new TechQualificationController(HibernateUtil.getSessionFactory());
        String id = "";
                        
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
//            out.println(table);
//            out.println(keyword);
                        if (table.equalsIgnoreCase("award")) {
                for (Award award : awardController.find("awardName", keyword)) {
                    for (AwardAd awardAd : award.getAwardAdList()) {
                        out.println("NIK : "+awardAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+awardAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            } else if (table.equalsIgnoreCase("education")) {
                for (Education education : educationController.find("education", keyword)) {
                    for (EducationAd educationAd : education.getEducationAdList()) {
                        out.println("NIK : "+educationAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+educationAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            } else if (table.equalsIgnoreCase("experience")) {
                for (Experience experience : experienceController.find("experience", keyword)) {
                    for (ExperienceAd experienceAd : experience.getExperienceAdList()) {
                        out.println("NIK : "+experienceAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+experienceAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            } else if (table.equalsIgnoreCase("organization")) {
                for (Organization organization : organizationController.find("organization_name", keyword)) {
                    for (OrganizationAd organizationAd : organization.getOrganizationAdList()) {
                        out.println("NIK : "+organizationAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+organizationAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            } else if (table.equalsIgnoreCase("training")) {
                for (Training training : trainingController.find("training_name", keyword)) {
                    for (TrainingAd trainingAd : training.getTrainingAdList()) {
                        out.println("NIK : "+trainingAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+trainingAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            } else if (table.equalsIgnoreCase("technical qualification")) {
                for (TechnicalQualification technicalQualification : tqc.find("tec_qualification", keyword)) {
                    for (TechnicalAd technicalAd : technicalQualification.getTechnicalAdList()) {
                        out.println("NIK : "+technicalAd.getAdId().getNik()+"<br>");
                        out.println("NAMA : "+technicalAd.getAdId().getNama()+"<br>");
                    }
                out.println("<br>");
                }
            }
//            out.println("id = "+id);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
