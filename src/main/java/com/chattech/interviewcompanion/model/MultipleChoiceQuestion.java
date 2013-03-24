package com.chattech.interviewcompanion.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/01/2013
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class MultipleChoiceQuestion implements Question {

    private String questionText;
    private List<Choice> choices;
    private List<Answer> answers;

    public MultipleChoiceQuestion(String questionText, List<Choice> choices, List<Answer> answers) {
        this.questionText = questionText;
        this.choices = choices;
        this.answers = answers;

    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<Answer> getAnswers() {
        return answers;
    }
}
