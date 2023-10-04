package com.example.m07programmingassignment1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loanServlet", value = "/loanServlet")
public class LoanServlet extends HttpServlet
{
    private Loan loan = new Loan();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        loan = new Loan(Double.parseDouble(request.getParameter("annualInterestRate")),
                        Integer.parseInt(request.getParameter("numberOfYears")),
                        Double.parseDouble(request.getParameter("loanAmount")));

        String sb
                = "<html><body>" + "<p>Loan Amount: " + loan.getLoanAmount() + "</p>" + "<p>Annual Interest Rate: " + loan.getAnnualInterestRate() + "</p>" + "<p>Number of Years: " + loan.getNumberOfYears() + "</p>" + "<p>Monthly Payment: " + loan.getMonthlyPayment() + "</p>" + "<p>Total Payment: " + loan.getTotalPayment() + "</p>" + "<body><html>";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb);
    }

    public void destroy()
    {
    }
}