package com.chattech.interviewcompanion.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/01/2013
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class QuestionBuilder {


    private String questionText;
    private List<Choice> choices = new ArrayList<Choice>();
    private List<Answer> answers = new ArrayList<Answer>();
    public QuestionBuilder questionText(String questionText) {
        this.questionText = questionText;
        return this;
    }

    public QuestionBuilder addChoice(String title, String choiceText, boolean isCorrect) {
        choices.add(new Choice(title, choiceText, isCorrect));
        return this;
    }

    public QuestionBuilder addAnswer(int answerIndex, String text){
        answers.add(new Answer(answerIndex, text));
        return this;
    }

    public Question buildQuestion() {
        return new MultipleChoiceQuestion(questionText, choices, answers);
    }
}
