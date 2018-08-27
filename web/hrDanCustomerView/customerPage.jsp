<%-- 
    Document   : customerPage
    Created on : Aug 13, 2018, 4:10:02 PM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="entities.Customer"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="controllers.CustomerController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HR - Dashboard</title>

        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body id="page-top">
        <%
           CustomerController cc  = new CustomerController(HibernateUtil.getSessionFactory());
        %>
        <nav class="navbar navbar-expand navbar-dark static-top bg-dark">

            <a class="navbar-brand mr-1" href="mainHR.jsp">CV ONLINE</a>
            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>
            <!-- Logo -->
            <ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <span class="d-none d-lg-block">
                    <img alt="brand" src="image/mii.png" width="100" height="70">
                    <img alt="brand" src="image/metrodata.png" width="60" height="70">
                </span>
            </ul>
        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav bg-dark">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Dashboard</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Add data:</h6>
                        <a class="dropdown-item" href="registerSite.jsp">Site</a>
                        <a class="dropdown-item" href="registerCustomer.jsp">Customer</a>
                        <a class="dropdown-item" href="registerAD.jsp">Application Developer</a>
                        <div class="dropdown-divider"></div>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="adPage.jsp">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Application Developer</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sitePage.jsp">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Site</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customerPage.jsp">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Customer</span></a>
                </li>
            </ul>
            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="adPage.jsp">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <!-- DataTables -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Data Customer</div>
                        <form action="printDataCustomers.jsp">
                            <button class="btn btn-primary btn-block" type="submit">Print</button>
                        </form>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Customer ID</th>
                                            <th>Name</th>
                                            <th>Site</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>No</th>
                                            <th>Customer ID</th>
                                            <th>Name</th>
                                            <th>Site</th>
                                            <th>Status</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
            int i = 1;
                for (Customer customer : cc.binding()) {
                                        %>
                                        <tr>
                                            <td><%= i%></td>
                                            <td><%= customer.getId()%></td>
                                            <td><%= customer.getNama()%></td>
                                            <td><%= customer.getSiteId().getSite() %></td>
                                            <td><%
                                                if(customer.getStatus() == 1){
                                                    out.println("Aktif");
                                                } else {
                                                    out.println("Tidak Aktif");
                                                }
                                                %></td>
                                            </td>
                                        </tr>
                                        <%
        i++;
    }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Ayin&Safar 2018</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.jsp">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>
    </body>
</html>