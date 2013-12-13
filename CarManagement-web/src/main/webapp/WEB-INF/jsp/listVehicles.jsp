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
        <title><spring:message code="vehicle.list" /></title>
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

                    <h3><spring:message code="vehicle.list" /></h3>
                    <table class="table table-hover table-condensed">
                        <thead>
                            <tr>
                                <td><spring:message code="vehicle.id" /></td>
                                <td><spring:message code="vehicle.name" /></td>
                                <td><spring:message code="vehicle.tachometer" /></td>
                                <td><spring:message code="vehicle.fuel" /></td>
                                <td><spring:message code="vehicle.registrationPlate" /></td>
                                <td><spring:message code="vehicle.constructionyear" /></td>
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
                                <c:if test="${vehicle.fuel==1}"><td><spring:message code="vehicle.fuel.gas" /></td></c:if>
                                <c:if test="${vehicle.fuel==2}"><td><spring:message code="vehicle.fuel.oil" /></td></c:if>
                                <c:if test="${vehicle.fuel==3}"><td><spring:message code="vehicle.fuel.cng" /></td></c:if>
                                <c:if test="${vehicle.fuel==4}"><td><spring:message code="vehicle.fuel.lpg" /></td></c:if>
                                <c:if test="${vehicle.fuel==5}"><td><spring:message code="vehicle.fuel.electric" /></td></c:if>
                                <td><c:out value="${vehicle.registrationPlate}" /></td>
                                <td><c:out value="${vehicle.constructionYear}" /></td>
                                <td><c:out value="${vehicle.type.name}" /></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/overview/vehicle/${vehicle.id}.html" class="btn btn-info btn-xs"><spring:message code="view" /></a>
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
