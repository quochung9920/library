package com.qldv.pojo;

import com.qldv.pojo.Driver;
import com.qldv.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Driverdetail.class)
public class Driverdetail_ { 

    public static volatile SingularAttribute<Driverdetail, String> driverrole;
    public static volatile SingularAttribute<Driverdetail, Driver> userIdDriver;
    public static volatile SingularAttribute<Driverdetail, Trip> tripId;
    public static volatile SingularAttribute<Driverdetail, Integer> id;

}