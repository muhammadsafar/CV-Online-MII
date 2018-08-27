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
@Table(name = "TRAINING_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingAd.findAll", query = "SELECT t FROM TrainingAd t")
    , @NamedQuery(name = "TrainingAd.findById", query = "SELECT t FROM TrainingAd t WHERE t.id = :id")
    , @NamedQuery(name = "TrainingAd.findByYear", query = "SELECT t FROM TrainingAd t WHERE t.year = :year")})
public class TrainingAd implements Serializable {

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
    @JoinColumn(name = "TRAINING_ID", referencedColumnName = "ID")
    @ManyToOne
    private Training trainingId;

    public TrainingAd() {
    }

    public TrainingAd(SessionFactory factory) {
    }
    
    public TrainingAd(Integer id) {
        this.id = id;
    }

    public TrainingAd(Integer id, String year, AppDev adId, Training trainingId) {
        this.id = id;
        this.year = year;
        this.adId = adId;
        this.trainingId = trainingId;
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

    public Training getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Training trainingId) {
        this.trainingId = trainingId;
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
        if (!(object instanceof TrainingAd)) {
            return false;
        }
        TrainingAd other = (TrainingAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TrainingAd[ id=" + id + " ]";
    }

}
