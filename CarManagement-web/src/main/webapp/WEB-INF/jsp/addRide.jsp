<%-- 
    Document   : addRide
    Created on : 22.11.2013, 20:02:29
    Author     : tomasbobek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="ride.new" /></title>
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
                <h1><spring:message code="ride.add" /></h1>
            </div>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newRide" action="${pageContext.request.contextPath}/admin/ride/add">  
                <c:set var="hasError"><form:errors path="startTime"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-starttime" class="col-sm-2 control-label"><spring:message code="ride.starttime" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="startTime" id="input-starttime" cssClass="form-control datepicker"></form:input>
                        <form:errors path="startTime" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>
                <c:set var="hasError"><form:errors path="endTime"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-endtime" class="col-sm-2 control-label"><spring:message code="ride.endtime" />:</label>
                    <div class="col-sm-10">
                        <form:input path="endTime" id="input-endtime" cssClass="form-control datepicker"></form:input>
                        <form:errors path="endTime" cssClass="help-block"></form:errors>                                                
                    </div>  
                </div>
                    
                <c:set var="hasError"><form:errors path="tachometerStart"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-tachometerstart" class="col-sm-2 control-label"><spring:message code="ride.tachometerstart" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometerStart" id="input-tachometerstart" cssClass="form-control"></form:input>
                        <form:errors path="tachometerStart" cssClass="help-block"></form:errors>                        
                    </div>  
                </div>
                <c:set var="hasError"><form:errors path="tachometerEnd"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-tachometerend" class="col-sm-2 control-label"><spring:message code="ride.tachometerend" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometerEnd" id="input-tachometerend" cssClass="form-control"></form:input>
                        <form:errors path="tachometerEnd" cssClass="help-block"></form:errors>                        
                    </div>  
                </div>
                <c:set var="hasError"><form:errors path="description"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-description" class="col-sm-2 control-label"><spring:message code="ride.description" />:</label>
                    <div class="col-sm-10">
                        <form:input path="description" id="input-description" cssClass="form-control"></form:input>
                        <form:errors path="description" cssClass="help-block"></form:errors>                        
                    </div>  
                </div>
                    
                <c:set var="hasError"><form:errors path="vehicle.id"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-vehicle" class="col-sm-2 control-label"><spring:message code="ride.vehicle" />:</label>
                    <div class="col-sm-10">
                        <form:select path="vehicle.id" id="input-vehicle" cssClass="form-control">
                            <spring:message code="vehicle.select" var="emptyVal"/>
                            <form:option label="${emptyVal}" value="${null}"/>
                            <form:options items="${vehicles}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:errors path="vehicle.id" cssClass="help-block"></form:errors>                                                
                    </div>
                </div>
                    
                <c:set var="hasError"><form:errors path="employee.id"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-employee" class="col-sm-2 control-label"><spring:message code="ride.employee" />:</label>
                    <div class="col-sm-10">
                        <form:select path="employee.id" id="input-employee" cssClass="form-control">
                            <spring:message code="employee.select" var="emptyVal"/>
                            <form:option label="${emptyVal}" value="${null}"/>
                            <form:options items="${employees}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:errors path="employee.id" cssClass="help-block"></form:errors>                                                
                    </div>
                </div>
                    
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/admin/ride/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>