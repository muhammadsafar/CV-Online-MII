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
@Table(name = "ORGANIZATION_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationAd.findAll", query = "SELECT o FROM OrganizationAd o")
    , @NamedQuery(name = "OrganizationAd.findById", query = "SELECT o FROM OrganizationAd o WHERE o.id = :id")})
public class OrganizationAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organization organizationId;

    public OrganizationAd() {
    }

    public OrganizationAd(SessionFactory factory) {
    }
    
    public OrganizationAd(Integer id) {
        this.id = id;
    }

    public OrganizationAd(Integer id, AppDev adId, Organization organizationId) {
        this.id = id;
        this.adId = adId;
        this.organizationId = organizationId;
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

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
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
        if (!(object instanceof OrganizationAd)) {
            return false;
        }
        OrganizationAd other = (OrganizationAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrganizationAd[ id=" + id + " ]";
    }

}
