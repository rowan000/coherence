package com.chattech.memory;


public class NumberTranslation {

    private int number;
    private char[] charactors = new char[1];
    private String person;
    private String action;

    public NumberTranslation(int number, char[] charactors, String person, String action) {
        this.number = number;
        this.charactors = charactors;
        this.person = person;
        this.action = action;
    }

    public String getCharactors() {
        return String.valueOf(charactors);
    }

    public String getPerson() {
        return person;
    }

    public String getAction() {
        return action;
    }

    public int getNumber() {
        return number;
    }
}
