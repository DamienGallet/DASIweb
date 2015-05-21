<%-- 
    Document   : error
    Created on : 20 mai 2015, 23:19:34
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String title = "BOOOMMP"; %>
<%@include file="header.jsp"  %>
<% request.setAttribute("title", title);%>
<h1>An error has occured</h1>
<%@ include file="footer.jsp" %>
