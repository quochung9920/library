/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByUserIdDriver", query = "SELECT d FROM Driver d WHERE d.userIdDriver = :userIdDriver"),
    @NamedQuery(name = "Driver.findByIdentitycard", query = "SELECT d FROM Driver d WHERE d.identitycard = :identitycard"),
    @NamedQuery(name = "Driver.findByAddress", query = "SELECT d FROM Driver d WHERE d.address = :address"),
    @NamedQuery(name = "Driver.findByDateofbirth", query = "SELECT d FROM Driver d WHERE d.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Driver.findByLicense", query = "SELECT d FROM Driver d WHERE d.license = :license")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id_driver")
    private Integer userIdDriver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identitycard")
    private String identitycard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "license")
    private String license;
    @JoinColumn(name = "user_id_driver", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    @OneToOne(optional = false)
    private User user;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdDriver")
    private Set<Driverdetail> driverdetailSet;

    public Driver() {
    }

    public Driver(Integer userIdDriver) {
        this.userIdDriver = userIdDriver;
    }

    public Driver(Integer userIdDriver, String identitycard, String address, Date dateofbirth, String license) {
        this.userIdDriver = userIdDriver;
        this.identitycard = identitycard;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.license = license;
    }

    public Integer getUserIdDriver() {
        return userIdDriver;
    }

    public void setUserIdDriver(Integer userIdDriver) {
        this.userIdDriver = userIdDriver;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Set<Driverdetail> getDriverdetailSet() {
        return driverdetailSet;
    }

    public void setDriverdetailSet(Set<Driverdetail> driverdetailSet) {
        this.driverdetailSet = driverdetailSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIdDriver != null ? userIdDriver.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.userIdDriver == null && other.userIdDriver != null) || (this.userIdDriver != null && !this.userIdDriver.equals(other.userIdDriver))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Driver[ userIdDriver=" + userIdDriver + " ]";
    }
    
}
