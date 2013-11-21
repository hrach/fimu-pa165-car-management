<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="navigation-container">
    <nav class="navbar navbar-inverse" role="navigation">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"><spring:message code="home" /></a>
        <%--<h4><spring:message code="outside" /></h4>--%>
        <div class="collapse navbar-collapse">
            <ul class="nav nav-navbar">
                <li><a href="${pageContext.request.contextPath}/ride/" ><spring:message code="navigation.rides" /></a></li>
                <li><a href="${pageContext.request.contextPath}/vehicle/"><spring:message code="navigation.vehicles" /></a></li>
                <li><a href="${pageContext.request.contextPath}/employee/"><spring:message code="navigation.employees" /></a></li>
            </ul>
        </div>
    </nav>
</div>