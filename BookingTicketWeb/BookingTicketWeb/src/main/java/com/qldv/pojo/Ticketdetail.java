/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ticketdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticketdetail.findAll", query = "SELECT t FROM Ticketdetail t"),
    @NamedQuery(name = "Ticketdetail.findById", query = "SELECT t FROM Ticketdetail t WHERE t.id = :id"),
    @NamedQuery(name = "Ticketdetail.findByPaymentmethod", query = "SELECT t FROM Ticketdetail t WHERE t.paymentmethod = :paymentmethod"),
    @NamedQuery(name = "Ticketdetail.findByTotalprice", query = "SELECT t FROM Ticketdetail t WHERE t.totalprice = :totalprice"),
    @NamedQuery(name = "Ticketdetail.findByCreateddate", query = "SELECT t FROM Ticketdetail t WHERE t.createddate = :createddate")})
public class Ticketdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "paymentmethod")
    private String paymentmethod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalprice")
    private long totalprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    
    @Column(name = "note")
    private String note;
    
    @JoinColumn(name = "passengercar_id", referencedColumnName = "id")
    @ManyToOne
    private Passengercar passengercarId;
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    @ManyToOne
    private Seat seatId;
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @ManyToOne
    private Trip tripId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Ticketdetail() {
    }

    public Ticketdetail(Integer id) {
        this.id = id;
    }

    public Ticketdetail(Integer id, String paymentmethod, long totalprice, Date createddate) {
        this.id = id;
        this.paymentmethod = paymentmethod;
        this.totalprice = totalprice;
        this.createddate = createddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(long totalprice) {
        this.totalprice = totalprice;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Passengercar getPassengercarId() {
        return passengercarId;
    }

    public void setPassengercarId(Passengercar passengercarId) {
        this.passengercarId = passengercarId;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Ticketdetail)) {
            return false;
        }
        Ticketdetail other = (Ticketdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Ticketdetail[ id=" + id + " ]";
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
}
