/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AwardAdController;
import controllers.AwardController;
import entities.Award;
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
@WebServlet(name = "ServletEditAward", urlPatterns = {"/servletEditAward"})
public class ServletEditAward extends HttpServlet {

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
        String nik = request.getParameter("nik");
        String awardName = request.getParameter("award");
        String year = request.getParameter("year");
        AwardController awardController = new AwardController(HibernateUtil.getSessionFactory());
        AwardAdController aac = new AwardAdController(HibernateUtil.getSessionFactory());
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                    String awadid = (String) aac.autoId();
        int awadidfix = Integer.parseInt(awadid);
        int idaward = 0;
        int temp = 0;
        for (Award award : awardController.binding()) {
            if (awardName.equalsIgnoreCase(award.getAwardName())) {
                System.out.println("ada");
                idaward = award.getId();
                temp++;
            } else {
                System.out.println("tidak ada");
            }
        }
        if (temp > 0) {
            aac.insertOrUpdate(awadidfix, year,
                    nik,
                    Integer.toString(idaward));
        } else {
            String awardid = (String) awardController.autoId();
            awardController.saveOrEdit(awardid, awardName);
            aac.insertOrUpdate(awadidfix, year,
                    nik,
                    awardid);
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
