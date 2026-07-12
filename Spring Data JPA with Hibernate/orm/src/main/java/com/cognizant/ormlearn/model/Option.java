package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @Column(name = "op_id")
    private Integer optionId;

    @Column(name = "op_text")
    private String optionText;

    @Column(name = "op_score")
    private Double optionScore;

    @ManyToOne
    @JoinColumn(name = "op_qn_id")
    private Question question;

    public Integer getOptionId() {

        return optionId;

    }

    public void setOptionId(Integer optionId) {

        this.optionId = optionId;

    }

    public String getOptionText() {

        return optionText;

    }

    public void setOptionText(String optionText) {

        this.optionText = optionText;

    }

    public Double getOptionScore() {

        return optionScore;

    }

    public void setOptionScore(Double optionScore) {

        this.optionScore = optionScore;

    }

    public Question getQuestion() {

        return question;

    }

    public void setQuestion(Question question) {

        this.question = question;

    }

}
