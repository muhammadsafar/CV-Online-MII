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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
@Entity
@Table(name = "APP_DEV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppDev.findAll", query = "SELECT a FROM AppDev a")
    , @NamedQuery(name = "AppDev.findByNik", query = "SELECT a FROM AppDev a WHERE a.nik = :nik")
    , @NamedQuery(name = "AppDev.findByUsername", query = "SELECT a FROM AppDev a WHERE a.username = :username")
    , @NamedQuery(name = "AppDev.findByPassword", query = "SELECT a FROM AppDev a WHERE a.password = :password")
    , @NamedQuery(name = "AppDev.findByName", query = "SELECT a FROM AppDev a WHERE a.name = :name")
    , @NamedQuery(name = "AppDev.findByAddress", query = "SELECT a FROM AppDev a WHERE a.address = :address")
    , @NamedQuery(name = "AppDev.findByBirthday", query = "SELECT a FROM AppDev a WHERE a.birthday = :birthday")
    , @NamedQuery(name = "AppDev.findByNationality", query = "SELECT a FROM AppDev a WHERE a.nationality = :nationality")
    , @NamedQuery(name = "AppDev.findByMaritalStatus", query = "SELECT a FROM AppDev a WHERE a.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "AppDev.findByGender", query = "SELECT a FROM AppDev a WHERE a.gender = :gender")
    , @NamedQuery(name = "AppDev.findByStatus", query = "SELECT a FROM AppDev a WHERE a.status = :status")})
public class AppDev implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
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
    @ManyToMany(mappedBy = "appDevList", fetch = FetchType.LAZY)
    private List<Oganization> oganizationList;
    @ManyToMany(mappedBy = "appDevList", fetch = FetchType.LAZY)
    private List<Education> educationList;
    @ManyToMany(mappedBy = "appDevList", fetch = FetchType.LAZY)
    private List<TechQualification> techQualificationList;
    @ManyToMany(mappedBy = "appDevList", fetch = FetchType.LAZY)
    private List<ForeignLanguage> foreignLanguageList;
    @JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Religion religionId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role roleId;

    public AppDev() {
    }

    public AppDev(String nik) {
        this.nik = nik;
    }

    public AppDev(String nik, String username, String password, String name) {
        this.nik = nik;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @XmlTransient
    public List<Oganization> getOganizationList() {
        return oganizationList;
    }

    public void setOganizationList(List<Oganization> oganizationList) {
        this.oganizationList = oganizationList;
    }

    @XmlTransient
    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    @XmlTransient
    public List<TechQualification> getTechQualificationList() {
        return techQualificationList;
    }

    public void setTechQualificationList(List<TechQualification> techQualificationList) {
        this.techQualificationList = techQualificationList;
    }

    @XmlTransient
    public List<ForeignLanguage> getForeignLanguageList() {
        return foreignLanguageList;
    }

    public void setForeignLanguageList(List<ForeignLanguage> foreignLanguageList) {
        this.foreignLanguageList = foreignLanguageList;
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
