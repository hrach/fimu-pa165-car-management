<%-- 
    Document   : listEmployees
    Created on : 21.11.2013, 01:06:24
    Author     : Jakub Marecek <xmarec at gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="employees.list" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
       
        <div class="container">
            <%--<div class="page-header">
                <h1><spring:message code="employees" /></h1>
            </div>--%>
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissable">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div> 
            </c:if> 
            <div id="content">

                    <h3><spring:message code="employees.list" /></h3>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td><spring:message code="employee.id" /></td>
                                <td><spring:message code="employee.firstname" /></td>
                                <td><spring:message code="employee.familyname" /></td>
                                <td><spring:message code="employee.username" /></td>
                                <td><spring:message code="employee.role" /></td>
                                <td><spring:message code="employee.actions" /></td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td><c:out value="${employee.id}" /></td>
                                <td><c:out value="${employee.firstName}" /></td>
                                <td><c:out value="${employee.familyName}" /></td>
                                <td><c:out value="${employee.username}" /></td>
                                <c:if test="${employee.employeeRole==1}"><td><spring:message code="employee.role.staff" /></td></c:if>
                                <c:if test="${employee.employeeRole==2}"><td><spring:message code="employee.role.manager" /></td></c:if>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/overview/employee/${employee.id}.html" class="btn btn-info btn-xs"><spring:message code="view" /></a>
                                    <a href="${pageContext.request.contextPath}/admin/employee/edit/${employee.id}.html" class="btn btn-warning btn-xs"><spring:message code="edit" /></a>
                                    <a href="${pageContext.request.contextPath}/admin/employee/delete/${employee.id}.html" class="btn btn-danger btn-xs"><spring:message code="delete" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="${pageContext.request.contextPath}/admin/employee/add" class="btn btn-success"><spring:message code="employee.new" /></a></p>
              </div>
        </div>                        
    </body>
</html>
