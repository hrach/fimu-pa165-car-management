<%-- 
    Document   : editEmployee
    Created on : 12.12.2013, 15:38:05
    Author     : tomasbobek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management SOAP Client</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>

    <body>
        <div class="navigation-container">
            <nav class="navbar navbar-inverse" role="navigation">
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Car Management SOAP Client</a>
            </nav>
        </div>
        <div id="content" class="container">
            <div class="page-header">
                <h1>Edit employee</h1>
            </div>
            <form:form cssClass="form-horizontal" method="POST" modelAttribute="employee" action="${pageContext.request.contextPath}/employee/edit/${employee.id}.html">  
                 <div class="form-group">
                    <label for="label-id" class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-10">
                        <p class="help-block" id="label-id">${employee.id}</p>
                    </div>
                </div>
                    
                <div class="form-group">                
                    <label for="input-firstname" class="col-sm-2 control-label">First name:</label>  
                    <div class="col-sm-10">
                        <form:input path="firstName" id="input-firstname" cssClass="form-control"></form:input>
                    </div> 
                </div>
                    
                <div class="form-group">
                    <label for="input-familyname" class="col-sm-2 control-label">Last name:</label>
                    <div class="col-sm-10">
                        <form:input path="familyName" id="input-familyname" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">
                    <label for="input-role" class="col-sm-2 control-label">Role:</label>
                    <div class="col-sm-10">
                        <form:select path="employeeRole" id="input-role" cssClass="form-control">
                            <option value="0">-- <spring:message code="employee.select.role" /></option>
                            <option value="1" ${employee.employeeRole == 1 ? 'selected="selected"' : ''}>Staff</option>
                            <option value="2" ${employee.employeeRole == 2 ? 'selected="selected"' : ''}>Manager</option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">Save</button>
                        <a href="${pageContext.request.contextPath}/index.htm" class="btn btn-warning">Cancel</a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>