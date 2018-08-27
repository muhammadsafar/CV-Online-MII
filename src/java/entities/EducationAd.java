/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "EDUCATION_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationAd.findAll", query = "SELECT e FROM EducationAd e")
    , @NamedQuery(name = "EducationAd.findById", query = "SELECT e FROM EducationAd e WHERE e.id = :id")
    , @NamedQuery(name = "EducationAd.findByGpa", query = "SELECT e FROM EducationAd e WHERE e.gpa = :gpa")
    , @NamedQuery(name = "EducationAd.findByPeriode", query = "SELECT e FROM EducationAd e WHERE e.periode = :periode")})
public class EducationAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "GPA")
    private String gpa;
    @Column(name = "PERIODE")
    private String periode;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "EDUCATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Education educationId;

    public EducationAd() {
    }

    public EducationAd(Integer id, String gpa, String periode, AppDev adId, Education educationId) {
        this.id = id;
        this.gpa = gpa;
        this.periode = periode;
        this.adId = adId;
        this.educationId = educationId;
    }

    
    public EducationAd(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public AppDev getAdId() {
        return adId;
    }

    public void setAdId(AppDev adId) {
        this.adId = adId;
    }

    public Education getEducationId() {
        return educationId;
    }

    public void setEducationId(Education educationId) {
        this.educationId = educationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationAd)) {
            return false;
        }
        EducationAd other = (EducationAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EducationAd[ id=" + id + " ]";
    }

}
