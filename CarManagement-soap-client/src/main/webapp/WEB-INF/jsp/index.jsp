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
            
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div> 
            </c:if>
            
            <h3 class="pull-left">Vehicles</h3>
            <div class="pull-right">
                <a href="${pageContext.request.contextPath}/vehicle/add" class="btn btn-success pushDown">Add new vehicle</a>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Tachometer</td>
                        <td>Type</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${vehicles}" var="vehicle">
                        <tr>
                            <td><c:out value="${vehicle.id}" /></td>
                            <td><c:out value="${vehicle.name}" /></td>
                            <td><c:out value="${vehicle.tachometer}" /></td>
                            <td><c:out value="${vehicle.type.name}" /></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/vehicle/edit/${vehicle.id}.html" class="btn btn-warning btn-xs">edit</a>
                                <a href="${pageContext.request.contextPath}/vehicle/delete/${vehicle.id}.html" class="btn btn-danger btn-xs">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <hr>
            
            <h3 class="pull-left">Employees</h3>
            <div class="pull-right">
                <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-success pushDown">Add new employee</a>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>Role</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td><c:out value="${employee.id}" /></td>
                            <td><c:out value="${employee.firstName}" /></td>
                            <td><c:out value="${employee.familyName}" /></td>
                            <c:if test="${employee.employeeRole==1}"><td>Staff</td></c:if>
                            <c:if test="${employee.employeeRole==2}"><td>Manager</td></c:if>
                            <td>
                                <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}.html" class="btn btn-warning btn-xs">Edit</a>
                                <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}.html" class="btn btn-danger btn-xs">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
        </div>
    </body>
</html>
