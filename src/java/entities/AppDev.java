/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "APP_DEV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppDev.findAll", query = "SELECT a FROM AppDev a")
    , @NamedQuery(name = "AppDev.findByNik", query = "SELECT a FROM AppDev a WHERE a.nik = :nik")
    , @NamedQuery(name = "AppDev.findByPassword", query = "SELECT a FROM AppDev a WHERE a.password = :password")
    , @NamedQuery(name = "AppDev.findByNama", query = "SELECT a FROM AppDev a WHERE a.nama = :nama")
    , @NamedQuery(name = "AppDev.findByAlamat", query = "SELECT a FROM AppDev a WHERE a.alamat = :alamat")
    , @NamedQuery(name = "AppDev.findByBirthday", query = "SELECT a FROM AppDev a WHERE a.birthday = :birthday")
    , @NamedQuery(name = "AppDev.findByNationality", query = "SELECT a FROM AppDev a WHERE a.nationality = :nationality")
    , @NamedQuery(name = "AppDev.findByMaritalStatus", query = "SELECT a FROM AppDev a WHERE a.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "AppDev.findByGender", query = "SELECT a FROM AppDev a WHERE a.gender = :gender")
    , @NamedQuery(name = "AppDev.findByStatus", query = "SELECT a FROM AppDev a WHERE a.status = :status")
    , @NamedQuery(name = "AppDev.findByNohp", query = "SELECT a FROM AppDev a WHERE a.nohp = :nohp")
    , @NamedQuery(name = "AppDev.findByEmail", query = "SELECT a FROM AppDev a WHERE a.email = :email")
    , @NamedQuery(name = "AppDev.findByPicture", query = "SELECT a FROM AppDev a WHERE a.picture = :picture")
    , @NamedQuery(name = "AppDev.findByUsername", query = "SELECT a FROM AppDev a WHERE a.username = :username")})
public class AppDev implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NOHP")
    private String nohp;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "USERNAME")
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId")
    private List<AdSite> adSiteList;
    @OneToMany(mappedBy = "adId")
    private List<TrainingAd> trainingAdList;
    @OneToMany(mappedBy = "adId")
    private List<ExperienceAd> experienceAdList;
    @OneToMany(mappedBy = "adId")
    private List<OrganizationAd> organizationAdList;
    @OneToMany(mappedBy = "adId")
    private List<EducationAd> educationAdList;
    @OneToMany(mappedBy = "adId")
    private List<TechnicalAd> technicalAdList;
    @OneToMany(mappedBy = "adId")
    private List<LanguageAd> languageAdList;
    @JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Religion religionId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(mappedBy = "adId")
    private List<AwardAd> awardAdList;

    public AppDev() {
    }

        public AppDev(String nik, String username, String password, String nama, String alamat, Date birthday, 
            String nationality, String maritalStatus, String gender, String status, String email, String nohp, 
            String picture, Role roleId, Religion religionId) {
        this.nik = nik;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.birthday = birthday;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.status = status;
        this.email = email;
        this.nohp = nohp;
        this.picture = picture;
        this.roleId = roleId;
        this.religionId = religionId;  
    }
    
    public AppDev(String nik, String username, String password, String nama) {
        this.nik = nik;
        this.password = password;
        this.nama = nama;
    }
    
     public AppDev(String nik, String status) {
        this.nik = nik;
        this.status = status;
    }

    public AppDev(String nik, String password, String nama) {
        this.nik = nik;
        this.password = password;
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<AdSite> getAdSiteList() {
        return adSiteList;
    }

    public void setAdSiteList(List<AdSite> adSiteList) {
        this.adSiteList = adSiteList;
    }

    @XmlTransient
    public List<TrainingAd> getTrainingAdList() {
        return trainingAdList;
    }

    public void setTrainingAdList(List<TrainingAd> trainingAdList) {
        this.trainingAdList = trainingAdList;
    }

    @XmlTransient
    public List<ExperienceAd> getExperienceAdList() {
        return experienceAdList;
    }

    public void setExperienceAdList(List<ExperienceAd> experienceAdList) {
        this.experienceAdList = experienceAdList;
    }

    @XmlTransient
    public List<OrganizationAd> getOrganizationAdList() {
        return organizationAdList;
    }

    public void setOrganizationAdList(List<OrganizationAd> organizationAdList) {
        this.organizationAdList = organizationAdList;
    }

    @XmlTransient
    public List<EducationAd> getEducationAdList() {
        return educationAdList;
    }

    public void setEducationAdList(List<EducationAd> educationAdList) {
        this.educationAdList = educationAdList;
    }

    @XmlTransient
    public List<TechnicalAd> getTechnicalAdList() {
        return technicalAdList;
    }

    public void setTechnicalAdList(List<TechnicalAd> technicalAdList) {
        this.technicalAdList = technicalAdList;
    }

    @XmlTransient
    public List<LanguageAd> getLanguageAdList() {
        return languageAdList;
    }

    public void setLanguageAdList(List<LanguageAd> languageAdList) {
        this.languageAdList = languageAdList;
    }

    public Religion getReligionId() {
        return religionId;
    }

    public void setReligionId(Religion religionId) {
        this.religionId = religionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public List<AwardAd> getAwardAdList() {
        return awardAdList;
    }

    public void setAwardAdList(List<AwardAd> awardAdList) {
        this.awardAdList = awardAdList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppDev)) {
            return false;
        }
        AppDev other = (AppDev) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AppDev[ nik=" + nik + " ]";
    }

}
