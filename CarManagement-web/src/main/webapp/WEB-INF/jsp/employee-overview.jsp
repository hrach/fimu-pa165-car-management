<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="detail.employee" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><c:out value="${employee.name}"/> <small><spring:message code="detail.employee" /></small></h1>
            </div>
            <div class="content">

<table class="table table-hover table-autosize">
    <tr>
        <th><spring:message code="detail.emp.id" /></th>
        <td><c:out value="${employee.id}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.name" /></th>
        <td><c:out value="${employee.name}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.username" /></th>
        <td><c:out value="${employee.username}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.role" /></th>
        <td><spring:message code="detail.emp.role.${employee.employeeRole}" /></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.totalKm" /></th>
        <td><c:out value="${employee.rideKmSum}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.totalVehicles" /></th>
        <td><c:out value="${employee.uniqueVehicleSum}"/></td>
    </tr>

</table>
    
<h3><spring:message code="detail.employee.rides" /></h3>
<table class="table table-hover">
    <thead>
        <tr>
            <td><spring:message code="detail.ride.id" /></td>
            <td><spring:message code="detail.ride.starttime" /></td>
            <td><spring:message code="detail.ride.endtime" /></td>
            <td><spring:message code="detail.ride.starttach" /></td>
            <td><spring:message code="detail.ride.endtach" /></td>
            <td><spring:message code="detail.ride.vehicle" /></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee.rides}" var="ride">
        <tr>
            <td><c:out value="${ride.id}"/></td>
            <td><fmt:formatDate value="${ride.startTime}" pattern="dd/MM/yyyy" /></td>
            <td><fmt:formatDate value="${ride.endTime}" pattern="dd/MM/yyyy" /></td>
            <td><c:out value="${ride.tachometerStart}"/></td>
            <td><c:out value="${ride.tachometerEnd}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/overview/vehicle/${ride.vehicle.id}">
                    <c:out value="${ride.vehicle.name}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
        
        <p>
            <a href="${pageContext.request.contextPath}/admin/ride/add/${employee.id}" class="btn btn-success"><spring:message code="detail.emp.newrideforemp" /></a>            
        </p>
        
           <hr>
                <p><a class="btn btn-info" href="${pageContext.request.contextPath}/admin/employee/"><span class="glyphicon glyphicon-circle-arrow-left"></span> <spring:message code="employee.backtolist" /></a></p>

        </div>
        </div>
    </body>
</html>
