package com.cognizant.employeemanagementsystem.service;

import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Transactional(readOnly = true)
    public List<Employee> getAll() {

        return employeeRepository.findAll();

    }

    @Transactional(readOnly = true)
    public Employee get(Long empId) {

        return employeeRepository.findById(empId).orElse(null);

    }

    @Transactional
    public void delete(Long empId) {

        employeeRepository.deleteById(empId);

    }

    @Transactional(readOnly = true)
    public Page<Employee> getEmployees(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("empName"));
        return employeeRepository.findAll(pageable);

    }

}
