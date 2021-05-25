package com.abhishek.employeeManager.services;

import com.abhishek.employeeManager.exceptions.UserNotFoundException;
import com.abhishek.employeeManager.models.Employee;
import com.abhishek.employeeManager.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepo employeeRepo;

    /*
    Autowiring by constructor
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /*
    Adding the employee
     */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    /*
    getting the list of employee
     */
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    /*
    updating the employee
     */
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    /*
    finding the employee based on employee id
     */
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    /*
    deleting the employee
     */
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
