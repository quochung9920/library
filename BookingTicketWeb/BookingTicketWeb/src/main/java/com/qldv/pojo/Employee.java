/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByUserIdEmployee", query = "SELECT e FROM Employee e WHERE e.userIdEmployee = :userIdEmployee"),
    @NamedQuery(name = "Employee.findByIdentitycard", query = "SELECT e FROM Employee e WHERE e.identitycard = :identitycard"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByDateofbirth", query = "SELECT e FROM Employee e WHERE e.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id_employee")
    private Integer userIdEmployee;
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
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "userIdEmployee", fetch = FetchType.EAGER)
    private Set<Trip> tripSet;
    @JoinColumn(name = "user_id_employee", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne( optional = false)
    private User user;

    public Employee() {
    }

    public Employee(Integer userIdEmployee) {
        this.userIdEmployee = userIdEmployee;
    }

    public Employee(Integer userIdEmployee, String identitycard, String address, Date dateofbirth, String gender) {
        this.userIdEmployee = userIdEmployee;
        this.identitycard = identitycard;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }

    public Integer getUserIdEmployee() {
        return userIdEmployee;
    }

    public void setUserIdEmployee(Integer userIdEmployee) {
        this.userIdEmployee = userIdEmployee;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlTransient
    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIdEmployee != null ? userIdEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.userIdEmployee == null && other.userIdEmployee != null) || (this.userIdEmployee != null && !this.userIdEmployee.equals(other.userIdEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Employee[ userIdEmployee=" + userIdEmployee + " ]";
    }
    
}
