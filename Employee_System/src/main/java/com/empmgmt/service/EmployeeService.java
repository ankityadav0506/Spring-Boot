package com.empmgmt.service;

import com.empmgmt.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmp(Employee employee);

    public List<Employee> getAllEmp();

    public Employee getEmpById(int id);
    public boolean deleteEmp(int id);
}