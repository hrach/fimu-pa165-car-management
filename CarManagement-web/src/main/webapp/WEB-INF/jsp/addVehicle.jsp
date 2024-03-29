<%-- 
    Document   : editVehicle
    Created on : 20.11.2013, 02:33:02
    Author     : Jakub Marecek <xmarec at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="vehicle.add" /></title>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />
        
        <script>
            $(function() {
                $( ".datepicker" ).datepicker({
                    dateFormat: "yy",
                    dayNamesMin: [ '<spring:message code="days.short.su" />','<spring:message code="days.short.mo" />','<spring:message code="days.short.tu" />','<spring:message code="days.short.we" />','<spring:message code="days.short.th" />','<spring:message code="days.short.fr" />','<spring:message code="days.short.sa" />' ],
                    monthNames: [ '<spring:message code="months.long.jan" />', '<spring:message code="months.long.feb" />','<spring:message code="months.long.mar" />','<spring:message code="months.long.apr" />','<spring:message code="months.long.may" />','<spring:message code="months.long.jun" />','<spring:message code="months.long.jul" />','<spring:message code="months.long.aug" />','<spring:message code="months.long.sep" />','<spring:message code="months.long.oct" />','<spring:message code="months.long.nov" />','<spring:message code="months.long.dec" />' ],
                    firstDay: 1,
                    changeYear: true,
            yearRange: "-100:+0"
                }
                    );
            });
            </script>
        
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/jsp/navigation.jsp" />
        
        <div class="container">
            <div class="page-header">
                <h1><spring:message code="vehicle.add" /></h1>
            </div>

            <form:form cssClass="form-horizontal" method="POST" modelAttribute="newVehicle" action="${pageContext.request.contextPath}/admin/vehicle/add">  
                <c:set var="hasError"><form:errors path="name"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-name" class="col-sm-2 control-label"><spring:message code="vehicle.name" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="name" id="input-name" cssClass="form-control"></form:input>
                        <form:errors path="name" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>
                
                <c:set var="hasError"><form:errors path="constructionYear"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-constructionyear" class="col-sm-2 control-label"><spring:message code="vehicle.constructionyear" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="constructionYear" id="input-constructionyear" cssClass="form-control datepicker"></form:input>
                        <form:errors path="constructionYear" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>    

                <c:set var="hasError"><form:errors path="VIN"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-VIN" class="col-sm-2 control-label"><spring:message code="vehicle.VIN" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="VIN" id="input-VIN" cssClass="form-control"></form:input>
                        <form:errors path="VIN" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>  

                <c:set var="hasError"><form:errors path="registrationPlate"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-registrationPlate" class="col-sm-2 control-label"><spring:message code="vehicle.registrationPlate" />:</label>  
                    <div class="col-sm-10">
                        <form:input path="registrationPlate" id="input-registrationPlate" cssClass="form-control"></form:input>
                        <form:errors path="registrationPlate" cssClass="help-block"></form:errors>                                                
                    </div> 
                </div>  

               <c:set var="hasError"><form:errors path="fuel"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">
                    <label for="input-fuel" class="col-sm-2 control-label"><spring:message code="vehicle.fuel" />:</label>
                    <div class="col-sm-10">
                        <form:select path="fuel" id="input-fuel" cssClass="form-control">
                            <option value="0" selected="selected">-- <spring:message code="vehicle.select.fuel" /></option>
                            <option value="1" ${target.fuel == 1 ? 'selected="selected"' : ''}><spring:message code="vehicle.fuel.gas" /></option>
                            <option value="2" ${vehicle.fuel == 2 ? 'selected="selected"' : ''}><spring:message code="vehicle.fuel.oil" /></option>
                            <option value="3" ${vehicle.fuel == 3 ? 'selected="selected"' : ''}><spring:message code="vehicle.fuel.cng" /></option>
                            <option value="4" ${vehicle.fuel == 4 ? 'selected="selected"' : ''}><spring:message code="vehicle.fuel.lpg" /></option>
                            <option value="5" ${vehicle.fuel == 5 ? 'selected="selected"' : ''}><spring:message code="vehicle.fuel.electric" /></option>
                        </form:select>
                        <form:errors path="fuel" cssClass="help-block"></form:errors>                            
                    </div>
                </div> 
                    
                <c:set var="hasError"><form:errors path="tachometer"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-tachometer" class="col-sm-2 control-label"><spring:message code="vehicle.tachometer" />:</label>
                    <div class="col-sm-10">
                        <form:input path="tachometer" id="input-tachometer" cssClass="form-control"></form:input>
                        <form:errors path="tachometer" cssClass="help-block"></form:errors>                                                
                    </div>  
                </div>
                <c:set var="hasError"><form:errors path="type.id"/></c:set>
                <div class="form-group <c:out value="${not empty hasError ? 'has-error': ''}"/>">                
                    <label for="input-type" class="col-sm-2 control-label"><spring:message code="vehicle.type" />:</label>
                    <div class="col-sm-10">
                        <form:select path="type.id" id="input-type" cssClass="form-control">
                            <form:options items="${vehicleTypes}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:errors path="type.id" cssClass="help-block"></form:errors>                                                
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success"><spring:message code="changes.save" /></button>
                        <a href="${pageContext.request.contextPath}/admin/vehicle/" class="btn btn-warning"><spring:message code="cancel" /></a>
                    </div>
                </div>    
            </form:form>  
        </div>
    </body>
</html>
