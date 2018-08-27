<%-- 
    Document   : registerCustomer
    Created on : Aug 14, 2018, 5:20:41 AM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="entities.Site"%>
<%@page import="controllers.SiteController"%>
<%@page import="controllers.CustomerController"%>
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

        <title>HR - Register Customer</title>

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body class="bg-dark">
    <% CustomerController cc = new CustomerController(HibernateUtil.getSessionFactory()); %>
        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register a Customer</div>
                <div class="card-body">
                    <form action="../registrasiCus" method="post">
                        <div class="form-label-group">
                            <div>
                                <input type="hidden" id="name" name="id" class="form-control" placeholder="ID" value="<%= cc.autoId()%>">
                            </div>
                            <div>
                                <label for="name">Name</label>
                                <input type="text" id="name" name="nama" class="form-control" placeholder="Name" required="required">
                            </div>
                        </div>
                        <div>
                            <label for="username">Username</label>
                            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="required">
                        </div>
                        <div>
                            <div>
                                <label for="password">Password</label>
                                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
                            </div>
                        </div>
                        <p></p>
                        <div>
                            <label for="inputSite">Site</label>
                            <select class="btn btn-outline-secondary dropdown-toggle" name="cbsite">
                                <%
                                    SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
                                    for (Site site : sc.binding()) {
                                %>
                                <option value="<%= site.getId()%>"><%= site.getSite()%></option>
                                <%
                                }
                                %>
                            </select>
                        </div>
                        <p></p>
                        <button class="btn btn-primary btn-block" type="submit">Add Customer</button>
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