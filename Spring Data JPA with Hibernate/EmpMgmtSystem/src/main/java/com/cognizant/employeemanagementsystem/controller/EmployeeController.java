package com.cognizant.employeemanagementsystem.controller;

import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);

    }

    @GetMapping
    public List<Employee> getEmployees() {

        return employeeService.getAll();

    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable Long empId) {

        return employeeService.get(empId);

    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable Long empId, @RequestBody Employee employee) {

        employee.setEmpId(empId);
        return employeeService.save(employee);

    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable Long empId) {

        employeeService.delete(empId);

    }

    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(@RequestParam int page, @RequestParam int size) {

        return employeeService.getEmployees(page, size);

    }

}
