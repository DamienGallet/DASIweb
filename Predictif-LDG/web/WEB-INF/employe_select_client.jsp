<%-- 
    Document   : emplye_select_client
    Created on : 13 mai 2015, 12:26:35
    Author     : Damien
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Employé | Selectionner client";
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>

        <% List<Client> listeClients = (List<Client>)request.getAttribute("clients"); %>
        <h1>Selectionnez un client</h1>
        <form action="employe?todo=select_client" method="POST">
            <ul>
                <c:out value='${listeClients[0].getNom()}'/>
                <% for(Client client : listeClients) { %>
                <li><input type="radio" value="<%= client.getId() %>" name="client_id"/><%= client.getPrenom()%> <%= client.getNom()%></li>
                <% } %>
            </ul>
            <button class="button"  type="submit">Valider</button>
            <button class="button" type='reset'>Annuler</button>
        </form>
<%@ include file="footer.jsp" %>
