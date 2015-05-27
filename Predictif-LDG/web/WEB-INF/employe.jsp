<%-- 
    Document   : employe
    Created on : 12 mai 2015, 13:01:30
    Author     : Damien Gallet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Inscription";
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>
        <h1>Bienvenue sur l'interface Predictif pour les employés</h1>
        <h2>Veuillez vous identifier</h2>
        <form action="employe?todo=action_login" method="POST">
            <label name='emp_id'>Numero d'employe</label>
            <input type="text" name="emp_id"/>
            
            <button class="button" type="submit">Login</button>
            <button class="button" type='reset'>Annuler</button>
        </form>
<%@ include file="footer.jsp" %>
