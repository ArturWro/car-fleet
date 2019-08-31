<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 22.08.2019
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auta</title>
</head>
<body>
<h1>Auta</h1>
<table cellspacing="0" cellpadding="0" border="4" table-layout: auto>
    <thead>
    <tr>
        <th>Marka</th>
        <th>Model</th>
        <th>Numer VIN</th>
        <th>Czy zarezerwowany</th>
        <th>Rezerwacja</th>
        <th>Aktualizacja</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${carslist}" var="car">

    <tbody>
    <tr>
        <form action="/cars" method="post">
            <td>${car.carBrand}</td>
            <td>${car.carModel}</td>
            <td>${car.vinNr}</td>
            <td>${car.reservation}</td>
                <%--                                <td>${car.carUpdate}</td>--%>
            <td>
                <c:if test="${car.reservation==true}">
                    <button name = "msg" value=${car.id} type="submit" class="registerbtn">Zwróć</button>
                </c:if>
                <c:if test="${car.reservation==false}">
                    <button name = "msg" value=${car.id} type="submit" class="registerbtn">Zarezerwuj</button>
                </c:if>
            </td>
        </form>
    </tr>
    </tbody>
    </c:forEach>
</body>
</html>