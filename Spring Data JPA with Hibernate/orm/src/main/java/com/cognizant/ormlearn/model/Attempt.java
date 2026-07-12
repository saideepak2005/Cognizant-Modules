package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @Column(name = "at_id")
    private Integer attemptId;

    @Column(name = "at_date")
    private Date attemptDate;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> questionList;

    public Integer getAttemptId() {

        return attemptId;

    }

    public void setAttemptId(Integer attemptId) {

        this.attemptId = attemptId;

    }

    public Date getAttemptDate() {

        return attemptDate;

    }

    public void setAttemptDate(Date attemptDate) {

        this.attemptDate = attemptDate;

    }

    public User getUser() {

        return user;

    }

    public void setUser(User user) {

        this.user = user;

    }

    public Set<AttemptQuestion> getQuestionList() {

        return questionList;

    }

    public void setQuestionList(Set<AttemptQuestion> questionList) {

        this.questionList = questionList;

    }

}
