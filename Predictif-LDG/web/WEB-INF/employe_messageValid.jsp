<%-- 
    Document   : employe_messageValid
    Created on : 16 mai 2015, 20:55:12
    Author     : Damien
--%>

<%@page import="predictif.metier.modele.Horoscope"%>
<%@page import="predictif.metier.modele.Employe"%>
<%@page import="predictif.metier.modele.Client"%>
<%@page import="predictif.metier.modele.Medium"%>
<%@page import="predictif.metier.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Client client = (Client)request.getAttribute("client"); %>
<% String title = "Employé | Validation pour " + client.getPrenom() + " " +client.getNom(); 
   request.setAttribute("title", title);
   Long emp_id = ((Employe)request.getSession().getAttribute("emp")).getId();
   String lien_retour = "/employe?todo=action_login&emp_id="+Long.toString(emp_id);
   Horoscope horo = (Horoscope)request.getAttribute("currentHoro"); %>
<%@ include file="header.jsp" %>
        <h1>Apercu du message envoyé à <%= client.getPrenom() %> <%= client.getNom() %></h1>
            
            <p>
            <h2>
                Horoscope du jour, <%= client.getPrenom() %> <%= client.getNom() %>
            </h2>
            <h3>
                Votre prédiction amour :
            </h3>
                <%= horo.getAmour().getDescription() %><br/>
                Notre conseil : 
                <%= horo.getAmour().getConseil() %><br/>
            <h3>   
                Votre prédiction travail : </h3>
            <%= horo.getTravail().getDescription() %><br/>
            Notre conseil : 
                <%= horo.getTravail().getConseil() %><br/>
                
            <h3> Votre prédiction santé : </h3>
            <%= horo.getSante().getDescription() %><br/>
            Notre conseil : 
                <%= horo.getSante().getConseil() %><br/>
                
                <h3>En vous remerciant pour votre confiance et patati et patata<br/>
                <%= horo.getAuteur().getNom() %><br/></h3>
                
            </p>
        </div>
        <input class="button" type="button" value="Suivant" onclick="self.location.href='<c:url value="<%=lien_retour%>" />'"/>
       
<%@ include file="footer.jsp" %>