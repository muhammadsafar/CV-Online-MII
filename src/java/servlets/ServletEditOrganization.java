/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.OrganizationAdController;
import controllers.OrganizationController;
import entities.Organization;
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
@WebServlet(name = "ServletEditOrganization", urlPatterns = {"/servletEditOrganization"})
public class ServletEditOrganization extends HttpServlet {

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
        OrganizationAdController oac = new OrganizationAdController(HibernateUtil.getSessionFactory());
        OrganizationController oc = new OrganizationController(HibernateUtil.getSessionFactory());
        String nik = request.getParameter("nik");
        String organizationName = request.getParameter("organization");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println(nik);
//            out.println(organizationName);
            String orgadid = (String) oac.autoId();
            int orgadidfix = Integer.parseInt(orgadid);
            int idorganization = 0;
            int temp = 0;
            for (Organization organization : oc.binding()) {
                if (organizationName.equalsIgnoreCase(organization.getOrganizationName())) {
                    System.out.println("ada");
                    idorganization = organization.getId();
                    temp++;
                } else {
                    System.out.println("tidak ada");
                }
            }
            System.out.println("temp=" + temp);
            System.out.println("id organization=" + idorganization);
            if (temp > 0) {
                oac.insertOrUpdate(orgadidfix,
                        nik,
                        Integer.toString(idorganization));
            } else {
                String orgid = (String) oc.autoId();
                oc.saveOrEdit(orgid, organizationName);
                oac.insertOrUpdate(orgadidfix,
                        nik,
                        orgid);
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
