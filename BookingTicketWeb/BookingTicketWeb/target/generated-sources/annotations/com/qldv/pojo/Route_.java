package com.qldv.pojo;

import com.qldv.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> image;
    public static volatile SingularAttribute<Route, String> stretch;
    public static volatile SingularAttribute<Route, String> startingpoint;
    public static volatile SingularAttribute<Route, Long> price;
    public static volatile ListAttribute<Route, Trip> trips;
    public static volatile SingularAttribute<Route, String> destination;
    public static volatile SingularAttribute<Route, Integer> id;
    public static volatile SingularAttribute<Route, Integer> time;
    public static volatile SingularAttribute<Route, String> routename;
    public static volatile SingularAttribute<Route, Float> specialprice;

}