package com.example.m07programmingassignment2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdditionQuizServlet", value = "/AdditionQuizServlet")
public class AdditionQuizServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String questionOne = request.getParameter("questionOne");
        String questionTwo = request.getParameter("questionTwo");
        String questionThree = request.getParameter("questionThree");
        String questionFour = request.getParameter("questionFour");
        String questionFive = request.getParameter("questionFive");
        String questionSix = request.getParameter("questionSix");
        String questionSeven = request.getParameter("questionSeven");
        String questionEight = request.getParameter("questionEight");
        String questionNine = request.getParameter("questionNine");
        String questionTen = request.getParameter("questionTen");

        int answerOne = Integer.parseInt(request.getParameter("answerOne"));
        int answerTwo = Integer.parseInt(request.getParameter("answerTwo"));
        int answerThree = Integer.parseInt(request.getParameter("answerThree"));
        int answerFour = Integer.parseInt(request.getParameter("answerFour"));
        int answerFive = Integer.parseInt(request.getParameter("answerFive"));
        int answerSix = Integer.parseInt(request.getParameter("answerSix"));
        int answerSeven = Integer.parseInt(request.getParameter("answerSeven"));
        int answerEight = Integer.parseInt(request.getParameter("answerEight"));
        int answerNine = Integer.parseInt(request.getParameter("answerNine"));
        int answerTen = Integer.parseInt(request.getParameter("answerTen"));

        int answerOneInput = Integer.parseInt(request.getParameter("answerOneInput"));
        int answerTwoInput = Integer.parseInt(request.getParameter("answerTwoInput"));
        int answerThreeInput = Integer.parseInt(request.getParameter("answerThreeInput"));
        int answerFourInput = Integer.parseInt(request.getParameter("answerFourInput"));
        int answerFiveInput = Integer.parseInt(request.getParameter("answerFiveInput"));
        int answerSixInput = Integer.parseInt(request.getParameter("answerSixInput"));
        int answerSevenInput = Integer.parseInt(request.getParameter("answerSevenInput"));
        int answerEightInput = Integer.parseInt(request.getParameter("answerEightInput"));
        int answerNineInput = Integer.parseInt(request.getParameter("answerNineInput"));
        int answerTenInput = Integer.parseInt(request.getParameter("answerTenInput"));

        int numberOfCorrectAnswer = 0;
        if (answerOneInput == answerOne)
        {
            numberOfCorrectAnswer++;
        }

        if (answerTwoInput == answerTwo)
        {
            numberOfCorrectAnswer++;
        }

        if (answerThreeInput == answerThree)
        {
            numberOfCorrectAnswer++;
        }

        if (answerFourInput == answerFour)
        {
            numberOfCorrectAnswer++;
        }

        if (answerFiveInput == answerFive)
        {
            numberOfCorrectAnswer++;
        }

        if (answerSixInput == answerSix)
        {
            numberOfCorrectAnswer++;
        }

        if (answerSevenInput == answerSeven)
        {
            numberOfCorrectAnswer++;
        }

        if (answerEightInput == answerEight)
        {
            numberOfCorrectAnswer++;
        }

        if (answerNineInput == answerNine)
        {
            numberOfCorrectAnswer++;
        }

        if (answerTenInput == answerTen)
        {
            numberOfCorrectAnswer++;
        }


        String sb = "<html><body>" + "<p>" + questionOne + answerOneInput + (answerOneInput == answerOne ? " Correct"
                                                                                                         : " Wrong") + "</p>" + "<p>" + questionTwo + answerTwoInput + (
                            answerTwoInput == answerTwo ? " Correct"
                                                        : " Wrong") + "</p>" + "<p>" + questionThree + answerThreeInput + (
                            answerThreeInput == answerThree ? " Correct"
                                                            : " Wrong") + "</p>" + "<p>" + questionFour + answerFourInput + (
                            answerFourInput == answerFour ? " Correct"
                                                          : " Wrong") + "</p>" + "<p>" + questionFive + answerFiveInput + (
                            answerFiveInput == answerFive ? " Correct"
                                                          : " Wrong") + "</p>" + "<p>" + questionSix + answerSixInput + (
                            answerSixInput == answerSix ? " Correct"
                                                        : " Wrong") + "</p>" + "<p>" + questionSeven + answerSevenInput + (
                            answerSevenInput == answerSeven ? " Correct"
                                                            : " Wrong") + "</p>" + "<p>" + questionEight + answerEightInput + (
                            answerEightInput == answerEight ? " Correct"
                                                            : " Wrong") + "</p>" + "<p>" + questionNine + answerNineInput + (
                            answerNineInput == answerNine ? " Correct"
                                                          : " Wrong") + "</p>" + "<p>" + questionTen + answerTenInput + (
                            answerTenInput == answerTen ? " Correct"
                                                        : " Wrong") + "</p>" + "<p>" + "The total correct count is " + numberOfCorrectAnswer + "</p>" + "</body></html>";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb);
    }

    public void destroy()
    {
    }
}