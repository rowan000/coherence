package com.chattech.interviewcompanion.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/01/2013
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class Exam {

    private String examTitle;
    private List<Question> questions = new ArrayList();

    public Exam(String examTitle) {
        this.examTitle = examTitle;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getExamTitle() {
        return examTitle;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
