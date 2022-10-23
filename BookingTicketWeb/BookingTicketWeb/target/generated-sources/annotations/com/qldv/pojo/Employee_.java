package com.qldv.pojo;

import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Date> dateofbirth;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, Integer> userIdEmployee;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, String> identitycard;
    public static volatile SetAttribute<Employee, Trip> tripSet;
    public static volatile SingularAttribute<Employee, User> user;

}