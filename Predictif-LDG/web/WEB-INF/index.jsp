<%-- 
    Document   : index
    Created on : 9 mai 2015, 15:48:27
    Author     : tguegan
--%>
<%@page import="predictif.metier.modele.Medium"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Page principale"; 
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>

        <h1>Bienvenue chez Predictif !</h1>
        <p>
            Nous ne pouvons absolument rien faire pour vous pour le moment !
        </p>
        <p>
            <h2><a href="<c:url value="/employe"/>">Espace employé</a></h2>
            <h2><a href="<c:url value="/inscriptionClient"/>">Inscription client</a></h2>
        </p>
<%@ include file="footer.jsp" %>