<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2><c:out value="${vehicle.name}"/></h2>

<spring:message code="detail.vehicle.id" />
<c:out value="${vehicle.id}"/><br>

<spring:message code="detail.vehicle.name" />
<c:out value="${vehicle.name}"/><br>

<spring:message code="detail.vehicle.km" />
<c:out value="${vehicle.sumKm}"/><br>

<spring:message code="detail.vehicle.driversSum" />
<c:out value="${vehicle.sumDrivers}"/>


<h3><spring:message code="detail.employee.rides" /></h3>
<table class="table">
    <thead>
        <tr>
            <td><spring:message code="detail.ride.id" /></td>
            <td><spring:message code="detail.ride.starttime" /></td>
            <td><spring:message code="detail.ride.endtime" /></td>
            <td><spring:message code="detail.ride.starttach" /></td>
            <td><spring:message code="detail.ride.endtach" /></td>
            <td><spring:message code="detail.ride.employee" /></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${vehicle.rides}" var="ride">
        <tr>
            <td><c:out value="${ride.id}"/></td>
            <td><c:out value="${ride.startTime}"/></td>
            <td><c:out value="${ride.endTime}"/></td>
            <td><c:out value="${ride.tachometerStart}"/></td>
            <td><c:out value="${ride.tachometerEnd}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/overview/employee/${ride.employee.id}">
                    <c:out value="${ride.employee.name}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3><spring:message code="detail.serviceIntervals" /></h3>
<table class="table">
    <thread>
        <tr>
            <td><spring:message code="detail.serviceIntervals.type" /></td>
            <td><spring:message code="detail.serviceIntervals.createdtime" /></td>
            <td><spring:message code="detail.serviceIntervals.duetime" /></td>
            <td><spring:message code="detail.serviceIntervals.donetime" /></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${vehicle.serviceIntervals}" var="interval">
        <tr>
            <td><c:out value="${interval.serviceType.name}"/></td>
            <td><c:out value="${interval.createdTime}"/></td>
            <td><c:out value="${interval.dueTime}"/></td>
            <td>
                <c:out value="${interval.doneTime}"/>
                <!-- tady v pripade ze to neni null asi zobrazit hlavne nejakou fajfku -->
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

        
        
<form:form cssClass="form-horizontal" method="POST" modelAttribute="newServiceInterval" action="">
    <div class="form-group">
        <label for="input-type" class="col-sm-2 control-label"><spring:message code="serviceInterval.type" />:</label>  
        <div class="col-sm-10">
            <form:select path="serviceType.id" id="input-type" cssClass="form-control">
                <spring:message code="serviceInterval.select" var="emptyVal"/>
                <form:option label="${emptyVal}" value="${null}"/>
                <form:options items="${allTypes}" itemLabel="name" itemValue="id"/>
            </form:select>
        </div> 
    </div>
    <div class="form-group">
        <label for="input-due" class="col-sm-2 control-label"><spring:message code="serviceInterval.dueTime" />:</label>
        <div class="col-sm-10">
            <form:input path="dueTime" id="input-due" cssClass="form-control"></form:input>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
        </div>
    </div>    
</form:form>  