<%-- 
    Document   : editVehicle
    Created on : 20.11.2013, 02:33:02
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
        <title>Add Vehicle</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1>Add Vehicle</h1>
            </div>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newVehicle" action="${pageContext.request.contextPath}/vehicle/add">  
                <div class="form-group">
                    <label for="input-name" class="col-sm-2 control-label"><spring:message code="vehicle.name" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="name" id="input-name" cssClass="form-control"></form:input>
                    </div> 
                </div>
                <div class="form-group">
                    <label for="input-tachometer" class="col-sm-2 control-label"><spring:message code="vehicle.tachometer" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometer" id="input-tachometer" cssClass="form-control"></form:input>
                    </div>  
                </div>
                <div class="form-group">
                    <label for="input-type" class="col-sm-2 control-label"><spring:message code="vehicle.type" />:</label>
                    <div class="col-sm-10">
                        <form:select path="type.id" id="input-type" cssClass="form-control">
                            <form:options items="${vehicleTypes}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/vehicle/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>
