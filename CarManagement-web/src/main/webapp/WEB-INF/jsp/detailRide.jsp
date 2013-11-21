<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><small><spring:message code="detail.ride" /></small></h2>

<table class="table">

    <tr>
        <th><spring:message code="detail.ride.id" /></th>
        <td><c:out value="${ride.id}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.starttime" /></th>
        <td><c:out value="${ride.startTime}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.endtime" /></th>
        <td><c:out value="${ride.endTime}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.starttach" /></th>
        <td><c:out value="${ride.tachometerStart}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.endtach" /></th>
        <td><c:out value="${ride.tachometerEnd}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.employee" /></th>
        <td>
            <a href="${pageContext.request.contextPath}/overview/employee/${ride.employee.id}">         
                <c:out value="${ride.employee.name}"/>
            </a>                
        </td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.vehicle" /></th>
        
        <td>
            <a href="${pageContext.request.contextPath}/overview/vehicle/${ride.vehicle.id}">
                    <c:out value="${ride.vehicle.name}"/>
            </a>
        </td>
    </tr>    
</table>
