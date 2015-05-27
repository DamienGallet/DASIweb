<%-- 
    Document   : inscriptionClient
    Created on : 10 mai 2015, 15:08:45
    Author     : tguegan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String title = "Inscription"; 
   request.setAttribute("title", title);%>
<%@ include file="header.jsp" %>

<legend>Inscription Client</legend>
<p>Vous pouvez vous inscrire via ce formulaire</p>
<form id="formInscr" method="post" action="inscriptionClient?todo=valid_inscr" onsubmit="return checkValid(this);">
    <label for="nom">Nom : </label>
    <input type="text" id="nom" name="nom" size="20" maxlength="60" onchange="checkElement(this)"/>
    <br/>

    <label for="prenom">Prénom : </label>
    <input type="text" id="prenom" name="prenom" size="20" maxlength="60" onchange="checkElement(this)"/>
    <br/>

    <label for="civilite" onchange="checkElement(this)">Civilité : </label>
    <input type="radio" name="civilite" value="M" id="M" checked>M.
    <input type="radio" name="civilite" value="Mlle" id="Mlle">Mlle.
    <input type="radio" name="civilite" value="Mme" id="Mme">Mme.
    <br/>

    <label for="naissance" onchange="checkElement(this)">Date de naissance : </label>
    <input type="date" max="2000-01-01" min="1990-01-01" name="naissance">
    <br/>

    <label for="adresse" onchange="checkElement(this)">Adresse postale : </label>
    <input type="text" id="adresse" name="adresse" size="20" max="60"/>
    <br/>

    <label for="telephone" onchange="checkElement(this)">Téléphone : </label>
    <input type="tel" name="telephone" id="telephone">
    <br/>

    <label for="mail" onchange="checkElement(this)">Adresse électronique : </label>
    <input type="email" id="mail" name="mail" size="20" max="60"/>
    <br/>

    <label for="medium">Medium : </label>

    <%@ include file="listeMedium.jsp" %>
    <br/>

    <input type="reset" class="button" value="TOUT EFFACER"/>

    <input type="submit" class="button" name="inscrit" value="VALIDER" class="sansLabel"/>

    <br />
</form>

<%@ include file="footer.jsp" %>    
