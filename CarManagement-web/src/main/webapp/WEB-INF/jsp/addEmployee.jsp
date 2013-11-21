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
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="employees" /></h1>
            </div>
            
            <h3><spring:message code="employee.add" /></h3>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newEmployee" action="${pageContext.request.contextPath}/employee/add">  
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
                            <option value="-" selected="selected">-- <spring:message code="employee.select.role" /></option>
                            <option value="1">Staff</option>
                            <option value="2">Manager</option>
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

