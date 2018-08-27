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
import org.hibernate.SessionFactory;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "EXPERIENCE_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienceAd.findAll", query = "SELECT e FROM ExperienceAd e")
    , @NamedQuery(name = "ExperienceAd.findById", query = "SELECT e FROM ExperienceAd e WHERE e.id = :id")
    , @NamedQuery(name = "ExperienceAd.findByStartYear", query = "SELECT e FROM ExperienceAd e WHERE e.startYear = :startYear")
    , @NamedQuery(name = "ExperienceAd.findByEndYear", query = "SELECT e FROM ExperienceAd e WHERE e.endYear = :endYear")
    , @NamedQuery(name = "ExperienceAd.findByPosisi", query = "SELECT e FROM ExperienceAd e WHERE e.posisi = :posisi")})
public class ExperienceAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "START_YEAR")
    private String startYear;
    @Column(name = "END_YEAR")
    private String endYear;
    @Column(name = "POSISI")
    private String posisi;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "EX_ID", referencedColumnName = "ID")
    @ManyToOne
    private Experience exId;

    public ExperienceAd() {
    }
    
    public ExperienceAd(SessionFactory factory) {
    }

    public ExperienceAd(Integer id) {
        this.id = id;
    }

    public ExperienceAd(Integer id, String startYear, String endYear, String posisi, AppDev adId, Experience exId) {
        this.id = id;
        this.startYear = startYear;
        this.endYear = endYear;
        this.posisi = posisi;
        this.adId = adId;
        this.exId = exId;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public AppDev getAdId() {
        return adId;
    }

    public void setAdId(AppDev adId) {
        this.adId = adId;
    }

    public Experience getExId() {
        return exId;
    }

    public void setExId(Experience exId) {
        this.exId = exId;
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
        if (!(object instanceof ExperienceAd)) {
            return false;
        }
        ExperienceAd other = (ExperienceAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExperienceAd[ id=" + id + " ]";
    }

}
