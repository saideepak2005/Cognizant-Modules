package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee get(int id) {

        return employeeRepository.findById(id).orElse(null);

    }

    @Transactional
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {

        return employeeRepository.getAllPermanentEmployees();

    }

    @Transactional(readOnly = true)
    public Double getAverageSalary(int id) {

        return employeeRepository.getAverageSalary(id);

    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {

        return employeeRepository.getAllEmployeesNative();

    }

}
