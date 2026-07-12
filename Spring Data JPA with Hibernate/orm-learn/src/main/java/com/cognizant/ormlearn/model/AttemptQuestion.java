package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @Column(name = "aq_id")
    private Integer attemptQuestionId;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qn_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    private Set<AttemptOption> attemptOptionList;

    public Integer getAttemptQuestionId() {

        return attemptQuestionId;

    }

    public void setAttemptQuestionId(Integer attemptQuestionId) {

        this.attemptQuestionId = attemptQuestionId;

    }

    public Attempt getAttempt() {

        return attempt;

    }

    public void setAttempt(Attempt attempt) {

        this.attempt = attempt;

    }

    public Question getQuestion() {

        return question;

    }

    public void setQuestion(Question question) {

        this.question = question;

    }

    public Set<AttemptOption> getAttemptOptionList() {

        return attemptOptionList;

    }

    public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {

        this.attemptOptionList = attemptOptionList;

    }

}
