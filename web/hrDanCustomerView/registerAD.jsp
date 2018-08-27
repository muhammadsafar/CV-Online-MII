<%-- 
    Document   : registrasiAD
    Created on : Aug 16, 2018, 4:45:24 AM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="entities.Religion"%>
<%@page import="controllers.ReligionController"%>
<%@page import="controllers.AppDevController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HR - Register HR</title>

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body class="bg-dark">
        <% AppDevController ac = new AppDevController(HibernateUtil.getSessionFactory()); %>
        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register an Application Developer</div>
                <div class="card-body">
                    <form method="post" action="../registrasiAppDev">
                        <div class="form-label-group">
                            <div>
                                <input type="hidden" name="nik" id="nik" class="form-control" value="<%= ac.autoId()%>" >
                            </div>
                            <div>
                                <label for="name">Name</label>
                                <input type="text" name="name" id="name" class="form-control" placeholder="Name" required="required">
                            </div>
                            <div>
                                <div>
                                    <label for="inputPassword">Password</label>
                                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                                </div>
                            </div>
                        </div>
                        <p></p>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <select class="btn btn-outline-secondary dropdown-toggle" name="cbreligion">
                                    <%
                                        ReligionController rc = new ReligionController(HibernateUtil.getSessionFactory());
                                        for (Religion rel : rc.binding()) {
                                    %>
                                    <option value="<%= rel.getId()%>"><%= rel.getReligion()%></option>
                                    <%
                                    }
                                    %>
                                </select>
                            </div>
                        </div>

                        <button class="btn btn-primary btn-block" type="submit">Add Application Developer</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    </body>

</html>