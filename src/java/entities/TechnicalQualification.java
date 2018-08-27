/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "TECHNICAL_QUALIFICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechnicalQualification.findAll", query = "SELECT t FROM TechnicalQualification t")
    , @NamedQuery(name = "TechnicalQualification.findById", query = "SELECT t FROM TechnicalQualification t WHERE t.id = :id")
    , @NamedQuery(name = "TechnicalQualification.findByTecQualification", query = "SELECT t FROM TechnicalQualification t WHERE t.tecQualification = :tecQualification")})
public class TechnicalQualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TEC_QUALIFICATION")
    private String tecQualification;
    @OneToMany(mappedBy = "tecId")
    private List<TechnicalAd> technicalAdList;

    public TechnicalQualification() {
    }

    public TechnicalQualification(Integer id) {
        this.id = id;
    }
    
    public TechnicalQualification(SessionFactory factory) {
    }

    public TechnicalQualification(Integer id, String tecQualification) {
        this.id = id;
        this.tecQualification = tecQualification;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTecQualification() {
        return tecQualification;
    }

    public void setTecQualification(String tecQualification) {
        this.tecQualification = tecQualification;
    }

    @XmlTransient
    public List<TechnicalAd> getTechnicalAdList() {
        return technicalAdList;
    }

    public void setTechnicalAdList(List<TechnicalAd> technicalAdList) {
        this.technicalAdList = technicalAdList;
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
        if (!(object instanceof TechnicalQualification)) {
            return false;
        }
        TechnicalQualification other = (TechnicalQualification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TechnicalQualification[ id=" + id + " ]";
    }

}
