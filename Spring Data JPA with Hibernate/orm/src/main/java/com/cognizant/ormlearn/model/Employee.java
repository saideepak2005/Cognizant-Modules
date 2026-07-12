package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private Integer empId;

    @Column(name = "em_name")
    private String empName;

    @Column(name = "em_salary")
    private Double empSalary;

    @Column(name = "em_permanent")
    private Boolean empPermanent;

    @Column(name = "em_date_of_birth")
    private Date empDateOfBirth;

    @ManyToOne
    @JoinColumn(name = "em_dp_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private Set<Skill> skillList;

    public Employee() {

    }

    public Employee(Integer empId, String empName, Double empSalary, Boolean empPermanent, Date empDateOfBirth) {

        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empPermanent = empPermanent;
        this.empDateOfBirth = empDateOfBirth;

    }

    public Integer getEmpId() {

        return empId;

    }

    public void setEmpId(Integer empId) {

        this.empId = empId;

    }

    public String getEmpName() {

        return empName;

    }

    public void setEmpName(String empName) {

        this.empName = empName;

    }

    public Double getEmpSalary() {

        return empSalary;

    }

    public void setEmpSalary(Double empSalary) {

        this.empSalary = empSalary;

    }

    public Boolean getEmpPermanent() {

        return empPermanent;

    }

    public void setEmpPermanent(Boolean empPermanent) {

        this.empPermanent = empPermanent;

    }

    public Date getEmpDateOfBirth() {

        return empDateOfBirth;

    }

    public void setEmpDateOfBirth(Date empDateOfBirth) {

        this.empDateOfBirth = empDateOfBirth;

    }

    public Department getDepartment() {

        return department;

    }

    public void setDepartment(Department department) {

        this.department = department;

    }

    public Set<Skill> getSkillList() {

        return skillList;

    }

    public void setSkillList(Set<Skill> skillList) {

        this.skillList = skillList;

    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + empId +
                ", name='" + empName + '\'' +
                ", salary=" + empSalary +
                ", permanent=" + empPermanent +
                ", dateOfBirth=" + empDateOfBirth +
                '}';

    }

}
