/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.EducationAdController;
import controllers.EducationController;
import entities.Education;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.HibernateUtil;

/**
 *
 * @author Dayinta Warih Wulandari
 */
@WebServlet(name = "ServletEditEducation", urlPatterns = {"/servletEditEducation"})
public class ServletEditEducation extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        EducationController ec = new EducationController(HibernateUtil.getSessionFactory());
        EducationAdController eac = new EducationAdController(HibernateUtil.getSessionFactory());
        String nik = request.getParameter("nik");
        String university = request.getParameter("university");
        String gpa = request.getParameter("gpa");
        String periode = request.getParameter("periode");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println(nik);
//            out.println(university);
//            out.println(gpa);
//            out.println(periode);
String eduadid = (String) eac.autoId();
        int eduadidfix = Integer.parseInt(eduadid);
        int idedu = 0;
        int temp = 0;
        
        for (Education education : ec.binding()) {
        if (university.equalsIgnoreCase(education.getEducation())) {
                System.out.println("ada");
                idedu = education.getId();
                temp++;
            } else {
                System.out.println("tidak ada");
            }
        }
        
//        System.out.println("temp=" + temp);
//        System.out.println("id education=" + idedu);
        if (temp > 0) {
            eac.insertOrUpdate(eduadidfix, gpa, periode,
                    nik,
                    Integer.toString(idedu));
        } else {
            String educationid = (String) ec.autoId();
            ec.saveOrEdit(educationid, university);
            eac.insertOrUpdate(eduadidfix, gpa, periode,
                    nik,
                    educationid);
        }
            response.sendRedirect("cvView/indexAD.jsp");
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
