/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service;

import com.qldv.pojo.Employee;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface EmployeeService {

    List<Employee> getEmployees(Map<String, String> params, int start, int limit);

    List<Employee> getListNav(int start, int limit);

    boolean addEmployee(Employee e);

    boolean editEmployee(Employee e);

    boolean deleteEmployee(int id);

    int totalItem();

    Employee findById(int employeeId);

    Employee addE(Employee employee);
}
