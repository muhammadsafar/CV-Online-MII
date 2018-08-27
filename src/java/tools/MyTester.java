/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import servlets.TQAuto;
import controllers.AppDevController;
import controllers.CustomerController;
import controllers.RoleController;
import controllers.SiteController;
import controllers.AwardController;
import controllers.HrController;
import controllers.EducationController;
import controllers.FlController;
import controllers.LanguageAdController;
import controllers.TechnicalAdController;
import controllers.TechQualificationController;
import controllers.TrainingAdController;
import controllers.TrainingController;
import controllers.OrganizationAdController;
import controllers.OrganizationController;
import controllers.AwardAdController;
import controllers.EducationAdController;
import controllers.ExperienceController;
import controllers.ExperienceAdController;

import entities.AppDev;
import entities.AdSite;
import entities.Award;
import entities.AwardAd;
import entities.Customer;
import entities.Education;
import entities.EducationAd;
import entities.Experience;
import entities.ExperienceAd;
import entities.ForeignLanguage;
import entities.Organization;
import entities.Hr;
import entities.LanguageAd;
import entities.OrganizationAd;
import entities.Role;
import entities.Site;
import entities.TechnicalAd;
import entities.TechnicalQualification;
import entities.Training;
import entities.TrainingAd;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
public class MyTester {

