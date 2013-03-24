package com.chattech.interviewcompanion.model;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/01/2013
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class Choice {
    private String choiceTitle;
    private String choiceText;
    private boolean isCorrect;

    public Choice(String choiceTitle, String choiceText, boolean correct) {
        this.choiceTitle = choiceTitle;
        this.choiceText = choiceText;
        isCorrect = correct;
    }

    public String getChoiceTitle() {
        return choiceTitle;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
