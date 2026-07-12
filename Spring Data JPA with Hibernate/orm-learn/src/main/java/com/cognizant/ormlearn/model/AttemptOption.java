package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @Column(name = "ao_id")
    private Integer attemptOptionId;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Option option;

    public Integer getAttemptOptionId() {

        return attemptOptionId;

    }

    public void setAttemptOptionId(Integer attemptOptionId) {

        this.attemptOptionId = attemptOptionId;

    }

    public AttemptQuestion getAttemptQuestion() {

        return attemptQuestion;

    }

    public void setAttemptQuestion(AttemptQuestion attemptQuestion) {

        this.attemptQuestion = attemptQuestion;

    }

    public Option getOption() {

        return option;

    }

    public void setOption(Option option) {

        this.option = option;

    }

}
