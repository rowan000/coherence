package com.chattech.interviewcompanion.model;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 21/01/2013
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class Answer {

    private int index;
    private String answerText;

    public Answer(int index, String answerText) {
        this.index = index;
        this.answerText = answerText;
    }

    public int getIndex() {
        return index;
    }

    public String getAnswerText() {
        return answerText;
    }
}
