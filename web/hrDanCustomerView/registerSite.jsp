<%-- 
    Document   : register
    Created on : Aug 14, 2018, 5:06:41 AM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="entities.Site"%>
<%@page import="controllers.SiteController"%>
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

        <title>HR - Register Site</title>

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body class="bg-dark">
        <% SiteController sc = new SiteController(HibernateUtil.getSessionFactory()); %>
        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Add Site</div>
                <div class="card-body">
                    <form method="post" action="../registrasiSite">
                        <div class="form-group">
                            <div class="form-label-group">
                                <div>
                                    <input type="hidden" name="siteId" id="inputSiteid" class="form-control" value="<%= sc.autoId()%>">
                                </div>
                                <div>
                                    <label for="siteName">Site Name</label>
                                    <input type="text" name="siteName" id="inputSiteNama" class="form-control" placeholder="Site Name" required="required">
                                </div>
                                <div>
                                    <input type="hidden" name="siteStatus" id="inputSiteStatus" class="form-control" placeholder="Site Status" value="1">
                                </div>
                            </div>
                        </div>

                        <button class="btn btn-primary btn-block" type="submit">Add Site</button>
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

