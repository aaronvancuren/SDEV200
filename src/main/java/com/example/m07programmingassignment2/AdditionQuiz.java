package com.example.m07programmingassignment2;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AdditionQuiz
{
    public Set<String> questions = new HashSet<>();
    public Map<String, Integer> answers = new LinkedHashMap<>();

    public AdditionQuiz() {}

    public String getQuestion()
    {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        String question = num1 + " + " + num2 + " = ";
        questions.add(question);
        answers.put(question, num1 + num2);
        return question;
    }

    public int getAnswer(String question)
    {
        return answers.get(question);
    }
}
