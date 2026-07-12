package com.cognizant.employeemanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name")
    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    public Department() {

    }

    public Department(Long deptId, String deptName) {

        this.deptId = deptId;
        this.deptName = deptName;

    }

    public Long getDeptId() {

        return deptId;

    }

    public void setDeptId(Long deptId) {

        this.deptId = deptId;

    }

    public String getDeptName() {

        return deptName;

    }

    public void setDeptName(String deptName) {

        this.deptName = deptName;

    }

    public List<Employee> getEmployeeList() {

        return employeeList;

    }

    public void setEmployeeList(List<Employee> employeeList) {

        this.employeeList = employeeList;

    }

    @Override
    public String toString() {

        return "Department{" +
                "id=" + deptId +
                ", name='" + deptName + '\'' +
                '}';

    }

}
