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
import controllers.SiteController;
import controllers.CustomerController;
import tools.HibernateUtil;
import entities.Site;
import entities.Customer;

/**
 *
 * @author Dayinta Warih Wulandari
 */
@WebServlet(name = "ServletNonAktifSite", urlPatterns = {"/servletNonAktifSite"})
public class ServletNonAktifSite extends HttpServlet {

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
        String id = request.getParameter("id");
        SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
        CustomerController cc = new CustomerController(HibernateUtil.getSessionFactory());
        String idfix = "";
        String sitename = "";
        String idcus = "";
        String nama = "";
        String user = "";
        String pass = "";
//        Site s = sc.getById(id);
//        s.getCustomerList();
            for (Site site : sc.binding()) {
                if (site.getId().equalsIgnoreCase(id)) {
//                    idfix += site.getId();
                    sitename += site.getSite();
                    for (Customer customer : site.getCustomerList()) {
                        if (customer.getSiteId().getId().equalsIgnoreCase(id)) {
                            idcus += customer.getId();
                            nama += customer.getNama();
                            user += customer.getUsername();
                            pass += customer.getPassword();
                        }
                    }
                }
            }
//                        Customer customer1 = cc.getById(idcus);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (sc.saveOrEdit(id, sitename, "0")) {
                cc.saveOrEdit(idcus, nama, user, pass, 0, "3", id);
                response.sendRedirect("hrDanCustomerView/sitePage.jsp");
            } else {
                out.println("GAGAL!!");
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
