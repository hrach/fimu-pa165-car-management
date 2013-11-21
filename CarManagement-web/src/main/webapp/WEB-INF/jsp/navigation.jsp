<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/employee/" class="btn btn-default link"><spring:message code="navigation.employees" /></a>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/employee/list/"><spring:message code="navigation.employees.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/employee/add/"><spring:message code="navigation.employees.new" /></a></li>
            </ul>
        </div>
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/vehicle/" class="btn btn-default link"><spring:message code="navigation.vehicles" /></a>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/vehicle/list/"><spring:message code="navigation.vehicles.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/vehicle/add/"><spring:message code="navigation.vehicles.new" /></a></li>
            </ul>
        </div>
            
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/ride/" class="btn btn-default link"><spring:message code="navigation.rides" /></a>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/ride/list/"><spring:message code="navigation.rides.list" /></a></li>
                <li><a href="${pageContext.request.contextPath}/ride/add/"><spring:message code="navigation.rides.new" /></a></li>
            </ul>
        </div>
    </nav>
</div>