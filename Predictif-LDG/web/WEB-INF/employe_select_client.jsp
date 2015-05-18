<%-- 
    Document   : emplye_select_client
    Created on : 13 mai 2015, 12:26:35
    Author     : Damien
--%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employe | Selectionner client</title>
    </head>
    <body>
        <% List<Client> listeClients = (List<Client>)request.getAttribute("clients"); %>
        <h1>Selectionnez un client</h1>
        <form action="employe?todo=select_client" method="POST">
            <ul>
                <c:out value='${listeClients[0].getNom()}'/>
                <% for(Client client : listeClients) { %>
                <li><input type="radio" value="<%= client.getId() %>" name="client_id"/><%= client.getPrenom()%> <%= client.getNom()%></li>
                <% } %>
            </ul>
            <button type="submit">Login</button>
            <button type='reset'>Annuler</button>
        </form>
    </body>
</html>
