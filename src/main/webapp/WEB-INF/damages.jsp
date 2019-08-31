<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Damages</title>
</head>

<body>
<h1>Damages</h1>

<form:form method="post" modelAttribute="damagesList">

    <div class="container">

        <c:forEach items="${damagesList}" var="damage">
            <table cellspacing="0" cellpadding="0" border="2" style="width: 25%;">
                <tr>
                    <th>l.p</th>
                    <th>Damage Type</th>
                    <th>Description</th>
                    <th>Drivable</th>
                    <th>Car Model</th>
                    <th>Car Vin</th>
                    <th>Car Repair</th>

                </tr>

                <tbody>
                <tr>
                    <td>${damage.id}</td>
                    <td>${damage.damageType}</td>
                    <td>${damage.description}</td>
                    <td>${damage.drivable}</td>
                    <td>${damage.car.carModel}</td>
                    <td>${damage.car.vinNr}</td>
                    <td>${damage.car.vinNr}</td>
                    <td>
                        <c:if test="${car.reservation==true}">
                            <button name="msg" value=${car.id} type="submit" class="registerbtn">Zwróć</button>
                        </c:if>
                        <c:if test="${car.reservation==false}">
                            <button name="msg" value=${car.id} type="submit" class="registerbtn">Zarezerwuj</button>
                        </c:if>
                    </td>
                    </form>

                </tr>
                </tbody>
            </table>
        </c:forEach>

        <h4 class="text-center"><a href="${contextPath}/adddamage">Add new damage </a></h4>

    </div>
</form:form>
</body>
</html>

