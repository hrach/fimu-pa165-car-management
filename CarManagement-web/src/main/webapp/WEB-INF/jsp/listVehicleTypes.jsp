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
        <title><spring:message code="vehicletype.list" /></title>
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

                    <h3><spring:message code="vehicletype.list" /></h3>
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
                        <c:forEach items="${vehicleTypes}" var="vehicleType">
                            <tr>
                                <td><c:out value="${vehicleType.id}" /></td>
                                <td><c:out value="${vehicleType.name}" /></td>
                                <td><c:out value="${vehicleType.maxKm}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/vehicle-type/edit/${vehicleType.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/vehicle-type/delete/${vehicleType.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
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
