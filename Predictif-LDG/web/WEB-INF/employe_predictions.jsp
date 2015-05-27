<%-- 
    Document   : employe_predictions
    Created on : 17 mai 2015, 10:48:35
    Author     : Damien
--%>

<%@page import="java.util.List"%>
<%@page import="predictif.metier.modele.Prediction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Employé | Prédictions";
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>

        <% List<Prediction> predictions = (List<Prediction>)request.getAttribute("predictions"); 
           long previousPredId = 0;
           previousPredId = (Long)request.getAttribute("id_previous_prediction");%>
        <h1>Prédictions <%= request.getParameter("type_prediction") %></h1>
        <p>
        <form action="employe?todo=bind_prediction&client_id=<%= request.getAttribute("client_id")%>&type_prediction=<%= request.getParameter("type_prediction") %>" method="POST">
        <table>
            <% for(Prediction prediction : predictions) { %>
            <tr>
                <% String checked = "";
                if(previousPredId==prediction.getId()){checked="checked";} %>
                <td><input type="radio" name="prediction_id" value="<%= prediction.getId() %>" <%= checked %>/></td>
                <td><%= prediction.getForce() %></td>
                <td><%= prediction.getDescription() %></td>
            </tr>
            <% } %>
        </table>
        <input class="button"  type="submit" value="Valider"/>
        <input class="button"  type="reset" value="Annuler"/>
        </form>
        </p>
<%@ include file="footer.jsp" %>
