package com.qldv.pojo;

import com.qldv.pojo.Comment;
import com.qldv.pojo.Driverdetail;
import com.qldv.pojo.Employee;
import com.qldv.pojo.Passengercar;
import com.qldv.pojo.Route;
import com.qldv.pojo.Ticketdetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, String> image;
    public static volatile SingularAttribute<Trip, Employee> userIdEmployee;
    public static volatile SetAttribute<Trip, Driverdetail> driverdetailSet;
    public static volatile SingularAttribute<Trip, Passengercar> passengercarId;
    public static volatile SingularAttribute<Trip, Boolean> active;
    public static volatile SingularAttribute<Trip, Date> departureday;
    public static volatile SingularAttribute<Trip, Date> departuretime;
    public static volatile SingularAttribute<Trip, Route> routeId;
    public static volatile SetAttribute<Trip, Ticketdetail> ticketdetailSet;
    public static volatile SetAttribute<Trip, Comment> commentSet;
    public static volatile SingularAttribute<Trip, String> coachname;
    public static volatile SingularAttribute<Trip, Date> arrivaltime;
    public static volatile SingularAttribute<Trip, Integer> id;

}