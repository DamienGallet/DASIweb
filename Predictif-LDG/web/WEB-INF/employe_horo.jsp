<%-- 
    Document   : employe_horo
    Created on : 16 mai 2015, 20:55:12
    Author     : Damien
--%>

<%@page import="predictif.metier.modele.Employe"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page import="predictif.metier.modele.Medium"%>
<%@page import="predictif.metier.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Client client = (Client)request.getAttribute("client"); %>
<% String title = "Employé | Horoscope de " + client.getPrenom() + " " +client.getNom(); 
   request.setAttribute("title", title);
   Long emp_id = ((Employe)request.getSession().getAttribute("emp")).getId();
   String lien_retour = "/employe?todo=action_login&emp_id="+Long.toString(emp_id);%>
<%@ include file="header.jsp" %>
        <h1>Horoscope</h1>
        <h2>Prédictions</h2>
        <div class="select_type_pred">
            <p>
                <a href="employe?todo=select_prediction&type_prediction=amour&client_id=<%= request.getAttribute("client_id") %>">Amour</a><br/>
                <a href="employe?todo=select_prediction&type_prediction=travail&client_id=<%= request.getAttribute("client_id") %>">Travail</a><br/>
                <a href="employe?todo=select_prediction&type_prediction=sante&client_id=<%= request.getAttribute("client_id") %>">Santé</a>
            </p>
        </div>
        <h2>Medium</h2>
        
        <form action="employe?todo=validate&client_id=<%= request.getAttribute("client_id") %>" method="POST">
            <div class="select_type_pred">
            <select name="medium_id">
                <% for(Medium medium : client.getFavoris()) { %>
                <option value="<%= medium.getId() %>"><%= medium.getNom() %></option>
                <% } %>
            </select><br/>
            </div>
            
            <h2>Informations client</h2>
            <div class="select_type_pred">
                <a href="employe?todo=history&client_id=<%= request.getAttribute("client_id") %>">Historique</a><br/>
            </div>
            <input class="button" type="submit" value="Valider"/>
            <input class="button" type="button" value="Retour" onclick="self.location.href='<c:url value="<%=lien_retour%>" />'"/>
        </form>
       
<%@ include file="footer.jsp" %>
