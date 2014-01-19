<%-- 
    Document   : addVehicle
    Created on : 12.12.2013, 15:38:05
    Author     : tomasbobek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Management SOAP Client</title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $('form#addVeh').submit(function() {
                    valid = true;
                    
                    if($.trim($('#input-name').val()) == '') {
                        valid = false;
                        $('#input-name').parent().addClass('has-error');
                    } else {
                        $('#input-name').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-tachometer').val()) == '') {
                        valid = false;
                        $('#input-tachometer').parent().addClass('has-error');
                    } else {
                        $('#input-tachometer').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-vin').val()) == '') {
                        valid = false;
                        $('#input-vin').parent().addClass('has-error');
                    } else {
                        $('#input-vin').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-spz').val()) == '') {
                        valid = false;
                        $('#input-spz').parent().addClass('has-error');
                    } else {
                        $('#input-spz').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-year').val()) == '') {
                        valid = false;
                        $('#input-year').parent().addClass('has-error');
                    } else {
                        $('#input-year').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-fuel').val()) == '0') {
                        valid = false;
                        $('#input-fuel').parent().addClass('has-error');
                    } else {
                        $('#input-fuel').parent().removeClass('has-error');
                    }
                    
                    if($.trim($('#input-type').val()) == '') {
                        valid = false;
                        $('#input-type').parent().addClass('has-error');
                    } else {
                        $('#input-type').parent().removeClass('has-error');
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

    <body>
        <div class="navigation-container">
            <nav class="navbar navbar-inverse" role="navigation">
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Car Management SOAP Client</a>
            </nav>
        </div>
        <div id="content" class="container">
            <div class="page-header">
                <h1>Add Vehicle</h1>
            </div>

            <form:form cssClass="form-horizontal" id="addVeh" method="POST" modelAttribute="newVehicle" action="${pageContext.request.contextPath}/vehicle/add">  
                <div class="form-group">                
                    <label for="input-name" class="col-sm-2 control-label">Name:</label>  
                    <div class="col-sm-10">
                        <form:input path="name" id="input-name" cssClass="form-control"></form:input>                                               
                    </div> 
                </div>
                    
                <div class="form-group">                
                    <label for="input-year" class="col-sm-2 control-label">Construction year:</label>
                    <div class="col-sm-10">
                        <form:input path="constructionYear" id="input-year" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">                
                    <label for="input-vin" class="col-sm-2 control-label">VIN:</label>
                    <div class="col-sm-10">
                        <form:input path="VIN" id="input-vin" cssClass="form-control"></form:input>
                    </div>  
                </div>
          
                <div class="form-group">                
                    <label for="input-spz" class="col-sm-2 control-label">License plate:</label>
                    <div class="col-sm-10">
                        <form:input path="registrationPlate" id="input-spz" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">
                    <label for="input-fuel" class="col-sm-2 control-label">Fuel:</label>
                    <div class="col-sm-10">
                        <form:select path="fuel" id="input-fuel" cssClass="form-control">
                            <option value="0" selected="selected">-- Select fuel type</option>
                            <option value="1" ${vehicle.fuel == 1 ? 'selected="selected"' : ''}>Gas</option>
                            <option value="2" ${vehicle.fuel == 2 ? 'selected="selected"' : ''}>Oil</option>
                            <option value="3" ${vehicle.fuel == 3 ? 'selected="selected"' : ''}>CNG</option>
                            <option value="4" ${vehicle.fuel == 4 ? 'selected="selected"' : ''}>LPG</option>
                            <option value="5" ${vehicle.fuel == 5 ? 'selected="selected"' : ''}>Electicity</option>
                        </form:select>                           
                    </div>
                </div>
                    
                <div class="form-group">                
                    <label for="input-tachometer" class="col-sm-2 control-label">Tachometer:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometer" id="input-tachometer" cssClass="form-control"></form:input>
                    </div>  
                </div>
                    
                <div class="form-group">                
                    <label for="input-type" class="col-sm-2 control-label">Type:</label>
                    <div class="col-sm-10">
                        <form:select path="type.id" id="input-type" cssClass="form-control">
                            <form:options items="${vehicleTypes}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                    
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">Save</button>
                        <a href="${pageContext.request.contextPath}/index.htm" class="btn btn-warning">Cancel</a>
                    </div>
                </div>    
            </form:form>
        </div>
    </body>
</html>