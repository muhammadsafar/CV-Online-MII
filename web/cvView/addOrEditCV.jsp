<%-- 
    Document   : addOrEditCV
    Created on : Aug 15, 2018, 9:40:26 AM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="entities.Religion"%>
<%@page import="entities.ForeignLanguage"%>
<%@page import="entities.LanguageAd"%>
<%@page import="controllers.ReligionController"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="entities.AppDev"%>
<%@page import="controllers.AppDevController"%>
<%@page import="controllers.FlController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Edit CV</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/resume.min.css" rel="stylesheet">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
        </script>
        <script type="text/javascript">
            function showData(value) {
                $.ajax({
                    url: "../TQAuto?inputTQ=" + value,
                    type: "POST",
                    async: false,
                    success: function (data) {
                        //Do something with the data here
                    }
                });
            }
        </script>
    </head>

    <body id="page-top">
        <% String nik = session.getAttribute("toEditAd").toString();
        AppDevController apd = new AppDevController(HibernateUtil.getSessionFactory());
        AppDev ad = apd.getById(nik);
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-nav">
                <span class="d-none d-lg-block">
                    <img alt="brand" src="img/mii.png" width="100" height="70">
                    <img alt="brand" src="img/metrodata.png" width="60" height="70">
                </span>
            </a>
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Clarence Taylor</span>
                <span class="d-none d-lg-block">
                    <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src=<%=ad.getPicture()%> alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#experience">Experience</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#tq">Technical Qualification</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#education">Education</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#training">Training</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#award">Award</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#organization">Organization</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="../cvView/indexAD.jsp">BACK</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid p-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="about">
                <div class="my-auto">
                    <h2 class="mb-5">General</h2>
                    <form method="GET" action="../servletEditAbout">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <label for="nik"></label>
                            <input class="border border-dark" name="user" type="hidden" id="inputUsername" class="form-control" value=<%=ad.getUsername()%>>
                            <label for="username"></label>
                            <input class="border border-dark" name="roleid" type="hidden" id="inputRoleid" class="form-control" value=<%=ad.getRoleId().getId()%>>
                            <label for="roleid"></label>
                            <input class="border border-dark" name="religionid" type="hidden" id="inputReligionid" class="form-control" value=<%=ad.getReligionId().getId()%>>
                            <label for="religionid"></label>
                            <input class="border border-dark" name="pict" type="hidden" id="inputPicture" class="form-control" value=<%=ad.getPicture()%>>
                            <label for="pict"></label>
                            <input class="border border-dark" name="status" type="hidden" id="inputStatus" class="form-control" value=<%=ad.getStatus()%>>
                            <label for="status"></label>
                            <input class="border border-dark" name="nama" type="text" id="inputNama" class="form-control" value="<%=ad.getNama()%>" required="required">
                            <label for="nm"></label>
                            <p>Password:
                                <input class="border border-dark" name="password" type="password" id="inputPassword" class="form-control" value=<%=ad.getPassword()%> required="required" >
                                <label for="pw"></label>
                            </p>
                            <input class="border border-dark" name="alamat" type="text" id="inputAlamat" class="form-control" value="<%=ad.getAlamat()%>" required="required" >
                            <label for="alamat"></label>
                            <%
