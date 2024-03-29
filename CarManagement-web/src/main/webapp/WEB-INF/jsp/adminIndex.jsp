<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
            
            <h3><spring:message code="employees.search" /></h3>
            <nav class="navbar navbar-default" role="navigation">
               <div class="navbar-header">
                   <a class="navbar-brand"><spring:message code="employee.find" /></a>
               </div>
               <form class="navbar-form navbar-left" role="search">
                   <div class="form-group">
                        <input type="text" class="form-control typeahead" placeholder="<spring:message code="search" />" id="employeeSearch">
                   </div>
                   <%--<button type="submit" class="btn btn-default">Submit</button>--%>
               </form>
           </nav>
           
           <h3><spring:message code="vehilces.search" /></h3>
           <nav class="navbar navbar-default" role="navigation">
               <div class="navbar-header">
                   <a class="navbar-brand"><spring:message code="vehicle.find" /></a>
               </div>
               <form class="navbar-form navbar-left" role="search">
                   <div class="form-group">
                        <input type="text" class="form-control typeahead" placeholder="<spring:message code="search" />" id="vehicleSearch">
                   </div>
               </form>
           </nav>
          
                   <div class="row">
                       <div class="col-md-4">
                           <ul class="list-group">
                                <li class="list-group-item">
                                    <span class="badge">14</span>
                                        Vehicles in DB
                                </li>
                                <li class="list-group-item">
                                  <span class="badge">2</span>
                                        Employees in DB
                                </li>
                                <li class="list-group-item">
                                  <span class="badge">1</span>
                                        Rides in DB
                                </li>
                            </ul>
                       </div>
                   </div>
                   
          </div>   
                      
    </body>
</html>
