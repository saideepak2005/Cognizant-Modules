package com.cognizant.employeemanagementsystem.repository;

import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.entity.EmployeeDTO;
import com.cognizant.employeemanagementsystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmpName(String empName);

    List<Employee> findByEmpEmailContaining(String empEmail);

    List<Employee> findByEmpNameStartingWith(String prefix);

    @Query("SELECT e FROM Employee e WHERE e.empName = :empName")
    List<Employee> getEmployeesByName(@Param("empName") String empName);

    List<Employee> findByEmpEmail(String empEmail);

    List<EmployeeNameEmailProjection> findBy();

    @Query("SELECT new com.cognizant.employeemanagementsystem.entity.EmployeeDTO(e.empName, e.empEmail) FROM Employee e")
    List<EmployeeDTO> getEmployeeData();

}
