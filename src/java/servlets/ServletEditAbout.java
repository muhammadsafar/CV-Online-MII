/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AppDevController;
import controllers.FlController;
import controllers.LanguageAdController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletEditAbout", urlPatterns = {"/servletEditAbout"})
public class ServletEditAbout extends HttpServlet {

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
        String password = request.getParameter("password");
        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        String birthday = request.getParameter("dob");
        String nationality = request.getParameter("rbkewarganegaraan");
        String ms = request.getParameter("rbms");
        String gender = request.getParameter("rbgender");
        String status = request.getParameter("status");
        String roleid = request.getParameter("roleid");
        String religionid = request.getParameter("cbreligion");
        String nohp = request.getParameter("nohp");
        String email = request.getParameter("email");
        String pict = request.getParameter("pict");
        String user = request.getParameter("user");
        String lang = request.getParameter("cblaguage");
        try (PrintWriter out = response.getWriter()) {
//        out.println(nik);
//        out.println(password);
//        out.println(nama);
//        out.println(alamat);
//        out.println(birthday);
//        out.println(nationality);
//        out.println(ms);
//        out.println(gender);
//        out.println(status);
//        out.println(roleid);
//        out.println(religionid);
//        out.println(nohp);
//        out.println(email);
//        out.println(pict);
//        out.println(user);
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date tglLahir = dateFormat.parse(birthday);
            AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
            LanguageAdController lac = new LanguageAdController(HibernateUtil.getSessionFactory());
            String id = (String) lac.autoId();
            int idfix = Integer.parseInt(id);
            if (adc.saveOrEdit(nik, "", password, nama, alamat, tglLahir, nationality, ms, gender, status, email,
                    nohp, pict, roleid, religionid) && lac.insertOrUpdate(idfix, nik, lang)) {
                response.sendRedirect("cvView/indexAD.jsp");
            } else {
                out.print("failed to edit cv");
            }

        } catch (ParseException ex) {
            Logger.getLogger(ServletEditAbout.class.getName()).log(Level.SEVERE, null, ex);
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
