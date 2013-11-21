<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><c:out value="${employee.firstName}"/> <c:out value="${employee.familyName}"/> <small><spring:message code="detail.employee" /></small></h2>
<table class="table">
    <tr>
        <th><spring:message code="detail.emp.id" /></th>
        <td><c:out value="${employee.id}"/></td>
    </tr>
    <tr>
        <th><spring:message code="detail.emp.name" /></th>
        <td><c:out value="${employee.firstName}"/> <c:out value="${employee.familyName}"/></td>
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
    <c:forEach items="${employee.rides}" var="ride">
        <tr>
            <td><c:out value="${ride.id}"/></td>
            <td><c:out value="${ride.startTime}"/></td>
            <td><c:out value="${ride.endTime}"/></td>
            <td><c:out value="${ride.tachometerStart}"/></td>
            <td><c:out value="${ride.tachometerEnd}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/overview/vehicle/${ride.vehicle.id}">
                    <c:out value="${ride.vehicle.name}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
