<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/resources/screen.css"/>">
    </head>

    <body>

        <div class="navigation-container">
        <nav class="navbar navbar-inverse" role="navigation">
                <a class="navbar-brand" href="${pageContext.request.contextPath}"><spring:message code="home" /></a>
                <%--<h4><spring:message code="outside" /></h4>--%>
                <div class="collapse navbar-collapse">
                <ul class="nav nav-navbar">
                    <li class="active"><a href="${pageContext.request.contextPath}/ride/" >Rides</a></li>
                    <li><a href="${pageContext.request.contextPath}/vehicle/">Vehicles</a></li>
                    <li><a href="${pageContext.request.contextPath}/employee/">Employees</a></li>
                </ul>
                </div>
        </nav>
        </div>
        <div id="content" class="container">
                <table>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td><c:out value="${item.id}" /></td>
                            <td><c:out value="${item.maxKm}" /></td>
                        </tr>
                    </c:forEach>
                </table>
          </div>   
                      
    </body>
</html>
