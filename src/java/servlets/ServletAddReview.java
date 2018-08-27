/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AdSiteController;
import controllers.AppDevController;
import entities.AdSite;
import entities.AppDev;
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
@WebServlet(name = "ServletAddReview", urlPatterns = {"/servletAddReview"})
public class ServletAddReview extends HttpServlet {

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
        AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
        AdSiteController asc = new AdSiteController(HibernateUtil.getSessionFactory());
        String nik = request.getParameter("nik");
        String review = request.getParameter("review");
        AppDev ad = adc.getById(nik);
        String adid = "";
        int status = 0;
        String siteid = "";
        for (AdSite adSite : ad.getAdSiteList()) {
            adid += adSite.getId();
            status += adSite.getStatus();
            siteid += adSite.getSiteId().getId();
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println(nik);
//            out.println(review);
//            out.println(adid);
//            out.println(status);
//            out.println(siteid);
            
            if(asc.saveOrEdit(String.valueOf(adid), review, status, siteid, nik)){
                 response.sendRedirect("hrDanCustomerView/customerPage.jsp");
            }
            else {
                 response.sendRedirect("hrDanCustomerView/customerPage.jsp");
            }
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
