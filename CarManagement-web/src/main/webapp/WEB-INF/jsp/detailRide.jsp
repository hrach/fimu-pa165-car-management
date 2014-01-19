<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="detail.ride" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="detail.ride" /></h1>
            </div>
            <div class="content">


<table class="table table-hover table-autosize">

    <tr>
        <th><spring:message code="detail.ride.id" /></th>
        <td><c:out value="${ride.id}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.starttime" /></th>
        <td><fmt:formatDate value="${ride.startTime}" pattern="dd/MM/yyyy" /></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.endtime" /></th>
        <td><fmt:formatDate value="${ride.endTime}" pattern="dd/MM/yyyy" /></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.starttach" /></th>
        <td><c:out value="${ride.tachometerStart}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.endtach" /></th>
        <td><c:out value="${ride.tachometerEnd}"/></td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.employee" /></th>
        <td>
            <a href="${pageContext.request.contextPath}/admin/overview/employee/${ride.employee.id}">         
                <c:out value="${ride.employee.name}"/>
            </a>                
        </td>
    </tr>
    <tr>

        <th><spring:message code="detail.ride.vehicle" /></th>
        
        <td>
            <a href="${pageContext.request.contextPath}/admin/overview/vehicle/${ride.vehicle.id}">
                    <c:out value="${ride.vehicle.name}"/>
            </a>
        </td>
    </tr>    
    <tr>
        <th><spring:message code="detail.ride.description" /></th>
        
        <td>
                    <c:out value="${ride.description}"/>
        </td>
    </tr>  
</table>
        
<hr>
<p><a class="btn btn-info" href="${pageContext.request.contextPath}/admin/ride/"><span class="glyphicon glyphicon-circle-arrow-left"></span> <spring:message code="ride.backtolist" /></a></p>
        </div>          
            </div>
        </div>
    </body>
</html>