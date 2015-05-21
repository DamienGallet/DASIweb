<%-- 
    Document   : client_registerSuccess
    Created on : 20 mai 2015, 23:00:21
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Inscription"; 
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription | Succes</title>
    </head>
    <body>
        <h1>Bravo, vous avez réussi à vous inscrire ! </h1>
<%@ include file="footer.jsp" %>
