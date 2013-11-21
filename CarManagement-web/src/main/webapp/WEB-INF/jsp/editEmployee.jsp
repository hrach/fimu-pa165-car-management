<%-- 
    Document   : editEmployee
    Created on : 21.11.2013, 1:21:59
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
        <title><spring:message code="employee.edit" /></title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/resources/screen.css"/>">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="employees" /></h1>
            </div>
            
            <h3><spring:message code="employee.edit" /></h3>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="employee" action="${pageContext.request.contextPath}/employee/edit/${employee.id}.html">  
                 <div class="form-group">
                    <label for="label-id" class="col-sm-2 control-label"><spring:message code="employee.id" /></label>
                    <div class="col-sm-10">
                        <p class="help-block" id="label-id">${employee.id}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-firstname" class="col-sm-2 control-label"><spring:message code="employee.firstname" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="firstName" id="input-firstname" cssClass="form-control"></form:input>
                    </div> 
                </div>
                <div class="form-group">
                    <label for="input-familyname" class="col-sm-2 control-label"><spring:message code="employee.familyname" />:</label>
                    <div class="col-sm-10">
                        <form:input path="familyName" id="input-familyname" cssClass="form-control"></form:input>
                    </div>  
                </div>
                <div class="form-group">
                    <label for="input-role" class="col-sm-2 control-label"><spring:message code="employee.role" />:</label>
                    <div class="col-sm-10">
                        <form:select path="employeeRole" id="input-role" cssClass="form-control">
                            <option value="-">-- <spring:message code="employee.select.role" /></option>
                            <option value="1" ${employee.employeeRole == 1 ? 'selected="selected"' : ''}>Staff</option>
                            <option value="2" ${employee.employeeRole == 2 ? 'selected="selected"' : ''}>Manager</option>
                        </form:select>
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
