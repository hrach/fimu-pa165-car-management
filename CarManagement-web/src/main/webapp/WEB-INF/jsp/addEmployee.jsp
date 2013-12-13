<%-- 
    Document   : addEmployee
    Created on : 21.11.2013, 1:54:17
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
        <title><spring:message code="employee.add" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="employee.add" /></h1>
            </div>
            
            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newEmployee" action="${pageContext.request.contextPath}/employee/add">  
                <c:set var="hasError"><form:errors path="firstName"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-firstname" class="col-sm-2 control-label"><spring:message code="employee.firstname" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="firstName" id="input-firstname" cssClass="form-control"></form:input>
                        <form:errors path="firstName" cssClass="help-block"></form:errors>                        
                    </div> 
                </div>
                    
                <c:set var="hasError"><form:errors path="familyName"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-familyname" class="col-sm-2 control-label"><spring:message code="employee.familyname" />:</label>
                    <div class="col-sm-10">
                        <form:input path="familyName" id="input-familyname" cssClass="form-control"></form:input>
                        <form:errors path="familyName" cssClass="help-block"></form:errors>
                    </div>  
                </div>
                    
                <c:set var="hasError"><form:errors path="username"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-username" class="col-sm-2 control-label"><spring:message code="employee.username" />:</label>
                    <div class="col-sm-10">
                        <form:input path="username" id="input-username" cssClass="form-control"></form:input>
                        <form:errors path="username" cssClass="help-block"></form:errors>
                    </div>  
                </div>
                    
                <c:set var="hasError"><form:errors path="password"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-password" class="col-sm-2 control-label"><spring:message code="employee.password" />:</label>
                    <div class="col-sm-10">
                        <form:password path="password" id="input-password" cssClass="form-control" />
                        <form:errors path="password" cssClass="help-block"></form:errors>
                    </div>  
                </div>     
                    
                <c:set var="hasError"><form:errors path="employeeRole"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-role" class="col-sm-2 control-label"><spring:message code="employee.role" />:</label>
                    <div class="col-sm-10">
                        <form:select path="employeeRole" id="input-role" cssClass="form-control">
                            <option value="0" selected="selected">-- <spring:message code="employee.select.role" /></option>
                            <option value="1"><spring:message code="employee.role.staff" /></option>
                            <option value="2"><spring:message code="employee.role.manager" /></option>
                        </form:select>
                        <form:errors path="employeeRole" cssClass="help-block"></form:errors>                            
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/employee/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>

