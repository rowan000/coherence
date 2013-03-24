package com.chattech.interviewcompanion.model;

import java.util.List;

/**
 * Represents an interview question
 */
public interface Question {

    String getQuestionText();
    List<Answer> getAnswers();
}
