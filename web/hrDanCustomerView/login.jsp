<%-- 
    Document   : login
    Created on : Aug 18, 2018, 3:21:54 PM
    Author     : Dayinta Warih Wulandari
--%>

<%@page import="entities.AppDev"%>
<%@page import="controllers.AppDevController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - Login</title>

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>
    
    <%
    AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
    %>    
    <body class="bg-dark">
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <%for (AppDev ad : adc.binding()) {%>
                    <form action="../cek" method="post"> 
                        <%}%>
                        <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" placeholder="Username" required="required">
                             </div>
                        <div class="form-group">
                                <label >Password</label>
                                <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                           
                        </div>
                        <button class="btn btn-primary btn-block" type="submit">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>