<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="detail.vehicle" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <script>
            $(function() {
                $( ".datepicker" ).datepicker({
                    dateFormat: "dd/mm/yy",
                    dayNamesMin: [ '<spring:message code="days.short.su" />','<spring:message code="days.short.mo" />','<spring:message code="days.short.tu" />','<spring:message code="days.short.we" />','<spring:message code="days.short.th" />','<spring:message code="days.short.fr" />','<spring:message code="days.short.sa" />' ],
                    monthNames: [ '<spring:message code="months.long.jan" />', '<spring:message code="months.long.feb" />','<spring:message code="months.long.mar" />','<spring:message code="months.long.apr" />','<spring:message code="months.long.may" />','<spring:message code="months.long.jun" />','<spring:message code="months.long.jul" />','<spring:message code="months.long.aug" />','<spring:message code="months.long.sep" />','<spring:message code="months.long.oct" />','<spring:message code="months.long.nov" />','<spring:message code="months.long.dec" />' ],
                    firstDay: 1
                }
                    );
            });
            </script>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><c:out value="${vehicle.name}"/> <small><spring:message code="detail.vehicle" /></small></h1>
            </div>
            <div id="content">

                <table class="table table-hover table-autosize">
                    <tr>
                        <th><spring:message code="detail.vehicle.id" /></th>
                        <td><c:out value="${vehicle.id}"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="detail.vehicle.name" /></th>
                        <td><c:out value="${vehicle.name}"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="detail.vehicle.km" /></th>
                        <td><c:out value="${vehicle.sumKm}"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="detail.vehicle.driversSum" /></th>
                        <td><c:out value="${vehicle.sumDrivers}"/></td>
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
                            <td><spring:message code="detail.ride.employee" /></td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${vehicle.rides}" var="ride">
                        <tr>
                            <td><c:out value="${ride.id}"/></td>
                            <td><fmt:formatDate value="${ride.startTime}" pattern="dd/MM/yyyy" /></td>
                            <td><fmt:formatDate value="${ride.endTime}" pattern="dd/MM/yyyy" /></td>
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

                 <hr>
                <h3><spring:message code="detail.serviceIntervals" /></h3>
                <table class="table table-hover tabel-autosize">
                    <thead>
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

                <h3 style="margin-bottom: 20px; margin-top: 30px;"><spring:message code="detail.newServiceInterval" /></h3>
                <form:form cssClass="form-horizontal" method="POST" modelAttribute="newServiceInterval" action="">
                    <c:set var="hasError"><form:errors path="serviceType.id"/></c:set>
                    <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                        <label for="input-type" class="col-sm-2 control-label" style="width:70px;"><spring:message code="serviceInterval.type" />:</label>  
                        <div class="col-sm-4">
                            <form:select path="serviceType.id" id="input-type" cssClass="form-control">
                                <spring:message code="serviceInterval.select" var="emptyVal"/>
                                <form:option label="${emptyVal}" value="${null}"/>
                                <form:options items="${allTypes}" itemLabel="name" itemValue="id"/>
                            </form:select>
                            <form:errors path="serviceType.id" cssClass="help-block"></form:errors>                                                                            
                        </div> 
                    </div>
                    <c:set var="hasError"><form:errors path="dueTime"/></c:set>
                    <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                        <label for="input-due" class="col-sm-2 control-label" style="width:70px;"><spring:message code="serviceInterval.dueTime" />:</label>
                        <div class="col-sm-4">
                            <form:input path="dueTime" id="input-due" cssClass="form-control datepicker"></form:input>
                            <form:errors path="dueTime" cssClass="help-block"></form:errors>                                                                            
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-4" style="margin-left:70px;">
                            <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        </div>
                    </div>    
                </form:form>  
                <hr>
                <p><a class="btn btn-info" href="${pageContext.request.contextPath}/vehicle/"><span class="glyphicon glyphicon-circle-arrow-left"></span> <spring:message code="vehicle.backtolist" /></a></p>
        </div>        
        </div>
    </body>
</html>
