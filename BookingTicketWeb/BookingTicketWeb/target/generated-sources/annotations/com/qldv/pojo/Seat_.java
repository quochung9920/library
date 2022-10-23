package com.qldv.pojo;

import com.qldv.pojo.Ticketdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile SetAttribute<Seat, Ticketdetail> ticketdetailSet;
    public static volatile SingularAttribute<Seat, String> seatrow;
    public static volatile SingularAttribute<Seat, String> name;
    public static volatile SingularAttribute<Seat, Integer> id;

}