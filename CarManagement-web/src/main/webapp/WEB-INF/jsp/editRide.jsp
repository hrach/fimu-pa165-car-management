<%-- 
    Document   : editRide
    Created on : 21.11.2013, 4:12:29
    Author     : Jakub Marecek <xmarec at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="ride.edit" /></title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="rides" /></h1>
            </div>
            
            <h3><spring:message code="ride.edit" /></h3>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="ride" action="${pageContext.request.contextPath}/ride/edit/${ride.id}.html">  
                 <div class="form-group">
                    <label for="label-id" class="col-sm-2 control-label"><spring:message code="ride.id" /></label>
                    <div class="col-sm-10">
                        <p class="help-block" id="label-id">${ride.id}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-starttime" class="col-sm-2 control-label"><spring:message code="ride.starttime" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="startTime" id="input-starttime" cssClass="form-control"></form:input>
                    </div> 
                </div>
                <div class="form-group">
                    <label for="input-endtime" class="col-sm-2 control-label"><spring:message code="ride.endtime" />:</label>
                    <div class="col-sm-10">
                        <form:input path="endTime" id="input-endtime" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">
                    <label for="input-tachometerstart" class="col-sm-2 control-label"><spring:message code="ride.tachometerstart" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometerStart" id="input-tachometerstart" cssClass="form-control"></form:input>
                    </div>  
                </div>
                <div class="form-group">
                    <label for="input-tachometerend" class="col-sm-2 control-label"><spring:message code="ride.tachometerend" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometerEnd" id="input-tachometerend" cssClass="form-control"></form:input>
                    </div>  
                </div>
                <div class="form-group">
                    <label for="input-description" class="col-sm-2 control-label"><spring:message code="ride.description" />:</label>
                    <div class="col-sm-10">
                        <form:input path="description" id="input-description" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">
                    <label for="input-vehicle" class="col-sm-2 control-label"><spring:message code="ride.vehicle" />:</label>
                    <div class="col-sm-10">
                        <form:select path="vehicle.id" id="input-vehicle" cssClass="form-control">
                            <form:options items="${vehicles}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label for="input-employee" class="col-sm-2 control-label"><spring:message code="ride.employee" />:</label>
                    <div class="col-sm-10">
                        <select name="employee" class="form-control">
                            <c:forEach var="employee" items="${employees}" >
                                <option value="${employee.id}" label="${employee.firstName} ${employee.familyName}" ${employee.id == ride.employee.id ? 'selected="selected"' : ''} />
                            </c:forEach>
                        </select>
                    </div>
                </div>
                    
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/ride/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>