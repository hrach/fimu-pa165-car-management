<%-- 
    Document   : addEmployee
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
        <script type="text/javascript">
            $(document).ready(function() {
                $('form#addEmp').submit(function() {
                    valid = true;
                    
                    if($.trim($('#input-firstname').val()) == '') {
                        valid = false;
                        $('#input-firstname').parent().addClass('has-error');
                    } else {
                        $('#input-firstname').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-familyname').val()) == '') {
                        valid = false;
                        $('#input-familyname').parent().addClass('has-error');
                    } else {
                        $('#input-familyname').parent().removeClass('has-error');
                    }
                    
                    if($('#input-role').val() == '0') {
                        valid = false;
                        $('#input-role').parent().addClass('has-error');
                    } else {
                        $('#input-role').parent().removeClass('has-error');
                    }
                    
                    if(valid) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });
        </script>
    </head>

    <body>
        <div class="navigation-container">
            <nav class="navbar navbar-inverse" role="navigation">
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Car Management SOAP Client</a>
            </nav>
        </div>
        <div id="content" class="container">
            <div class="page-header">
                <h1>Add employee</h1>
            </div>

            <form:form cssClass="form-horizontal" id="addEmp" method="POST" modelAttribute="newEmployee" action="${pageContext.request.contextPath}/employee/add">  
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
                            <option value="0" selected="selected">-- Role</option>
                            <option value="1">Staff</option>
                            <option value="2">Manager</option>
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
