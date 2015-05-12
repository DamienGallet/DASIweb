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
        <form method="post" action="inscriptionClient">
            <fieldset>
                <legend>Inscription Client</legend>
                <p>Vous pouvez vous inscrire via ce formulaire</p>
                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" size="20" maxlength="60"/>
                <br/>
                
                <label for="prénom">Prénom<span class="requis">*</span></label>
                <input type="text" id="prénom" name="prénom" size="20" maxlength="60"/>
                <br/>
                
                <label for="mail">Adresse mail<span class="requis">*</span></label>
                <input type="text" id="mail" name="mail" size="20" max="60"/>
                <br/>
                
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
            </fieldset>
        </form>
    </body>
</html>