Date tglLahir = ad.getBirthday();
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String dob = dateFormat.format(tglLahir);
                            %>
                            <p>Date of Birth:
                                <input class="border border-dark" name="dob" type="text" value=<%= dob %> id="inputDOB" class="form-control">
                            </p>
                            <input class="border border-dark" name="nohp" type="text" id="inputNoHP" class="form-control" value=<%=ad.getNohp()%> required="required" >
                            <label for="nh"></label>
                            <p></p>
                            <input class="border border-dark" name="email" type="text" id="inputEmail" class="form-control" value=<%=ad.getEmail()%> required="required" >
                            <label for="email"></label>
                            <p></p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <label>Religion: </label>
                                    &nbsp&nbsp&nbsp
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
                            <div>Kewarganegaraan:
                                <% if (ad.getNationality().equalsIgnoreCase("wni")){ %>
                                <input type="radio" name="rbkewarganegaraan" value="WNI" checked/> WNI
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbkewarganegaraan" value="WNA" /> WNA
                                <%} else if (ad.getNationality().equalsIgnoreCase("wna")){%>
                                <input type="radio" name="rbkewarganegaraan" value="WNI"/> WNI
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbkewarganegaraan" value="WNA" checked/> WNA
                                <%}%>
                                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

                                Jenis Kelamin:
                                <% if (ad.getGender().equalsIgnoreCase("l")){ %>
                                <input type="radio" name="rbgender" value="L" checked/> Laki-laki
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbgender" value="P" /> Perempuan
                                <%} else if (ad.getGender().equalsIgnoreCase("p")){%>
                                <input type="radio" name="rbgender" value="L" /> Laki-laki
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbgender" value="P" checked/> Perempuan
                                <%}%>
                            </div>
                            <div>Marital Status:
                                <% if (ad.getMaritalStatus().equalsIgnoreCase("Single")){ %>
                                <input type="radio" name="rbms" value="Single" checked/> Single
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbms" value="Married" /> Married
                                <%} else if (ad.getMaritalStatus().equalsIgnoreCase("Married")){%>
                                <input type="radio" name="rbms" value="Single"/> Single
                                &nbsp&nbsp&nbsp
                                <input type="radio" name="rbms" value="Married" checked/> Married
                                <%}%>
                            </div>
                            <br>
                            <p>Your Foreign Language: 
                                <%
                                for (LanguageAd languageAd : ad.getLanguageAdList()) {
                        ForeignLanguage fl = languageAd.getLanguageId(); 
                                %>
                                <%= fl.getLanguage() %>
                                <%
                                    }
                                %>
                            </p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <label>Add Foreign Language</label>
                                    &nbsp&nbsp&nbsp
                                    <select class="btn btn-outline-secondary dropdown-toggle" name="cblaguage">
                                        <%
                                            FlController flc = new FlController(HibernateUtil.getSessionFactory());
                                            for (ForeignLanguage fl : flc.binding()) {
                                        %>
                                        <option value="<%= fl.getId()%>"><%= fl.getLanguage()%></option>
                                        <%
                                        }
                                        %>
                                    </select>
                                </div>
                            </div> 
                        </div>
                        <p></p>
                        <button class="btn btn-black btn-block" type="submit">Save</button>
                    </form>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="experience">
                <div class="my-auto">
                    <h2 class="mb-5">Add Experience</h2>
                    <form method="GET" action="../servletEditExp">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" name="perusahaan" type="text" id="inputPerusahaan" class="form-control" placeholder="Company" required="required">
                            <label for="perusahaan"></label>
                            <p></p>
                            <input class="border border-dark" name="posisi" type="text" id="inputPosisi" class="form-control" placeholder="Position" required="required" >
                            <label for="posisi"></label>
                            <p></p>
                            <input class="border border-dark" name="start" type="text" id="inputStart" class="form-control" placeholder="Start (Month Year)" required="required" >
                            <label for="start"></label>
                            <p></p>
                            <input class="border border-dark" name="end" type="text" id="inputEnd" class="form-control" placeholder="End (Month Year) / Present" required="required" >
                            <label for="end"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
                </div>

            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="tq">
                <div class="my-auto">
                    <h2 class="mb-5">Add Technical Qualification</h2>
                    <form method="GET" action="../ServletEditTQ">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" type="text" name="inputTQ" id="inputTQ" class="form-control" placeholder="Skills or Tools" required="required" onkeyup="showData(this.value);">
                            <label for="skillortools"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
            </section>
            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="education">
                <div class="my-auto">
                    <h2 class="mb-5">Add Education</h2>
                    <form method="GET" action="../servletEditEducation">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" name="university" type="text" id="inputUniversity" class="form-control" placeholder="University" required="required">
                            <label for="university"></label>
                            <p></p>
                            <input class="border border-dark" name="gpa" type="text" id="inputGPA" class="form-control" placeholder="GPA" required="required" >
                            <label for="gpa"></label>
                            <p></p>
                            <input class="border border-dark" name="periode" type="text" id="inputEndEd" class="form-control" placeholder="Periode" required="required" >
                            <label for="periode"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="training">
                <div class="my-auto">
                    <h2 class="mb-5">Add Training</h2>
                    <form method="GET" action="../servletEditTraining">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" name="trainingName" type="text" id="inputTraining" class="form-control" placeholder="Training Name" required="required">
                            <label for="training"></label>
                            <input class="border border-dark" name="year" type="text" id="inputYear" class="form-control" placeholder="Year" required="required">
                            <label for="year"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="award">
                <div class="my-auto">
                    <h2 class="mb-5">Add Award &amp; Certifications</h2>
                    <form method="GET" action="../servletEditAward">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" name="award" type="text" id="inputAward" class="form-control" placeholder="Award/Certification Name" required="required">
                            <label for="award"></label>
                            <input class="border border-dark" name="year" type="text" id="inputYear" class="form-control" placeholder="Year" required="required">
                            <label for="year"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="organization">
                <div class="my-auto">
                    <h2 class="mb-5">Add Organization</h2>
                    <form method="GET" action="../servletEditOrganization">
                        <div class="form-label-group d-flex flex-column">
                            <input class="border border-dark" name="nik" type="hidden" id="inputNik" class="form-control" value=<%=ad.getNik()%>>
                            <input class="border border-dark" name="organization" type="text" id="inputOrganization" class="form-control" placeholder="Organization Name" required="required">
                            <label for="organization"></label>
                        </div>
                        <div class="d-flex d-column">
                            <button class="btn btn-black btn-block" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </section>

        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/resume.min.js"></script>

    </body>

</html>
