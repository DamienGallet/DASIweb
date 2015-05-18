<%-- 
    Document   : employe_history
    Created on : 17 mai 2015, 19:54:36
    Author     : Damien
--%>

<%@page import="predictif.metier.modele.Horoscope"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Client client = (Client)request.getAttribute("client"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employe | Historique de <%= client.getPrenom() %> <%= client.getNom() %></title>
    </head>
    <body>
        <h1>Historique des predictions</h1>
        <h2><%= client.getPrenom() %> <%= client.getNom() %></h2>
        <table>
            <header>
                <td>Date</td>
                <td>Prédiction amour</td>
                <td>Prédiction santé</td>
                <td>Prédiction travail</td>
            </header>
            <% for(Horoscope horoscope : client.getHistorique()) { %>
            <tr>
                <td></td>
                <td><%= horoscope.getAmour().getDescription() %></td>
                <td><%= horoscope.getSante().getDescription() %></td>
                <td><%= horoscope.getTravail().getDescription() %></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
