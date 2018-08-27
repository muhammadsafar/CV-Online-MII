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
@Table(name = "TECHNICAL_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechnicalAd.findAll", query = "SELECT t FROM TechnicalAd t")
    , @NamedQuery(name = "TechnicalAd.findById", query = "SELECT t FROM TechnicalAd t WHERE t.id = :id")})
public class TechnicalAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "TEC_ID", referencedColumnName = "ID")
    @ManyToOne
    private TechnicalQualification tecId;

    public TechnicalAd(SessionFactory factory) {
    }
    
    public TechnicalAd(Integer id) {
        this.id = id;
    }

    public TechnicalAd(Integer id, AppDev adId, TechnicalQualification tecId) {
        this.id = id;
        this.adId = adId;
        this.tecId = tecId;
    }

    public TechnicalAd() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppDev getAdId() {
        return adId;
    }

    public void setAdId(AppDev adId) {
        this.adId = adId;
    }

    public TechnicalQualification getTecId() {
        return tecId;
    }

    public void setTecId(TechnicalQualification tecId) {
        this.tecId = tecId;
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
        if (!(object instanceof TechnicalAd)) {
            return false;
        }
        TechnicalAd other = (TechnicalAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TechnicalAd[ id=" + id + " ]";
    }

}
