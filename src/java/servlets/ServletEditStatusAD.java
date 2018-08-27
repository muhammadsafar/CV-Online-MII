/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AppDevController;
import controllers.AdSiteController;
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
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Dayinta Warih Wulandari
 */
@WebServlet(name = "ServletEditStatusAD", urlPatterns = {"/servletEditStatusAD"})
public class ServletEditStatusAD extends HttpServlet {

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
        String nik = request.getParameter("nik");
        String stat = request.getParameter("cbStatus");
        String siteId = request.getParameter("cbsite");
//        String role = request.getParameter("role");
//        String religion = request.getParameter("religion");
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
        AdSiteController asc = new AdSiteController(HibernateUtil.getSessionFactory());
        AppDev ad = adc.getById(nik);
        int adsiteid = 0;
        String review = "";
        for (AdSite adSite : ad.getAdSiteList()) {
            adsiteid = adSite.getId();
            review = adSite.getReview();
            adSite.getSiteId().getSite();
        }
        Date tglLahir = ad.getBirthday();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dob = dateFormat.format(tglLahir);
        try (PrintWriter out = response.getWriter()) {
//            out.println(nik);
//            out.println(stat);
//            out.println("DOB ="+dob);
//            out.print("");
//            out.println("role id = "+ ad.getRoleId().getId());
//            out.println("");
//            out.println("religion id = "+ ad.getReligionId().getId());
//            out.println("adsite id = "+ adsiteid);
            if (stat.equalsIgnoreCase("free")) {
                if (adc.saveOrEdit(nik, "", ad.getPassword(), ad.getNama(), ad.getAlamat(), ad.getBirthday(),
                        ad.getNationality(), ad.getMaritalStatus(), ad.getGender(), stat, ad.getEmail(), ad.getNohp(), ad.getPicture(),
                        String.valueOf(ad.getRoleId().getId()), String.valueOf(ad.getReligionId().getId()))) {
                    asc.saveOrEdit(String.valueOf(adsiteid), review, 0, siteId, nik);
                    out.print("success");
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                } else {
                    out.print("failed to add site");
                    out.print(nik);
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                }
            } else if (stat.equalsIgnoreCase("interview")) {
                if (adc.saveOrEdit(nik, "", ad.getPassword(), ad.getNama(), ad.getAlamat(), ad.getBirthday(),
                        ad.getNationality(), ad.getMaritalStatus(), ad.getGender(), stat, ad.getEmail(), ad.getNohp(), ad.getPicture(),
                        String.valueOf(ad.getRoleId().getId()), String.valueOf(ad.getReligionId().getId()))) {
                    asc.saveOrEdit((String) asc.autoId(), "", 0, siteId, nik);
                    out.print("success");
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                } else {
                    out.print("failed to add site");
                    out.print(nik);
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                }
            } else if (stat.equalsIgnoreCase("on site")) {
                if (adc.saveOrEdit(nik, "", ad.getPassword(), ad.getNama(), ad.getAlamat(), ad.getBirthday(),
                        ad.getNationality(), ad.getMaritalStatus(), ad.getGender(), stat, ad.getEmail(), ad.getNohp(), ad.getPicture(),
                        String.valueOf(ad.getRoleId().getId()), String.valueOf(ad.getReligionId().getId()))) {
                    asc.saveOrEdit(String.valueOf(adsiteid), review, 1, siteId, nik);
                    out.print("success");
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                } else {
                    out.print("failed to add site");
                    out.print(nik);
                    response.sendRedirect("hrDanCustomerView/adPage.jsp");
                }

                /* TODO output your page here. You may use following sample code. */
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }