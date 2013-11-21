<%-- 
    Document   : listVehicles
    Created on : 19.11.2013, 21:59:27
    Author     : Jakub Marecek <xmarec at gmail.com>
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
                <h1>Vehicles list</h1>
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
                                <td><spring:message code="vehicle.id" /></td>
                                <td><spring:message code="vehicle.name" /></td>
                                <td><spring:message code="vehicle.tachometer" /></td>
                                <td><spring:message code="vehicle.type" /></td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vehicles}" var="vehicle">
                            <tr>
                                <td><c:out value="${vehicle.id}" /></td>
                                <td><c:out value="${vehicle.name}" /></td>
                                <td><c:out value="${vehicle.tachometer}" /></td>
                                <td><c:out value="${vehicle.type.maxKm}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/vehicle/edit/${vehicle.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/vehicle/delete/${vehicle.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="${pageContext.request.contextPath}/vehicle/add" class="btn btn-success"><spring:message code="vehicle.new" /></a></p>
              </div>
        </div>                        
    </body>
</html>
