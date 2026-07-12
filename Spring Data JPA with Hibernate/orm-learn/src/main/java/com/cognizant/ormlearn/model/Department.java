package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dp_id")
    private Integer deptId;

    @Column(name = "dp_name")
    private String deptName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employeeList;

    public Department() {

    }

    public Department(Integer deptId, String deptName) {

        this.deptId = deptId;
        this.deptName = deptName;

    }

    public Integer getDeptId() {

        return deptId;

    }

    public void setDeptId(Integer deptId) {

        this.deptId = deptId;

    }

    public String getDeptName() {

        return deptName;

    }

    public void setDeptName(String deptName) {

        this.deptName = deptName;

    }

    public Set<Employee> getEmployeeList() {

        return employeeList;

    }

    public void setEmployeeList(Set<Employee> employeeList) {

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
