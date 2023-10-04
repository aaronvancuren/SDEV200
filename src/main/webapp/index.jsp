<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.m07programmingassignment2.AdditionQuizServlet" %>
<%@ page import="com.example.m07programmingassignment2.AdditionQuiz" %>
<jsp:useBean id="AdditionQuizServlet" scope="request"
             class="com.example.m07programmingassignment2.AdditionQuizServlet"/>
<jsp:useBean id="AdditionQuiz" scope="request" class="com.example.m07programmingassignment2.AdditionQuiz"/>
<!DOCTYPE html>
<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
<%! AdditionQuiz aq; %>
<%
    aq = new AdditionQuiz();
    String questionOne = aq.getQuestion();
    String questionTwo = aq.getQuestion();
    String questionThree = aq.getQuestion();
    String questionFour = aq.getQuestion();
    String questionFive = aq.getQuestion();
    String questionSix = aq.getQuestion();
    String questionSeven = aq.getQuestion();
    String questionEight = aq.getQuestion();
    String questionNine = aq.getQuestion();
    String questionTen = aq.getQuestion();
%>
<form method="get" action="AdditionQuizServlet">
    <input type="hidden" name="questionOne" value="<%= questionOne %>">
    <input type="hidden" name="questionTwo" value="<%= questionTwo %>">
    <input type="hidden" name="questionThree" value="<%= questionThree %>">
    <input type="hidden" name="questionFour" value="<%= questionFour %>">
    <input type="hidden" name="questionFive" value="<%= questionFive %>">
    <input type="hidden" name="questionSix" value="<%= questionSix %>">
    <input type="hidden" name="questionSeven" value="<%= questionSeven %>">
    <input type="hidden" name="questionEight" value="<%= questionEight %>">
    <input type="hidden" name="questionNine" value="<%= questionNine %>">
    <input type="hidden" name="questionTen" value="<%= questionTen %>">
    <input type="hidden" name="answerOne" value="<%= aq.getAnswer(questionOne) %>">
    <input type="hidden" name="answerTwo" value="<%= aq.getAnswer(questionTwo) %>">
    <input type="hidden" name="answerThree" value="<%= aq.getAnswer(questionThree) %>">
    <input type="hidden" name="answerFour" value="<%= aq.getAnswer(questionFour) %>">
    <input type="hidden" name="answerFive" value="<%= aq.getAnswer(questionFive) %>">
    <input type="hidden" name="answerSix" value="<%= aq.getAnswer(questionSix) %>">
    <input type="hidden" name="answerSeven" value="<%= aq.getAnswer(questionSeven) %>">
    <input type="hidden" name="answerEight" value="<%= aq.getAnswer(questionEight) %>">
    <input type="hidden" name="answerNine" value="<%= aq.getAnswer(questionNine) %>">
    <input type="hidden" name="answerTen" value="<%= aq.getAnswer(questionTen) %>">
    <p>
        <label for="answerOneInput"><%= questionOne %>
        </label><input id="answerOneInput" type="number" name="answerOneInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerTwoInput"><%= questionTwo %>
        </label><input id="answerTwoInput" type="number" name="answerTwoInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerThreeInput"><%= questionThree %>
        </label><input id="answerThreeInput" type="number" name="answerThreeInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerFourInput"><%= questionFour %>
        </label><input id="answerFourInput" type="number" name="answerFourInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerFiveInput"><%= questionFive %>
        </label><input id="answerFiveInput" type="number" name="answerFiveInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerSixInput"><%= questionSix %>
        </label><input id="answerSixInput" type="number" name="answerSixInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerSevenInput"><%= questionSeven %>
        </label><input id="answerSevenInput" type="number" name="answerSevenInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerEightInput"><%= questionEight %>
        </label><input id="answerEightInput" type="number" name="answerEightInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerNineInput"><%= questionNine %>
        </label><input id="answerNineInput" type="number" name="answerNineInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <label for="answerTenInput"><%= questionTen %>
        </label><input id="answerTenInput" type="number" name="answerTenInput" min="0" inputmode="numeric" step="1"
                       value="0"/>
    </p>
    <p>
        <input type="submit" name="submit" value="Submit">
        Click the browser's Refresh button to get a new quiz.
    </p>
</form>
</body>
</html>