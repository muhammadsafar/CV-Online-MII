/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.koneksi;

/**
 *
 * @author Dayinta Warih Wulandari
 */
@WebServlet(name = "cek", urlPatterns = {"/cek"})
public class cek extends HttpServlet {

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
        String _username = request.getParameter("username");
        String _password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        try (PrintWriter out = response.getWriter()) {
            try {

                try {
                    if (_username != null) {
                        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                        Connection connection = new koneksi().getConnection();

                        String queryHr = "select * from hr where username = ? and password = ? ";

                        PreparedStatement statement = connection.prepareStatement(queryHr);
                        statement.setString(1, _username);
                        statement.setString(2, _password);
                        ResultSet rs = statement.executeQuery();

                        if (rs.next()) {
                            response.sendRedirect("hrDanCustomerView/mainHR.jsp");
                        }else{
                            out.print("gagal masuk");
                        } 
                    }

                } catch (Exception e) {
                }
                try {
                    if (_username != null) {
                        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                        Connection connection = new koneksi().getConnection();

                        String queryCus = "select * from customer where username = ? and password = ? ";

                        PreparedStatement statement = connection.prepareStatement(queryCus);
                        statement.setString(1, _username);
                        statement.setString(2, _password);
                        ResultSet rs = statement.executeQuery();

                        if (rs.next()) {
                            response.sendRedirect("hrDanCustomerView/mainCustomer.jsp");
                        } else{
                            out.print("gagal masuk");
                        }                     }

                } catch (Exception e) {
                }
                try {
                    if (_username != null) {
                        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                        Connection connection = new koneksi().getConnection();

                        String queryAD = "select * from app_dev where username = ? and password = ? ";

                        PreparedStatement statement = connection.prepareStatement(queryAD);
                        statement.setString(1, _username);
                        statement.setString(2, _password);
                        ResultSet rs = statement.executeQuery();

                        if (rs.next()) {
                            response.sendRedirect("cvView/indexAD.jsp");
                        }else{
                            out.print("gagal masuk");
                        } 
                    }

                } catch (Exception e) {
                }

            } catch (Exception e) {
                out.print(e);
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
