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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
@Entity
@Table(name = "EDUCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findById", query = "SELECT e FROM Education e WHERE e.id = :id")
    , @NamedQuery(name = "Education.findByEducation", query = "SELECT e FROM Education e WHERE e.education = :education")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EDUCATION")
    private String education;
    @JoinTable(name = "EDUCATION_AD", joinColumns = {
        @JoinColumn(name = "EDUCATION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<AppDev> appDevList;

    public Education(Long id, String education) {
        this.id = id;
        this.education = education;
    }

    
    public Education() {
    }

    public Education(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @XmlTransient
    public List<AppDev> getAppDevList() {
        return appDevList;
    }

    public void setAppDevList(List<AppDev> appDevList) {
        this.appDevList = appDevList;
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
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Education[ id=" + id + " ]";
    }
    
}
