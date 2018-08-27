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
@Table(name = "LANGUAGE_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LanguageAd.findAll", query = "SELECT l FROM LanguageAd l")
    , @NamedQuery(name = "LanguageAd.findById", query = "SELECT l FROM LanguageAd l WHERE l.id = :id")})
public class LanguageAd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AD_ID", referencedColumnName = "NIK")
    @ManyToOne
    private AppDev adId;
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "ID")
    @ManyToOne
    private ForeignLanguage languageId;

    public LanguageAd() {
    }

    public LanguageAd(Integer id) {
        this.id = id;
    }

    public LanguageAd(Integer id, AppDev adId, ForeignLanguage languageId) {
        this.id = id;
        this.adId = adId;
        this.languageId = languageId;
    }

    public LanguageAd(SessionFactory factory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public ForeignLanguage getLanguageId() {
        return languageId;
    }

    public void setLanguageId(ForeignLanguage languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof LanguageAd)) {
            return false;
        }
        LanguageAd other = (LanguageAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LanguageAd[ id=" + id + " ]";
    }

}
