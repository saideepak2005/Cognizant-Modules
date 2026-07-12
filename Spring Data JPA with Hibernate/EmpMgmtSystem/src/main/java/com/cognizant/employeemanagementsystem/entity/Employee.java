package com.cognizant.employeemanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "employee")
@NamedQuery(name = "Employee.findByEmpEmail",
        query = "SELECT e FROM Employee e WHERE e.empEmail = :empEmail"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_email")
    private String empEmail;

    @ManyToOne
    @JoinColumn(name = "emp_department_id")
    private Department department;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public Employee() {

    }

    public Employee(Long empId, String empName, String empEmail) {

        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;

    }

    public Long getEmpId() {

        return empId;

    }

    public void setEmpId(Long empId) {

        this.empId = empId;

    }

    public String getEmpName() {

        return empName;

    }

    public void setEmpName(String empName) {

        this.empName = empName;

    }

    public String getEmpEmail() {

        return empEmail;

    }

    public void setEmpEmail(String empEmail) {

        this.empEmail = empEmail;

    }

    public Department getDepartment() {

        return department;

    }

    public void setDepartment(Department department) {

        this.department = department;

    }

    public String getCreatedBy() {

        return createdBy;

    }

    public void setCreatedBy(String createdBy) {

        this.createdBy = createdBy;

    }

    public String getModifiedBy() {

        return modifiedBy;

    }

    public void setModifiedBy(String modifiedBy) {

        this.modifiedBy = modifiedBy;

    }

    public LocalDateTime getCreatedDate() {

        return createdDate;

    }

    public void setCreatedDate(LocalDateTime createdDate) {

        this.createdDate = createdDate;

    }

    public LocalDateTime getModifiedDate() {

        return modifiedDate;

    }

    public void setModifiedDate(LocalDateTime modifiedDate) {

        this.modifiedDate = modifiedDate;

    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + empId +
                ", name='" + empName + '\'' +
                ", email='" + empEmail + '\'' +
                '}';

    }

}
