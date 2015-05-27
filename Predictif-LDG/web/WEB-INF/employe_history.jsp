<%-- 
    Document   : employe_history
    Created on : 17 mai 2015, 19:54:36
    Author     : Damien
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="predictif.metier.modele.Horoscope"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Client client = (Client)request.getAttribute("client"); %>
<% String title = "Employé | Historique de " + client.getPrenom() + " " +client.getNom(); 
   request.setAttribute("title", title);
   SimpleDateFormat formater = null;
   formater = new SimpleDateFormat("dd/MM/yy"); %>
<%@ include file="header.jsp" %>
        <title>Employe | Historique de <%= client.getPrenom() %> <%= client.getNom() %></title>
    </head>
    <body>
        <h1>Historique des predictions</h1>
        <h2><%= client.getPrenom() %> <%= client.getNom() %></h2>
        <table>
            <thead>
                <td>Date</td>
                <td>Prédiction amour</td>
                <td>Prédiction santé</td>
                <td>Prédiction travail</td>
            </thead>
            <tbody>
            <% for(Horoscope horoscope : client.getHistorique()) { %>
            <tr>
                <% Date dateHoro = horoscope.getDate(); if(dateHoro==null){dateHoro = new Date();} %>
                <td><%= formater.format(dateHoro) %></td>
                <td><%= horoscope.getAmour().getDescription() %></td>
                <td><%= horoscope.getSante().getDescription() %></td>
                <td><%= horoscope.getTravail().getDescription() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
<%@ include file="footer.jsp" %>
