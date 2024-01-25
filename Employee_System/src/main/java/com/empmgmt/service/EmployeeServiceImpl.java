package com.empmgmt.service;

import com.empmgmt.entity.Employee;
import com.empmgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmp(Employee employee) {
        Employee newEmp = employeeRepository.save(employee);
        return newEmp;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public boolean deleteEmp(int id) {
        Employee employee = employeeRepository.findById(id).get();
        if(employee != null){
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }
}
