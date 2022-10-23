package com.qldv.pojo;

import com.qldv.pojo.Comment;
import com.qldv.pojo.Driver;
import com.qldv.pojo.Employee;
import com.qldv.pojo.Ticketdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-10-14T09:29:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, String> userrole;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Employee> employee;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Ticketdetail> ticketdetailSet;
    public static volatile SingularAttribute<User, Driver> driver;
    public static volatile SetAttribute<User, Comment> commentSet;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}