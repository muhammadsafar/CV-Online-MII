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
import org.hibernate.SessionFactory;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "EXPERIENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e")
    , @NamedQuery(name = "Experience.findById", query = "SELECT e FROM Experience e WHERE e.id = :id")
    , @NamedQuery(name = "Experience.findByExperience", query = "SELECT e FROM Experience e WHERE e.experience = :experience")})
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EXPERIENCE")
    private String experience;
    @OneToMany(mappedBy = "exId")
    private List<ExperienceAd> experienceAdList;

    public Experience() {
    }

    public Experience(SessionFactory factory) {
    }

    public Experience(Integer id, String experience) {
        this.id = id;
        this.experience = experience;
    }
    
    public Experience(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @XmlTransient
    public List<ExperienceAd> getExperienceAdList() {
        return experienceAdList;
    }

    public void setExperienceAdList(List<ExperienceAd> experienceAdList) {
        this.experienceAdList = experienceAdList;
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
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Experience[ id=" + id + " ]";
    }

}
