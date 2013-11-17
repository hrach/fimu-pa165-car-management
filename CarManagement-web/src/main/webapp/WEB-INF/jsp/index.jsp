<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>

        <div id="content">
                <h3><spring:message code="home" /></h3>
                <table>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td><c:out value="${vacation.destination}" /></td>
                        <td><c:out value="${vacation.startDate}" /></td>
                        <td><c:out value="${vacation.endDate}" /></td>
                        <td><c:out value="${vacation.price}" /></td>
                        <td><c:out value="${vacation.reserved}" /> / <c:out value="${vacation.maxCapacity}" /></td>
                        <td>
                           s
                        </td>
                        </tr>
                    </c:forEach>
                </table>
          </div>   
                      
    </body>
</html>
