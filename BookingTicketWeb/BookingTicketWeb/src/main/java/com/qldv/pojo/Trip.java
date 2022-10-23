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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findById", query = "SELECT t FROM Trip t WHERE t.id = :id"),
    @NamedQuery(name = "Trip.findByCoachname", query = "SELECT t FROM Trip t WHERE t.coachname = :coachname"),
    @NamedQuery(name = "Trip.findByDepartureday", query = "SELECT t FROM Trip t WHERE t.departureday = :departureday"),
    @NamedQuery(name = "Trip.findByDeparturetime", query = "SELECT t FROM Trip t WHERE t.departuretime = :departuretime"),
    @NamedQuery(name = "Trip.findByArrivaltime", query = "SELECT t FROM Trip t WHERE t.arrivaltime = :arrivaltime"),
    @NamedQuery(name = "Trip.findByImage", query = "SELECT t FROM Trip t WHERE t.image = :image"),
    @NamedQuery(name = "Trip.findByActive", query = "SELECT t FROM Trip t WHERE t.active = :active")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "coachname")
    private String coachname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departureday")
    @Temporal(TemporalType.DATE)
    private Date departureday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departuretime")
    @Temporal(TemporalType.TIME)
    private Date departuretime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arrivaltime")
    @Temporal(TemporalType.TIME)
    private Date arrivaltime;
    @Size(max = 150)
    @Column(name = "image")
    private String image;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "user_id_employee", referencedColumnName = "user_id_employee")
    @ManyToOne
    private Employee userIdEmployee;
    @JoinColumn(name = "passengercar_id", referencedColumnName = "id")
    @ManyToOne
    private Passengercar passengercarId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    private Route routeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    private Set<Driverdetail> driverdetailSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId", fetch = FetchType.EAGER)
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    private Set<Ticketdetail> ticketdetailSet;
    
    @Transient
    private MultipartFile file;

    public Trip() {
    }

    public Trip(Integer id) {
        this.id = id;
    }

    public Trip(Integer id, String coachname, Date departureday, Date departuretime, Date arrivaltime) {
        this.id = id;
        this.coachname = coachname;
        this.departureday = departureday;
        this.departuretime = departuretime;
        this.arrivaltime = arrivaltime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        this.coachname = coachname;
    }

    public Date getDepartureday() {
        return departureday;
    }

    public void setDepartureday(Date departureday) {
        this.departureday = departureday;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Employee getUserIdEmployee() {
        return userIdEmployee;
    }

    public void setUserIdEmployee(Employee userIdEmployee) {
        this.userIdEmployee = userIdEmployee;
    }

    public Passengercar getPassengercarId() {
        return passengercarId;
    }

    public void setPassengercarId(Passengercar passengercarId) {
        this.passengercarId = passengercarId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    @XmlTransient
    public Set<Driverdetail> getDriverdetailSet() {
        return driverdetailSet;
    }

    public void setDriverdetailSet(Set<Driverdetail> driverdetailSet) {
        this.driverdetailSet = driverdetailSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Trip[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
