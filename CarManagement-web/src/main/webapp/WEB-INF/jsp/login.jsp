<%-- 
    Document   : login
    Created on : 28.12.2013, 16:33:16
    Author     : zvonicek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="login.login" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $('form#login').submit(function() {
                    valid = true;
                    
                    if($.trim($('#name').val()) == '') {
                        valid = false;
                        $('#name').parent().addClass('has-error');
                    } else {
                        $('#name').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#pass').val()) == '') {
                        valid = false;
                        $('#pass').parent().addClass('has-error');
                    } else {
                        $('#pass').parent().removeClass('has-error');
                    }
                    
                    if(valid) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });
        </script>
    </head>
<body onload='document.f.j_username.focus();'>
    <div class="well">
	<h1 style="margin-top: 5px;"><spring:message code="login.login" /></h1>
 
        <c:if test="${'fail' eq param.auth}">
		<div class="alert alert-danger">
                        <spring:message code="login.failure" /><br /> <spring:message code="login.cause" />:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name="f" id="login" action="<c:url value='j_spring_security_check' />" method="POST">
 
            <div class="form-group">
                <label for="name"><spring:message code="login.username" /></label>
		<input type="text" name="j_username" value="" placeholder="<spring:message code='login.username' />" id="name"  class="form-control">
            </div>
            <div class="form-group">
                <label for="pass"><spring:message code="login.password" /></label>
                <input type="password" name="j_password" placeholder="<spring:message code="login.password" />" id="pass"  class="form-control">
            </div>
            
            <hr style="border-color: #dfdfdf;">
            
            <input name="submit" type="submit" value="<spring:message code='login.submit' />" class="btn btn-primary">
 
	</form>
    </div>
</body>
</html>