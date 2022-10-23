/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "passengercar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passengercar.findAll", query = "SELECT p FROM Passengercar p"),
    @NamedQuery(name = "Passengercar.findById", query = "SELECT p FROM Passengercar p WHERE p.id = :id"),
    @NamedQuery(name = "Passengercar.findByName", query = "SELECT p FROM Passengercar p WHERE p.name = :name"),
    @NamedQuery(name = "Passengercar.findByNumberplate", query = "SELECT p FROM Passengercar p WHERE p.numberplate = :numberplate"),
    @NamedQuery(name = "Passengercar.findBySeats", query = "SELECT p FROM Passengercar p WHERE p.seats = :seats")})
public class Passengercar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numberplate")
    private String numberplate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seats")
    private int seats;
    @OneToMany(mappedBy = "passengercarId", fetch = FetchType.EAGER)
    private Set<Trip> tripSet;
    @OneToMany(mappedBy = "passengercarId")
    private Set<Ticketdetail> ticketdetailSet;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;

    public Passengercar() {
    }

    public Passengercar(Integer id) {
        this.id = id;
    }

    public Passengercar(Integer id, String name, String numberplate, int seats) {
        this.id = id;
        this.name = name;
        this.numberplate = numberplate;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @XmlTransient
    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    @XmlTransient
    public Set<Ticketdetail> getTicketdetailSet() {
        return ticketdetailSet;
    }

    public void setTicketdetailSet(Set<Ticketdetail> ticketdetailSet) {
        this.ticketdetailSet = ticketdetailSet;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Passengercar)) {
            return false;
        }
        Passengercar other = (Passengercar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Passengercar[ id=" + id + " ]";
    }
    
}
