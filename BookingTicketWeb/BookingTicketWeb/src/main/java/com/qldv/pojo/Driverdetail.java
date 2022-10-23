/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "driverdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driverdetail.findAll", query = "SELECT d FROM Driverdetail d"),
    @NamedQuery(name = "Driverdetail.findById", query = "SELECT d FROM Driverdetail d WHERE d.id = :id"),
    @NamedQuery(name = "Driverdetail.findByDriverrole", query = "SELECT d FROM Driverdetail d WHERE d.driverrole = :driverrole")})
public class Driverdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "driverrole")
    private String driverrole;
    @JoinColumn(name = "user_id_driver", referencedColumnName = "user_id_driver")
    @ManyToOne(optional = false)
    private Driver userIdDriver;
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trip tripId;

    public Driverdetail() {
    }

    public Driverdetail(Integer id) {
        this.id = id;
    }

    public Driverdetail(Integer id, String driverrole) {
        this.id = id;
        this.driverrole = driverrole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverrole() {
        return driverrole;
    }

    public void setDriverrole(String driverrole) {
        this.driverrole = driverrole;
    }

    public Driver getUserIdDriver() {
        return userIdDriver;
    }

    public void setUserIdDriver(Driver userIdDriver) {
        this.userIdDriver = userIdDriver;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
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
        if (!(object instanceof Driverdetail)) {
            return false;
        }
        Driverdetail other = (Driverdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Driverdetail[ id=" + id + " ]";
    }
    
}
