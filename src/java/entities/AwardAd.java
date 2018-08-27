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
@Table(name = "AWARD_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AwardAd.findAll", query = "SELECT a FROM AwardAd a")
    , @NamedQuery(name = "AwardAd.findById", query = "SELECT a FROM AwardAd a WHERE a.id = :id")
    , @NamedQuery(name = "AwardAd.findByYear", query = "SELECT a FROM AwardAd a WHERE a.year = :year")})
public class AwardAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEAR")
    private String year;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "AWARD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Award awardId;

    public AwardAd() {
    }
    
    public AwardAd(SessionFactory factory) {
    }

    public AwardAd(Integer id) {
        this.id = id;
    }

    public AwardAd(Integer id, String year, AppDev adId, Award awardId) {
        this.id = id;
        this.year = year;
        this.adId = adId;
        this.awardId = awardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public AppDev getAdId() {
        return adId;
    }

    public void setAdId(AppDev adId) {
        this.adId = adId;
    }

    public Award getAwardId() {
        return awardId;
    }

    public void setAwardId(Award awardId) {
        this.awardId = awardId;
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
        if (!(object instanceof AwardAd)) {
            return false;
        }
        AwardAd other = (AwardAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AwardAd[ id=" + id + " ]";
    }

}
