package com.cognizant.employeemanagementsystem.entity;

public class EmployeeDTO {

    private String empName;

    private String empEmail;

    public EmployeeDTO() {

    }

    public EmployeeDTO(String empName, String empEmail) {

        this.empName = empName;
        this.empEmail = empEmail;

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

    @Override
    public String toString() {

        return "EmployeeDTO{" +
                "name='" + empName + '\'' +
                ", email='" + empEmail + '\'' +
                '}';

    }

}
