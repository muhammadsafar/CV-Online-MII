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

/**
 * 
 * @author Dayinta Warih Wulandari
 */
@Entity
@Table(name = "FOREIGN_LANGUAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForeignLanguage.findAll", query = "SELECT f FROM ForeignLanguage f")
    , @NamedQuery(name = "ForeignLanguage.findById", query = "SELECT f FROM ForeignLanguage f WHERE f.id = :id")
    , @NamedQuery(name = "ForeignLanguage.findByLanguage", query = "SELECT f FROM ForeignLanguage f WHERE f.language = :language")})
public class ForeignLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LANGUAGE")
    private String language;
    @OneToMany(mappedBy = "languageId")
    private List<LanguageAd> languageAdList;

    public ForeignLanguage() {
    }

    public ForeignLanguage(Integer id) {
        this.id = id;
    }

//    public ForeignLanguage(int parseInt, String fl) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlTransient
    public List<LanguageAd> getLanguageAdList() {
        return languageAdList;
    }

    public void setLanguageAdList(List<LanguageAd> languageAdList) {
        this.languageAdList = languageAdList;
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
        if (!(object instanceof ForeignLanguage)) {
            return false;
        }
        ForeignLanguage other = (ForeignLanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ForeignLanguage[ id=" + id + " ]";
    }

}
