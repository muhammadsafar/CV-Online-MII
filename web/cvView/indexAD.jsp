<%-- 
    Document   : indexAD
    Created on : Aug 14, 2018, 10:44:42 AM
    Author     : Dayinta Warih Wulandari
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="entities.AppDev"%>
<%@page import="entities.Education"%>
<%@page import="entities.EducationAd"%>
<%@page import="entities.AdSite"%>
<%@page import="entities.Award"%>
<%@page import="entities.AwardAd"%>
<%@page import="entities.Experience"%>
<%@page import="entities.ExperienceAd"%>
<%@page import="entities.ForeignLanguage"%>
<%@page import="entities.Organization"%>
<%@page import="entities.Site"%>
<%@page import="entities.TechnicalQualification"%>
<%@page import="entities.Training"%>
<%@page import="entities.TrainingAd"%>
<%@page import="entities.LanguageAd"%>
<%@page import="entities.OrganizationAd"%>
<%@page import="entities.TechnicalAd"%>
<%@page import="controllers.AppDevController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
if(session.getAttribute("toIndexAd") == null){
    response.sendRedirect("../hrDanCustomerView/login.jsp");

}else {

%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Resume</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/resume.min.css" rel="stylesheet">

    </head>

    <body id="page-top">
        <%
          String kode = session.getAttribute("toIndexAd").toString();
          AppDevController asd = new AppDevController(HibernateUtil.getSessionFactory());
          AppDev ad = asd.getById(kode);
          
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-darkgray fixed-top" id="sideNav">
            <a class="navbar-nav">
                <span class="d-none d-lg-block">
                    <img alt="brand" src="img/mii.png" width="100" height="70">
                    <img alt="brand" src="img/metrodata.png" width="60" height="70">
                </span>
            </a>
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none"></span>
                <span class="d-none d-lg-block">
                    <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="<%=ad.getPicture()%>" alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#experience">Experience</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#tq">Technical Qualification</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#education">Education</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#training">Training</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#award">Award</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="#organization">Organization</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger text-dark" href="../logOutServlet">LOGOUT</a>
                    </li>
            </div>
        </nav>

        <div class="container-fluid p-0">

            <section class="resume-section p-3 p-lg-5 d-flex d-column" id="about">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h1 class="mb-0"><%=ad.getNama()%>
                    </h1>
                    <div class="subheading mb-5"><%=ad.getAlamat()%> · <%=ad.getNohp()%> ·
                        <a href="mailto:name@email.com"><%=ad.getEmail()%></a>
                        <%
    Date tglLahir = ad.getBirthday();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dob = dateFormat.format(tglLahir);
                        %>
                        <p style="color: #bd5d38">Date of Birth: <%= dob %> </p>
                        <p>Gender: 
                            <% if(ad.getGender().equalsIgnoreCase("L")){
                            out.println("Laki-laki");
                            }
                            else if(ad.getGender().equalsIgnoreCase("P")){
                            out.println("Perempuan");
                                    }%>
                        </p>
                        <p style="color: #bd5d38">Nationality: <%=ad.getNationality()%></p>
                        <p>Marital Status: <%=ad.getMaritalStatus()%></p>
                        <p style="color: #bd5d38">Religion: <%=ad.getReligionId().getReligion()%></p>
                        <p>Foreign Language: 
                        <%
                        for (LanguageAd languageAd : ad.getLanguageAdList()) {
                        ForeignLanguage fl = languageAd.getLanguageId();    
                        %>
                        <%= fl.getLanguage() %>
                        <%
                            }
                        %>
                        </p>
                        <p style="color: #bd5d38">Status: <%=ad.getStatus()%>
                                                                                <%
                                        for (AdSite adSite : ad.getAdSiteList()) {
                                %>
                            (
                            <%=adSite.getSiteId().getSite() %>
                            )
                            <%
                            }
                            %>
                        </p>
                    </div>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="experience">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Experience</h2>
                    <%
                    for (ExperienceAd experienceAd : ad.getExperienceAdList()) {
                Experience experience = experienceAd.getExId();
                %>
                    <div class="resume-item d-flex flex-column flex-md-row mb-5">
                        <div class="resume-content mr-auto">
                            <h3 class="mb-0"><%= experienceAd.getPosisi() %></h3>
                            <div class="subheading mb-3"><%= experience.getExperience() %></div>
                        </div>
                        <div class="resume-date text-md-right">
                            <span class="text-primary"><%= experienceAd.getStartYear() %> - <%= experienceAd.getEndYear() %></span>
                        </div>
                    </div>
                    <%
                    }
                    %>
                </div>

            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="tq">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Technical Qualification</h2>
                    <div class="subheading mb-3">Programming Languages &amp; Tools</div>
                    <%
                    for (TechnicalAd technicalAd : ad.getTechnicalAdList()) {
                    TechnicalQualification qualification = technicalAd.getTecId();
                    %>
                    <li class="list-inline-item">
                        <i><%= qualification.getTecQualification() %></i>
                    </li>
                    <%
        }
                    %>
                </div>
            </section>
            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="education">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Education</h2>
                    <%
                                for (EducationAd ead : ad.getEducationAdList()) {
                Education edu = ead.getEducationId();
                    %>
                    <div class="resume-item d-flex flex-column flex-md-row mb-5">
                        <div class="resume-content mr-auto">
                            <h3 class="mb-0"><%= edu.getEducation() %></h3>
                            <div class="subheading mb-3">GPA: <%= ead.getGpa() %></div>
                        </div>
                        <div class="resume-date text-md-right">
                            <span class="text-primary"><%= ead.getPeriode() %></span>
                        </div>
                    </div>
                    <%
        }
                    %>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="training">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Training</h2>
                    <ul class="fa-ul mb-0">
                        <%
                        for (TrainingAd trainingAd : ad.getTrainingAdList()) {
                Training training = trainingAd.getTrainingId();
                %>
                        <li>
                            <i class="fa-li fa fa-check text-warning"></i>
                            <%= training.getTrainingName()%> (<%= trainingAd.getYear() %>)
                        </li>
                        <%
                        }
                        %>
                    </ul>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="award">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Award &amp; Certifications</h2>
                    <%
                    for (AwardAd awardAd : ad.getAwardAdList()) {
                Award a = awardAd.getAwardId();
                    %>
                    <ul class="fa-ul mb-0">
                        <li>
                            <i class="fa-li fa fa-trophy text-warning"></i>
                            <%= a.getAwardName() %> (<%= awardAd.getYear() %>)
                        </li>
                    </ul>
                    <%
                    }
                    %>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="organization">
                <a href="../addGeneral?editAdId=<%= ad.getNik() %>">Edit</a>
                <div class="my-auto">
                    <h2 class="mb-5">Organization</h2>
                    <%
                    for (OrganizationAd organizationAd : ad.getOrganizationAdList()) {
                    Organization organization = organizationAd.getOrganizationId();
                    %>
                    <ul class="fa-ul mb-0">
                        <li>
                            <i class="fa-li fa fa-check text-warning"></i>
                            <%= organization.getOrganizationName() %>
                        </li>
                    </ul>
                    <%
                    }
                    %>
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

<%
}
%>