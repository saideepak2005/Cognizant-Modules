package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private Integer skillId;

    @Column(name = "sk_name")
    private String skillName;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    public Skill() {

    }

    public Skill(Integer skillId, String skillName) {

        this.skillId = skillId;
        this.skillName = skillName;

    }

    public Integer getSkillId() {

        return skillId;

    }

    public void setSkillId(Integer skillId) {

        this.skillId = skillId;

    }

    public String getSkillName() {

        return skillName;

    }

    public void setSkillName(String skillName) {

        this.skillName = skillName;

    }

    public Set<Employee> getEmployeeList() {

        return employeeList;

    }

    public void setEmployeeList(Set<Employee> employeeList) {

        this.employeeList = employeeList;

    }

    @Override
    public String toString() {

        return "Skill{" +
                "id=" + skillId +
                ", name='" + skillName + '\'' +
                '}';

    }

}
