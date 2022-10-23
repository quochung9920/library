package com.qldv.pojo;

import com.qldv.pojo.Passengercar;
import com.qldv.pojo.Seat;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Ticketdetail.class)
public class Ticketdetail_ { 

    public static volatile SingularAttribute<Ticketdetail, String> note;
    public static volatile SingularAttribute<Ticketdetail, Date> createddate;
    public static volatile SingularAttribute<Ticketdetail, Passengercar> passengercarId;
    public static volatile SingularAttribute<Ticketdetail, Long> totalprice;
    public static volatile SingularAttribute<Ticketdetail, Seat> seatId;
    public static volatile SingularAttribute<Ticketdetail, Trip> tripId;
    public static volatile SingularAttribute<Ticketdetail, Integer> id;
    public static volatile SingularAttribute<Ticketdetail, User> userId;
    public static volatile SingularAttribute<Ticketdetail, String> paymentmethod;

}