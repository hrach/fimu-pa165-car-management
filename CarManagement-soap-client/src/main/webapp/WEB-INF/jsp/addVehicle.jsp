<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                <h1>Add Vehicle</h1>
            </div>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newVehicle" action="${pageContext.request.contextPath}/vehicle/add">  
                <div class="form-group">                
                    <label for="input-name" class="col-sm-2 control-label">Name:</label>  
                    <div class="col-sm-10">
                        <form:input path="name" id="input-name" cssClass="form-control"></form:input>                                               
                    </div> 
                </div>
                <c:set var="hasError"><form:errors path="tachometer"/></c:set>
                <div class="form-group">                
                    <label for="input-tachometer" class="col-sm-2 control-label">Tachometer:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometer" id="input-tachometer" cssClass="form-control"></form:input>
                    </div>  
                </div>
                <c:set var="hasError"><form:errors path="type.id"/></c:set>
                <div class="form-group">                
                    <label for="input-type" class="col-sm-2 control-label">Type:</label>
                    <div class="col-sm-10">
                        <form:select path="type.id" id="input-type" cssClass="form-control">
                            <form:options items="${vehicleTypes}" itemValue="id" itemLabel="name"/>
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