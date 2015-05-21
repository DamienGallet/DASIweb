<%-- 
    Document   : header
    Created on : 21 mai 2015, 10:50:15
    Author     : Damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/formInscription.css" />" />
        <script type="text/javascript" src="<c:url value="/js/formInscr.js" />"></script>
        <title><%= request.getAttribute("title") %></title>
    </head>
    <body>

