package com.qldv.pojo;

import com.qldv.pojo.Category;
import com.qldv.pojo.Ticketdetail;
import com.qldv.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Passengercar.class)
public class Passengercar_ { 

    public static volatile SetAttribute<Passengercar, Ticketdetail> ticketdetailSet;
    public static volatile SingularAttribute<Passengercar, String> name;
    public static volatile SetAttribute<Passengercar, Trip> tripSet;
    public static volatile SingularAttribute<Passengercar, Integer> id;
    public static volatile SingularAttribute<Passengercar, String> numberplate;
    public static volatile SingularAttribute<Passengercar, Integer> seats;
    public static volatile SingularAttribute<Passengercar, Category> categoryId;

}