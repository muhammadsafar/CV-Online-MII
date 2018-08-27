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
@Table(name = "AWARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Award.findAll", query = "SELECT a FROM Award a")
    , @NamedQuery(name = "Award.findById", query = "SELECT a FROM Award a WHERE a.id = :id")
    , @NamedQuery(name = "Award.findByAwardName", query = "SELECT a FROM Award a WHERE a.awardName = :awardName")})
public class Award implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AWARD_NAME")
    private String awardName;
    @OneToMany(mappedBy = "awardId")
    private List<AwardAd> awardAdList;

    public Award() {
    }

    public Award(SessionFactory factory) {
    }
    
    public Award(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Award(Integer id, String awardName) {
        this.id = id;
        this.awardName = awardName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Award)) {
            return false;
        }
        Award other = (Award) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Award[ id=" + id + " ]";
    }

}
