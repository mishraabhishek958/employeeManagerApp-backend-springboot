package com.abhishek.employeeManager.services;

import com.abhishek.employeeManager.models.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public List<Employee> findAllEmployees();

    public Employee updateEmployee(Employee employee);

    public Employee findEmployeeById(Long id);

    public void deleteEmployee(Long id);
}
