<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form id="submit-payment" modelAttribute="paymentForm" method="post" action="submit">
                    <form:hidden path="cardType" id="card-type"/>
                    <div class="form-group owner">
                        <label for="owner">Card Holder</label>
                        <form:input path="cardHolderName" class="form-control" id="owner"/>
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <form:input path="cvv" class="form-control" id="cvv"/>
                    </div>
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Card Number</label>
                        <form:input path="cardNumber" class="form-control" id="cardNumber"/>
                    </div>
                    <div class="form-group" id="expiration-date">
                        <label>Expiration Date</label>
                        <select name="month">
                            <option value="01">January</option>
                            <option value="02">February</option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <select name="year">
                            <option value="2018"> 2018</option>
                            <option value="2019"> 2019</option>
                            <option value="2020"> 2020</option>
                            <option value="2021"> 2021</option>
                            <option value="2020"> 2022</option>
                            <option value="2021"> 2023</option>
                            <option value="2021"> 2024</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Zipcode</label>
                        <form:input path="cardZipcode" class="form-control" />
                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="/resources/paymentdetail/images/visa.jpg" id="visa">
                        <img src="/resources/paymentdetail/images/mastercard.jpg" id="mastercard">
                    </div>
                    <div class="form-group" id="pay-now">
                        <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
                    </div>
            </form:form>

</body>
</html>