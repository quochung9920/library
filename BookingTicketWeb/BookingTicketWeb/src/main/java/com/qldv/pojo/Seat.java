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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "seat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
    @NamedQuery(name = "Seat.findById", query = "SELECT s FROM Seat s WHERE s.id = :id"),
    @NamedQuery(name = "Seat.findByName", query = "SELECT s FROM Seat s WHERE s.name = :name"),
    @NamedQuery(name = "Seat.findBySeatrow", query = "SELECT s FROM Seat s WHERE s.seatrow = :seatrow")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "seatrow")
    private String seatrow;
    @OneToMany(mappedBy = "seatId")
    private Set<Ticketdetail> ticketdetailSet;

    @Transient
    private Integer active;

    @Transient
    private Integer quantity;
    
    @Transient
    private Integer pasCarId;
    
    @Transient
    private Integer tripId;
    
    @Transient
    private Long price;

    public Seat() {
    }

    public Seat(Integer id) {
        this.id = id;
    }

    public Seat(Integer id, String name, String seatrow) {
        this.id = id;
        this.name = name;
        this.seatrow = seatrow;
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

    public String getSeatrow() {
        return seatrow;
    }

    public void setSeatrow(String seatrow) {
        this.seatrow = seatrow;
    }

    @XmlTransient
    public Set<Ticketdetail> getTicketdetailSet() {
        return ticketdetailSet;
    }

    public void setTicketdetailSet(Set<Ticketdetail> ticketdetailSet) {
        this.ticketdetailSet = ticketdetailSet;
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
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Seat[ id=" + id + " ]";
    }

    /**
     * @return the active
     */
    public Integer getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the pasCarId
     */
    public Integer getPasCarId() {
        return pasCarId;
    }

    /**
     * @param pasCarId the pasCarId to set
     */
    public void setPasCarId(Integer pasCarId) {
        this.pasCarId = pasCarId;
    }

    /**
     * @return the tripId
     */
    public Integer getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

}
