package com.examm.service;

import com.examm.entities.Employee;
import com.examm.entities.EmployeeProject;
import com.examm.repository.EmployeeRepository;
import com.examm.repository.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void assignProject(EmployeeProject employeeProject) {
        employeeProjectRepository.save(employeeProject);
    }
}