    public static void main(String[] args) throws ParseException {

        HibernateUtil hibernateUtil = new HibernateUtil();
        //System.out.println(HibernateUtil.getSessionFactory());

//        AwardController ac = new AwardController(HibernateUtil.getSessionFactory());
//        
//        for (Award award : ac.binding()) {
//            
//            System.out.println("Award name :"+award.getAwardName()+"====award Id: "+award.getId());
//        }
//CustomerController cc = new CustomerController(HibernateUtil.getSessionFactory());
//        for (Customer customer : cc.binding()) {
//            System.out.println(customer.getSiteId().getSite());
//        }
//        SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
//        for (Site site : sc.binding()) {
//            System.out.println(site.getCustomerList().size());
//        }
//        AppDevController ac = new AppDevController(HibernateUtil.getSessionFactory());
//        for (AppDev appDev : ac.find("nik", "001100")) {
//            System.out.println("Nama:" + appDev.getNama());
//        }
//    EducationController ec = new EducationController(HibernateUtil.getSessionFactory());
////    List apd = new ArrayList();
//        for (Education education : ec.binding()) {
////            apd.addAll(education.getAppDevList());
//            //List<AppDev> apd = (List<AppDev>)education.getAppDevList();
//            //AppDev ad = (AppDev) education.getAppDevList();
//            //System.out.println(education.getEducation());
//            System.out.println("Size: "+education.getAppDevList().size());
//            //System.out.println(ad.getNama());
//        }
//HrController hc = new HrController(HibernateUtil.getSessionFactory());
//        System.out.println(hc.getbyUser("dayinta").getNama());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tglLahir = dateFormat.parse("1999-01-19 ");
        AppDevController adc = new AppDevController(HibernateUtil.getSessionFactory());
//        for (AppDev appDev : adc.binding()) {
//            System.out.println(appDev.getBirthday());
//        }
        //System.out.println(adc.autoId());
//        System.out.println(adc.editStatus("20000", "On Site"));
//String nik ="20000";
//            AppDev ad = adc.getById(nik);
//            String rpleid = ad.getRoleId();
//            if (adc.saveOrEdit(nik, ad.getUsername(), ad.getPassword(), ad.getNama(), ad.getAlamat(), ad.getBirthday(),
//                    ad.getNationality(), ad.getMaritalStatus(), ad.getGender(), "Interview", ad.getNohp(), ad.getEmail(), ad.getPicture(), 
//                    ad.getRoleId().getRole(), ad.getReligionId().getReligion())){
//                System.out.println("YAY");
//            } else {
//                System.out.println("NAY");
//            }

//        boolean result = adc.saveOrEdit("1", "Josako", "Ndasem", "Joko", "Slipi", null, "WNI", "Merriage", "L", "satu", "085747478817", "joekelir", "", "1", "1");
//        System.out.println(result);
//        for (AppDev appDev : adc.binding()) {
//            System.out.println(appDev.getNama());
//            for (Education education : appDev.getEducationList()) {
//                System.out.println(education.getEducation());
//            }
//        }
//String nik ="20003";
//String user ="";
//String pass ="kresna";
//String nama ="Krena BS";
//String alamat ="Karawang";
//Date dob =tglLahir;
//String nationality ="WNI";
//String ms ="Single";
//String gender ="L";
//String stat ="Free";
//String nope ="72777777";
//String email ="bangkres@gmail.com";
//String pict ="img/kresna.png";
//String roleid ="2";
//String agamaid ="1";
//        System.out.println("panjang nope: " + nope.length());
//        if (adc.saveOrEdit(nik, 
//                user, 
//                pass, 
//                nama, 
//                alamat, 
//                dob, 
//                nationality, 
//                ms, 
//                gender, 
//                stat,  
//                email,
//                nope,
//                pict, 
//                roleid, 
//                agamaid)) {
//            System.out.println("success");
//        } else {
//            System.out.println("failed to edit cv");
//        }
//        for (AppDev appDev : adc.binding()) {
//            System.out.println(appDev.getNama());
//            for (EducationAd ad : appDev.getEducationAdList()) {
//                Education edu = ad.getEducationId();
//                System.out.println(edu.getEducation() + " - "
//                        + ad.getGpa() + " - "
//                        + ad.getPeriode()
//                );
//            }
//            for (LanguageAd languageAd : appDev.getLanguageAdList()) {
//                ForeignLanguage fl = languageAd.getLanguageId();
//                System.out.println(fl.getLanguage());
//            }
//            for (AdSite adSite : appDev.getAdSiteList()) {
//                Site s = adSite.getSiteId();
//                System.out.println(s.getSite()+" - "+adSite.getStatus()+" - "+adSite.getReview());
//            }
//            for (AwardAd awardAd : appDev.getAwardAdList()) {
//                Award a = awardAd.getAwardId();
//                System.out.println(a.getAwardName()+" - "+awardAd.getYear());
//            }
//            for (ExperienceAd experienceAd : appDev.getExperienceAdList()) {
//                Experience experience = experienceAd.getExId();
//                System.out.println(experience.getExperience()+" - "+experienceAd.getPosisi()
//                        +" - "+experienceAd.getStartYear()+" - "+experienceAd.getEndYear());
//            }
//            for (OrganizationAd organizationAd : appDev.getOrganizationAdList()) {
//                Organization organization = organizationAd.getOrganizationId();
//                System.out.println(organization.getOrganizationName());
//            }
//            for (TechnicalAd technicalAd : appDev.getTechnicalAdList()) {
//                TechnicalQualification qualification = technicalAd.getTecId();
//                System.out.println(qualification.getTecQualification());
//            }
//            for (TrainingAd trainingAd : appDev.getTrainingAdList()) {
//                Training training = trainingAd.getTrainingId();
//                System.out.println(training.getTrainingName()+" - "+trainingAd.getYear());
//            }
//            System.out.println("----------------------------------------");
//        }
        FlController flc = new FlController(HibernateUtil.getSessionFactory());
//        for (ForeignLanguage foreignLanguage : flc.binding()) {
//            System.out.println(foreignLanguage.getLanguage());
//        }
        AppDevController apd = new AppDevController(HibernateUtil.getSessionFactory());
//        AppDev app = apd.getById("20005");
//        ForeignLanguage fl = flc.getById("1");
////        List<ForeignLanguage> dataLanguage = new ArrayList<ForeignLanguage>();
////        dataLanguage.add(fl);
////        flc.saveOrEdit(fl.getId().toString(), fl.getLanguage());
////        app.setForeignLanguageList(dataLanguage);
////        System.out.println(apd.saveOrEdit(app));
//        List<AppDev> appdevs = new ArrayList<>();
//        appdevs.add(app);
//        fl.setAppDevList(appdevs);
//        System.out.println(flc.save(fl));
//        LanguageAdController lac = new LanguageAdController(HibernateUtil.getSessionFactory());
//        String id = (String) lac.autoId();
//        int idfix = Integer.parseInt(id);
//        System.out.println(idfix);
//        System.out.println(lac.insertOrUpdate(idfix, "20001", "3"));

//        TrainingAdController trainingAdController = new TrainingAdController(HibernateUtil.getSessionFactory());
//        TrainingController trainingController = new TrainingController(HibernateUtil.getSessionFactory());
//        for (Training training : trainingController.binding()) {
//            System.out.println(training.getTrainingName());
//        }
//        OrganizationAdController oac = new OrganizationAdController(HibernateUtil.getSessionFactory());
//        OrganizationController oc = new OrganizationController(HibernateUtil.getSessionFactory());
        AwardController awardController = new AwardController(HibernateUtil.getSessionFactory());
        AwardAdController aac = new AwardAdController(HibernateUtil.getSessionFactory());
//        EducationController ec = new EducationController(HibernateUtil.getSessionFactory());
//        EducationAdController eac = new EducationAdController(HibernateUtil.getSessionFactory());
        
//        ExperienceController experienceController = new ExperienceController(HibernateUtil.getSessionFactory());
//        ExperienceAdController experienceAdController = new ExperienceAdController(HibernateUtil.getSessionFactory());
//        String awardName = "Juara 1 OSN Biologi";
//        String adid = "20003";
//        String year = "2013";
//        String awadid = (String) aac.autoId();
//        int awadidfix = Integer.parseInt(awadid);
//        int idaward = 0;
//        int temp = 0;
//        for (Award award : awardController.binding()) {
//            if (awardName.equalsIgnoreCase(award.getAwardName())) {
//                System.out.println("ada");
//                idaward = award.getId();
//                temp++;
//            } else {
//                System.out.println("tidak ada");
//            }
//        }
//        if (temp > 0) {
//            aac.insertOrUpdate(awadidfix, year,
//                    adid,
//                    Integer.toString(idaward));
//        } else {
//            String awardid = (String) awardController.autoId();
//            awardController.saveOrEdit(awardid, awardName);
//            aac.insertOrUpdate(awadidfix, year,
//                    adid,
//                    awardid);
//        }

//        SiteController sc = new SiteController(HibernateUtil.getSessionFactory());
//        String s = sc.getById("S0008").getSite();
//        System.out.println(s);
        
        
//        AppDev ad = apd.getById("20001");
//        System.out.println(ad.getNama());
        for (Award award : awardController.find("awardName", "Juara")) {
            for (AwardAd awardAd : award.getAwardAdList()) {
                System.out.println("award = "+awardAd.getAdId().getNama());
            }
        }
    }
}
