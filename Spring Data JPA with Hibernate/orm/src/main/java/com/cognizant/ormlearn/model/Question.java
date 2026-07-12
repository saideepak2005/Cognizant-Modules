package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "qn_id")
    private Integer questionId;

    @Column(name = "qn_text")
    private String questionText;

    @OneToMany(mappedBy = "question")
    private Set<Option> optionList;

    public Integer getQuestionId() {

        return questionId;

    }

    public void setQuestionId(Integer questionId) {

        this.questionId = questionId;

    }

    public String getQuestionText() {

        return questionText;

    }

    public void setQuestionText(String questionText) {

        this.questionText = questionText;

    }

    public Set<Option> getOptionList() {

        return optionList;

    }

    public void setOptionList(Set<Option> optionList) {

        this.optionList = optionList;

    }

}
