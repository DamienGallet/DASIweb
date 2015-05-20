<%-- 
    Document   : inscriptionClient
    Created on : 10 mai 2015, 15:08:45
    Author     : tguegan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="formInscription.css" />
    </head>
    <body>

    <legend>Inscription Client</legend>
    <p>Vous pouvez vous inscrire via ce formulaire</p>
    <form method="post" action="inscriptionClient?todo=valid_inscr" onsubmit="openValid();">
        <label for="nom">Nom : </label>
        <input type="text" id="nom" name="nom" size="20" maxlength="60"/>
        <br/>

        <label for="prenom">Prénom : </label>
        <input type="text" id="prenom" name="prenom" size="20" maxlength="60"/>
        <br/>

        <label for="civilite">Civilité : </label>
        <input type="radio" name="civilite" value="M" id="M" checked>M.
        <input type="radio" name="civilite" value="Mlle" id="Mlle">Mlle.
        <input type="radio" name="civilite" value="Mme" id="Mme">Mme.
        <br/>

        <label for="naissance">Date de naissance : </label>
        <input type="date" max="2000-01-01" min="1990-01-01" name="naissance">
        <br/>

        <label for="adresse">Adresse postale : </label>
        <input type="text" id="adresse" name="adresse" size="20" max="60"/>
        <br/>

        <label for="telephone">Téléphone : </label>
        <input type="tel" name="telephone" id="telephone">
        <br/>

        <label for="mail">Adresse électronique : </label>
        <input type="email" id="mail" name="mail" size="20" max="60"/>
        <br/>

        <label for="medium">Medium : </label>

        <%@ include file="listeMedium.jsp" %>
        <br/>

        <input type="reset" value="TOUT EFFACER"/>

        <input type="submit" name="inscrit" value="VALIDER" class="sansLabel"/>

        <br />
    </form>

    <script>
        function openValid()
        {
            alert("Inscription valide !");
        }
    </script>
</body>
</html>
