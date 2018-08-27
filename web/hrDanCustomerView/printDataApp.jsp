<%-- 
    Document   : printDataApp
    Created on : Aug 21, 2018, 5:48:40 PM
    Author     : MUHAMMAD BIN ZANDRA
--%>

<%@ page import="java.io.*"%>
<%@ page import="tools.HibernateUtil"%>
<%@ page import="tools.koneksi"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="net.sf.jasperreports.view.JRViewer"%>
<%@ page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Report App Dev</h1>

        <% 
        Connection conn = null;
        try{
//            
            conn = HibernateUtil.getSessionFactory().getSessionFactoryOptions()
                .getServiceRegistry().getService(ConnectionProvider.class).getConnection();
        
            conn.createStatement().execute("alter session set "
                + "current_schema = cvonline");

            
            File reportFile = new File(application.getRealPath("//reports//Application.jasper"));//your report_name.jasper file
//            Map parameters = new HashMap();
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), null, conn);
 
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
            }catch (Exception exx){
            out.print("Error"+exx.getMessage());
        }
        %>
    </body>
</html>
