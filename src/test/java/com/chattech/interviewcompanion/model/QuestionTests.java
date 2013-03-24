package com.chattech.interviewcompanion.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 16/01/2013
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class QuestionTests {

    @Test
    public void questionHasQuestionText(){
        QuestionBuilder builder = new QuestionBuilder().questionText("What is the numerical range of a char?");
        builder = builder.addChoice("A", "-128 to 127", false);
        builder = builder.addChoice("B", "-(215) to (215) - 1", false);
        builder = builder.addChoice("C", "0 to 32767", false);
        builder = builder.addChoice("D", "0 to 65535", true);
        Question question = builder.buildQuestion();

        assertEquals("What is the numerical range of a char?", question.getQuestionText());
    }

    @Test
    public void questionMakeUpExam(){

        QuestionBuilder builder = new QuestionBuilder().questionText("What is the numerical range of a short?");
        builder = builder.addChoice("A", "-128 to 127", false);
        builder = builder.addChoice("B", "-(215) to (215) - 1", true);
        builder = builder.addAnswer(1, "Because it is");
        Question question = builder.buildQuestion();


        assertEquals("What is the numerical range of a short?", question.getQuestionText());
        assertEquals(1, question.getAnswers().size());
        assertEquals(1, question.getAnswers().get(0).getIndex());

        Exam javaLanguageExam = new Exam("Java Language Exam");
        javaLanguageExam.addQuestion(question);

        assertEquals("Java Language Exam", javaLanguageExam.getExamTitle());
        assertEquals(1, javaLanguageExam.getQuestions().size());


    }

    //Questions can be persisted
    //exams can be persisted
    //create rest service to retreive exam and questions
    //getExams
    //getExam
    //getQuestionForExam
    //create angular js client to uses the rest api
    //gui should be able to add questions to exam
    //gui should be able to ask questions from exam
    //gui should be able to keep track of score
    //gui should be able to provide stats upon completion
}
