<%-- 
    Document   : listVehicles
    Created on : 12.12.2013, 15:38:05
    Author     : tomasbobek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management SOAP Client</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>

    <body>
        <div class="navigation-container">
            <nav class="navbar navbar-inverse" role="navigation">
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Car Management SOAP Client</a>
            </nav>
        </div>
        <div id="content" class="container">
            <div class="page-header">
                <h1>Vehicles list</h1>
            </div>
            
            <h3>Vehicles</h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td>id</td>
                                <td>name</td>
                                <td>tachometer</td>
                                <td>type</td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vehicles}" var="vehicle">
                            <tr>
                                <td><c:out value="${vehicle.id}" /></td>
                                <td><c:out value="${vehicle.name}" /></td>
                                <td><c:out value="${vehicle.tachometer}" /></td>
                                <td><c:out value="${vehicle.type.name}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/overview/vehicle/${vehicle.id}.html" class="btn btn-info btn-xs">view</a>
                                    <a href="${pageContext.request.contextPath}/vehicle/edit/${vehicle.id}.html" class="btn btn-warning btn-xs">edit</a>
                                    <a href="${pageContext.request.contextPath}/vehicle/delete/${vehicle.id}.html" class="btn btn-danger btn-xs">delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            
        </div>
    </body>
</html>