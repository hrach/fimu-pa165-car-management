<%-- 
    Document   : listRides
    Created on : 21.11.2013, 2:43:26
    Author     : Jakub Marecek <xmarec at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="rides.list" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div> 
            </c:if> 
            <div id="content">

                    <h3><spring:message code="rides.list" /></h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td><spring:message code="ride.id" /></td>
                                <td><spring:message code="ride.starttime" /></td>
                                <td><spring:message code="ride.endtime" /></td>
                                <td><spring:message code="ride.tachometerstart" /></td>
                                <td><spring:message code="ride.tachometerend" /></td>
<%--                                <td><spring:message code="ride.description" /></td> --%>
                                <td><spring:message code="ride.vehicle" /></td>
                                <td><spring:message code="ride.employee" /></td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${rides}" var="ride">
                            <tr>
                                <td><c:out value="${ride.id}" /></td>
                                <td><fmt:formatDate value="${ride.startTime}" pattern="dd/MM/yyyy" /></td>
                                <td><fmt:formatDate value="${ride.endTime}" pattern="dd/MM/yyyy" /></td>
                                <td><c:out value="${ride.tachometerStart}" /></td>
                                <td><c:out value="${ride.tachometerEnd}" /></td>
<%--                                <td><c:out value="${ride.description}" /></td> --%>
                                <td><c:out value="${ride.vehicle.name}" /></td>
                                <td><c:out value="${ride.employee.firstName}" />&nbsp;<c:out value="${ride.employee.familyName}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ride/detail/${ride.id}.html" class="btn btn-info btn-xs"><spring:message code="view" /></a>                                    
                                    <a href="${pageContext.request.contextPath}/ride/edit/${ride.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/ride/delete/${ride.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="${pageContext.request.contextPath}/ride/add" class="btn btn-success"><spring:message code="ride.new" /></a></p>
              </div>
        </div>                        
    </body>
</html>
