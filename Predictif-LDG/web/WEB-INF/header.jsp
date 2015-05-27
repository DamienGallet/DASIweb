<%-- 
    Document   : header
    Created on : 21 mai 2015, 10:50:15
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%  String error = (String)request.getAttribute("error"); 
    String success = (String)request.getAttribute("success"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/formInscription.css" />" />
        <script type="text/javascript" src="<c:url value="/js/formInscr.js" />"></script>
        <title><%= request.getAttribute("title") %></title>
    </head>
    <body>
        <div class="main_content">
        <c:if test='${error!=null}'>
            <div class="error single">
                <h3>Erreur</h3>
                <p><c:out value='${error}'/></p>
            </div>
        </c:if>
        <c:if test='${success!=null}'>
            <div class="success single">
                <h3>Bravo !</h3>
                <p><c:out value='${success}'/></p>
            </div>
        </c:if>
        
        

