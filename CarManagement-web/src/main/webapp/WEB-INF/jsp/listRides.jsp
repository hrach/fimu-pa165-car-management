<%-- 
    Document   : listRides
    Created on : 21.11.2013, 2:43:26
    Author     : Jakub Marecek <xmarec at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="rides.list" /></title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="rides" /></h1>
            </div>
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div> 
            </c:if> 
            <div id="content">
                    <h3><spring:message code="rides.list" /></h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td><spring:message code="ride.id" /></td>
                                <td><spring:message code="ride.starttime" /></td>
                                <td><spring:message code="ride.endtime" /></td>
                                <td><spring:message code="ride.tachometerstart" /></td>
                                <td><spring:message code="ride.tachometerend" /></td>
                                <td><spring:message code="ride.description" /></td>
                                <td><spring:message code="ride.vehicle" /></td>
                                <td><spring:message code="ride.employee" /></td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${rides}" var="ride">
                            <tr>
                                <td><c:out value="${ride.id}" /></td>
                                <td><c:out value="${ride.startTime}" /></td>
                                <td><c:out value="${ride.endTime}" /></td>
                                <td><c:out value="${ride.tachometerStart}" /></td>
                                <td><c:out value="${ride.tachometerEnd}" /></td>
                                <td><c:out value="${ride.description}" /></td>
                                <td><c:out value="${ride.vehicle.name}" />&nbsp;(ID:<c:out value="${ride.vehicle.id}" />)</td>
                                <td><c:out value="${ride.employee.firstName}" />&nbsp;<c:out value="${ride.employee.familyName}" /> (ID:<c:out value="${ride.employee.id})" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ride/edit/${ride.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/ride/delete/${ride.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="${pageContext.request.contextPath}/ride/add" class="btn btn-success"><spring:message code="ride.new" /></a></p>
              </div>
        </div>                        
    </body>
</html>
