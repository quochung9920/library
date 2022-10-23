/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.qldv.pojo.Employee;
import com.qldv.repository.EmployeeRepository;
import com.qldv.service.EmployeeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(Map<String, String> params, int start, int limit) {
        return this.employeeRepository.getEmployees(params, start, limit);
    }

    @Override
    public List<Employee> getListNav(int start, int limit) {
        return this.employeeRepository.getListNav(start, limit);
    }

    @Override
    public boolean addEmployee(Employee e) {
        return this.employeeRepository.addEmployee(e);
    }

    @Override
    public boolean editEmployee(Employee e) {
        return this.employeeRepository.editEmployee(e);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public int totalItem() {
        return this.employeeRepository.totalItem();
    }

    @Override
    public Employee findById(int employeeId) {
        return this.employeeRepository.findById(employeeId);
    }

    @Override
    public Employee addE(Employee employee) {
        return this.employeeRepository.addE(employee);
    }

}
