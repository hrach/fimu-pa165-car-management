<%-- 
    Document   : addVehicleType
    Created on : 12.12.2013, 15:38:05
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
        <title>Add Vehicle Type</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1>Add Vehicle</h1>
            </div>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newVehicleType" action="${pageContext.request.contextPath}/vehicle-type/add">  
                <c:set var="hasError"><form:errors path="name"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-name" class="col-sm-2 control-label"><spring:message code="vehicletype.name" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="name" id="input-name" cssClass="form-control"></form:input>
                        <form:errors path="name" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>
                <c:set var="hasError"><form:errors path="maxKm"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-maxkm" class="col-sm-2 control-label"><spring:message code="vehicletype.maxkm" />:</label>
                    <div class="col-sm-10">
                        <form:input path="maxKm" id="input-maxkm" cssClass="form-control"></form:input>
                        <form:errors path="maxKm" cssClass="help-block"></form:errors>                                                
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/vehicle-type/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>
