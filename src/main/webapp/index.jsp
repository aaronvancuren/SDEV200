<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exercise37_5</title>
</head>
<body>
<h1>Compute Loan Payment</h1>
<br/>
<form method="get" action="loanServlet">
    <p>
        <label for="loanAmount">Loan Amount</label>
        <input id="loanAmount" type="number" name="loanAmount" min="0" inputmode="decimal" step="0.01">
    </p>
    <p>
        <label for="annualInterestRate">Annual Interest Rate</label>
        <input id="annualInterestRate" type="number" name="annualInterestRate" min="0" inputmode="decimal" step="0.01">
    </p>
    <p>
        <label for="numberOfYears">Number of Years</label>
        <input id="numberOfYears" type="number" name="numberOfYears" min="0" inputmode="numeric" step="1">
    </p>
    <p>
        <input type="submit" value="Compute Loan Payment">
        <input type="reset" value="Reset">
    </p>
</form>
</body>
</html>