<%-- 
    Document   : employe_horo
    Created on : 16 mai 2015, 20:55:12
    Author     : Damien
--%>

<%@page import="predictif.metier.modele.Medium"%>
<%@page import="predictif.metier.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employé | Créer horoscope</title>
    </head>
    <body>
        <h1>Horoscope</h1>
        <h2>Prédictions</h2>
        <p>
            <a href="employe?todo=select_prediction&type_prediction=amour&client_id=<%= request.getAttribute("client_id") %>">Amour</a>
            <a href="employe?todo=select_prediction&type_prediction=travail&client_id=<%= request.getAttribute("client_id") %>">Travail</a>
            <a href="employe?todo=select_prediction&type_prediction=sante&client_id=<%= request.getAttribute("client_id") %>">Santé</a>
        </p>
        <h2>Medium</h2>
        <form action="employe?todo=validate&client_id=<%= request.getAttribute("client_id") %>" method="POST">
            <select name="medium_id">
                <% for(Medium medium : Service.getMediums()) { %>
                <option value="<%= medium.getId() %>"><%= medium.getNom() %></option>
                <% } %>
            </select>
            <a href="employe?todo=history&client_id=<%= request.getAttribute("client_id") %>">Historique</a>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
