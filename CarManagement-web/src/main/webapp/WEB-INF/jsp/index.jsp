<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/resources/screen.css"/>">
    </head>

    <body>

        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
                
        <div id="content" class="container">
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
