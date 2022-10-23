/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id"),
    @NamedQuery(name = "Route.findByRoutename", query = "SELECT r FROM Route r WHERE r.routename = :routename"),
    @NamedQuery(name = "Route.findByStartingpoint", query = "SELECT r FROM Route r WHERE r.startingpoint = :startingpoint"),
    @NamedQuery(name = "Route.findByDestination", query = "SELECT r FROM Route r WHERE r.destination = :destination"),
    @NamedQuery(name = "Route.findByPrice", query = "SELECT r FROM Route r WHERE r.price = :price"),
    @NamedQuery(name = "Route.findBySpecialprice", query = "SELECT r FROM Route r WHERE r.specialprice = :specialprice"),
    @NamedQuery(name = "Route.findByImage", query = "SELECT r FROM Route r WHERE r.image = :image")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20, message = "{route.routename.notNullMsg}")
    @Column(name = "routename")
    private String routename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20, message = "{route.startingpoint.notNullMsg}")
    @Column(name = "startingpoint")
    private String startingpoint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20, message = "{route.destination.notNullMsg}")
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @NotNull(message = "{route.price.notNullMsg}")
    @Column(name = "price")
    private long price;
    @Column(name = "specialprice")
    private Float specialprice;
    @Size(max = 150)
    @Column(name = "image")
    private String image;
    @Column(name = "stretch")
    private String stretch;
    @Column(name = "time")
   
    private int time;
//    @OneToMany(mappedBy = "routeId")
//    private Set<Trip> tripSet;
    @OneToMany(mappedBy = "routeId", fetch = FetchType.LAZY)
    private List<Trip> trips;
    
    @Transient
    private MultipartFile file;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Route(Integer id, String routename, String startingpoint, String destination, long price) {
        this.id = id;
        this.routename = routename;
        this.startingpoint = startingpoint;
        this.destination = destination;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getStartingpoint() {
        return startingpoint;
    }

    public void setStartingpoint(String startingpoint) {
        this.startingpoint = startingpoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    @XmlTransient
//    public Set<Trip> getTripSet() {
//        return tripSet;
//    }
//
//    public void setTripSet(Set<Trip> tripSet) {
//        this.tripSet = tripSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldv.pojo.Route[ id=" + id + " ]";
    }

    /**
     * @return the trips
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * @param trips the trips to set
     */
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
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

    /**
     * @return the stretch
     */
    public String getStretch() {
        return stretch;
    }

    /**
     * @param stretch the stretch to set
     */
    public void setStretch(String stretch) {
        this.stretch = stretch;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

   
    public Float getSpecialprice() {
        return specialprice;
    }

    
    public void setSpecialprice(Float specialprice) {
        this.specialprice = specialprice;
    }

    /**
     * @return the time
     */
    

}
