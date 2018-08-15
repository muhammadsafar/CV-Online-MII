<%-- 
    Document   : editExperience
    Created on : Aug 15, 2018, 4:49:09 AM
    Author     : Dayinta Warih Wulandari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AD - Add Experience</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Add Experience</div>
        <div class="card-body">
          <form>
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="inputAward" class="form-control" placeholder="Company" required="required">
                <label for="comp"></label>
                <input type="text" id="inputYear" class="form-control" placeholder="Month Year (Start Year)" required="required">
                <label for="sy"></label>
                <input type="text" id="inputYear" class="form-control" placeholder="Month Year (End Year)" required="required">
                <label for="ey"></label>
                <input type="text" id="inputYear" class="form-control" placeholder="Position" required="required">
                <label for="posisi"></label>
              </div>
            </div>

            <a class="btn btn-primary btn-block" href="indexAD.jsp">Add Experience</a>
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