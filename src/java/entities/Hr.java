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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MUHAMMAD BIN ZANDRA
 */
@Entity
@Table(name = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hr.findAll", query = "SELECT h FROM Hr h")
    , @NamedQuery(name = "Hr.findByNik", query = "SELECT h FROM Hr h WHERE h.nik = :nik")
    , @NamedQuery(name = "Hr.findByNama", query = "SELECT h FROM Hr h WHERE h.nama = :nama")
    , @NamedQuery(name = "Hr.findByUsername", query = "SELECT h FROM Hr h WHERE h.username = :username")
    , @NamedQuery(name = "Hr.findByPassword", query = "SELECT h FROM Hr h WHERE h.password = :password")})
public class Hr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "NAMA")
    private String nama;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role roleId;

    public Hr() {
    }

    public Hr(String nik, String nama, String username, String password, Role roleId) {
        this.nik = nik;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }
    
    

    public Hr(String nik) {
        this.nik = nik;
    }

    public Hr(String nik, String nama, String username, String password) {
        this.nik = nik;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hr)) {
            return false;
        }
        Hr other = (Hr) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hr[ nik=" + nik + " ]";
    }
    
}
