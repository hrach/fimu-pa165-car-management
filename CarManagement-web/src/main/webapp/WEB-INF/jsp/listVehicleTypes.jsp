<%-- 
    Document   : listVehicleTypes
    Created on : 12.12.2013, 15:30:11
    Author     : tomasbobek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vehicles</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="vehicletype.list" /></h1>
            </div>
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div> 
            </c:if> 
            <div id="content">

                    <h3><spring:message code="home" /></h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td><spring:message code="vehicletype.id" /></td>
                                <td><spring:message code="vehicletype.name" /></td>
                                <td><spring:message code="vehicletype.maxkm" /></td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vehicle-types}" var="vehicle-type">
                            <tr>
                                <td><c:out value="${vehicle-type.id}" /></td>
                                <td><c:out value="${vehicle-type.name}" /></td>
                                <td><c:out value="${vehicle-type.maxkm}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/vehicle-type/edit/${vehicle-type.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/vehicle-type/delete/${vehicle-type.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="${pageContext.request.contextPath}/vehicle-type/add" class="btn btn-success"><spring:message code="vehicletype.new" /></a></p>
              </div>
        </div>                        
    </body>
</html>
