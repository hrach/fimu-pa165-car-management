<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="home" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $("#employeeSearch").typeahead({
                    name: "employees",
                    valueKey: "name",
                    remote: "${pageContext.request.contextPath}/admin/employee/search/%QUERY",
                    template: "<a href=\"/pa165/admin/overview/employee/{{id}}\">{{name}}</p>",
                    engine: Hogan,
                    limit: 5
                });
                
                $("#vehicleSearch").typeahead({
                    name: "vehicles",
                    valueKey: "name",
                    remote: "${pageContext.request.contextPath}/admin/vehicle/search/%QUERY",
                    template: "<a href=\"pa165/admin/overview/vehicle/{{id}}\">{{name}}</p>",
                    engine: Hogan,
                    limit: 5
                });
                
                $('#employeeSearch').bind('typeahead:selected', function(obj, datum, name) {
                    window.location.href = '${pageContext.request.contextPath}/admin/overview/employee/'+datum.id;
                });
                
                $('#vehicleSearch').bind('typeahead:selected', function(obj, datum, name) {
                    window.location.href = '${pageContext.request.contextPath}/admin/overview/vehicle/'+datum.id;
                });
            });
        </script>
    </head>

    <body>

        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
                
        <div id="content" class="container">
            <div class="page-header"><h1><spring:message code="home" /> <small><spring:message code="home.subtitle" /></small></h1></div>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <p><spring:message code="home.loggedasadmin" /> - <a href="${pageContext.request.contextPath}/admin/" class="btn btn-info"><spring:message code="home.gotoadmin" /></a></p>
            </sec:authorize>
                
                <h3><spring:message code="home.myrides" /> (${employee.name})</h3>
<table class="table table-hover">
    <thead>
        <tr>
            <td><spring:message code="detail.ride.id" /></td>
            <td><spring:message code="detail.ride.starttime" /></td>
            <td><spring:message code="detail.ride.endtime" /></td>
            <td><spring:message code="detail.ride.starttach" /></td>
            <td><spring:message code="detail.ride.endtach" /></td>
            <td><spring:message code="detail.ride.vehicle" /></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee.rides}" var="ride">
        <tr>
            <td><c:out value="${ride.id}"/></td>
            <td><fmt:formatDate value="${ride.startTime}" pattern="dd/MM/yyyy" /></td>
            <td><fmt:formatDate value="${ride.endTime}" pattern="dd/MM/yyyy" /></td>
            <td><c:out value="${ride.tachometerStart}"/></td>
            <td><c:out value="${ride.tachometerEnd}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/overview/vehicle/${ride.vehicle.id}">
                    <c:out value="${ride.vehicle.name}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
        </div>
            
                

                      
    </body>
</html>
