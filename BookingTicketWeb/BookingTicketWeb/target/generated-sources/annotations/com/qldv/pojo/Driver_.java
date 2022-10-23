package com.qldv.pojo;

import com.qldv.pojo.Driverdetail;
import com.qldv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, Date> dateofbirth;
    public static volatile SingularAttribute<Driver, String> license;
    public static volatile SingularAttribute<Driver, String> address;
    public static volatile SetAttribute<Driver, Driverdetail> driverdetailSet;
    public static volatile SingularAttribute<Driver, Integer> userIdDriver;
    public static volatile SingularAttribute<Driver, String> identitycard;
    public static volatile SingularAttribute<Driver, User> user;

}