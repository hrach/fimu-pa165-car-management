<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="detail.employee" /></h2>
<table class="table">
    <tr>
        <th><spring:message code="detail.emp.id" /></th>
        <td><c:out value="${employee.getId()}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.name" /></th>
        <td><c:out value="${employee.getFirstName()}"/> <c:out value="${employee.getFamilyName()}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.role" /></th>
        <td><spring:message code="detail.emp.role.${employee.getEmployeeRole()}" /></td>
    </tr>
</table>
    
<h3><spring:message code="detail.employee.rides" /></h3>
<table class="table">
    <thread>
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
    <c:forEach items="${rides}" var="ride">
        <tr>
            <td><c:out value="${ride.getId()}"/></td>
            <td><c:out value="${ride.getStartTime()}"/></td>
            <td><c:out value="${ride.getEndTime()}"/></td>
            <td><c:out value="${ride.getTachometerStart()}"/></td>
            <td><c:out value="${ride.getTachometerEnd()}"/></td>
            <td><c:out value="${ride.getVehicle().getId()}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
