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
@Table(name = "AD_SITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSite.findAll", query = "SELECT a FROM AdSite a")
    , @NamedQuery(name = "AdSite.findById", query = "SELECT a FROM AdSite a WHERE a.id = :id")
    , @NamedQuery(name = "AdSite.findByReview", query = "SELECT a FROM AdSite a WHERE a.review = :review")
    , @NamedQuery(name = "AdSite.findByStatus", query = "SELECT a FROM AdSite a WHERE a.status = :status")})
public class AdSite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "REVIEW")
    private String review;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne(optional = false)
    private AppDev adId;
    @JoinColumn(name = "SITE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Site siteId;

    public AdSite() {
    }

    public AdSite(SessionFactory factory) {
    }
    
    public AdSite(Integer id) {
        this.id = id;
    }

    public AdSite(Integer id, String review, Integer status, AppDev adId, Site siteId) {
        this.id = id;
        this.review = review;
        this.status = status;
        this.adId = adId;
        this.siteId = siteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AppDev getAdId() {
        return adId;
    }

    public void setAdId(AppDev adId) {
        this.adId = adId;
    }

    public Site getSiteId() {
        return siteId;
    }

    public void setSiteId(Site siteId) {
        this.siteId = siteId;
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
        if (!(object instanceof AdSite)) {
            return false;
        }
        AdSite other = (AdSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdSite[ id=" + id + " ]";
    }

}
