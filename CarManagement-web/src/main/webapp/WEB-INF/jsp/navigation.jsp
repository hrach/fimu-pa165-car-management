<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<c:set var="path" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="urlpart" value="${fn:split(path,'/')}"/>

<div class="navigation-container">
    <nav class="navbar navbar-inverse" role="navigation">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"><spring:message code="home" /></a>
        <%--<h4><spring:message code="outside" /></h4>--%>
        <%--<div class="collapse navbar-collapse">
            <ul class="nav nav-navbar">
                <li><a href="${pageContext.request.contextPath}/ride/" ><spring:message code="navigation.rides" /></a></li>
                <li><a href="${pageContext.request.contextPath}/vehicle/"><spring:message code="navigation.vehicles" /></a></li>
                <li><a href="${pageContext.request.contextPath}/employee/"><spring:message code="navigation.employees" /></a></li>
            </ul>
        </div>--%>
        
        <div class="pull-right">
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/myride/" class="${urlpart[1] eq 'myride' ? 'btn btn-info link' : 'btn btn-default link'}"><spring:message code="navigation.myrides" /></a>
            <button type="button" class="${urlpart[1] eq 'myride' ? 'btn btn-info dropdown-toggle' : 'btn btn-default dropdown-toggle'}" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/myride/list/"><spring:message code="navigation.myrides.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/myride/add/"><spring:message code="navigation.myrides.new" /></a></li>
            </ul>
        </div>    

        <sec:authorize access="hasRole('ROLE_MANAGER')">
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/admin/employee/" class="${urlpart[2] eq 'employee' ? 'btn btn-info link' : 'btn btn-default link'}"><spring:message code="navigation.employees" /></a>
            <button type="button" class="${urlpart[2] eq 'employee' ? 'btn btn-info dropdown-toggle' : 'btn btn-default dropdown-toggle'}" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/admin/employee/list/"><spring:message code="navigation.employees.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/employee/add/"><spring:message code="navigation.employees.new" /></a></li>
            </ul>
        </div>
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/admin/vehicle/" class="${urlpart[2] eq 'vehicle' ? 'btn btn-info link' : 'btn btn-default link'}"><spring:message code="navigation.vehicles" /></a>
            <button type="button" class="${urlpart[2] eq 'vehicle' ? 'btn btn-info dropdown-toggle' : 'btn btn-default dropdown-toggle'}" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/admin/vehicle/list/"><spring:message code="navigation.vehicles.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/vehicle/add/"><spring:message code="navigation.vehicles.new" /></a></li>
            </ul>
        </div>
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/admin/vehicle-type/" class="${urlpart[2] eq 'vehicle-type' ? 'btn btn-info link' : 'btn btn-default link'}"><spring:message code="navigation.vehicletypes" /></a>
            <button type="button" class="${urlpart[2] eq 'vehicle-type' ? 'btn btn-info dropdown-toggle' : 'btn btn-default dropdown-toggle'}" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/admin/vehicle-type/list/"><spring:message code="navigation.vehicletypes.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/vehicle-type/add/"><spring:message code="navigation.vehicletypes.new" /></a></li>
            </ul>
        </div>
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/admin/ride/" class="${urlpart[2] eq 'ride' ? 'btn btn-info link' : 'btn btn-default link'}"><spring:message code="navigation.rides" /></a>
            <button type="button" class="${urlpart[2] eq 'ride' ? 'btn btn-info dropdown-toggle' : 'btn btn-default dropdown-toggle'}" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/admin/ride/list/"><spring:message code="navigation.rides.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/ride/add/"><spring:message code="navigation.rides.new" /></a></li>
            </ul>
        </div>
        </sec:authorize>
        </div>
    </nav>
</div>
<div class="userBar">
    <div class="inner">
        <p style="display: inline-block;"><span style="color: #555;"><spring:message code="navigation.loggeduser" />:</span> <strong><sec:authentication property="principal.employeeName"/> (<sec:authentication property="principal.username"/>)</strong></p>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-xs" style="margin-left: 20px; display: inline-block; position: relative; top: -2px;"><spring:message code="navigation.logout" /></a>
    </div>
</div>
