<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $("#employeeSearch").typeahead({
                    name: "employees",
                    valueKey: "name",
                    remote: "${pageContext.request.contextPath}/employee/search/%QUERY",
                    template: "<a href=\"/pa165/overview/employee/{{id}}\">{{name}}</p>",
                    engine: Hogan,
                    limit: 5
                });
                
                $("#vehicleSearch").typeahead({
                    name: "vehicles",
                    valueKey: "name",
                    remote: "${pageContext.request.contextPath}/vehicle/search/%QUERY",
                    template: "<a href=\"/pa165/overview/vehicle/{{id}}\">{{name}}</p>",
                    engine: Hogan,
                    limit: 5
                });
            });
        </script>
    </head>

    <body>

        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
                
        <div id="content" class="container">
            
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
                   <%--<button type="submit" class="btn btn-default">Submit</button>--%>
               </form>
           </nav>
            
                <table>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td><c:out value="${item.id}" /></td>
                            <td><c:out value="${item.maxKm}" /></td>
                        </tr>
                    </c:forEach>
                </table>
          </div>   
                      
    </body>
</html>
