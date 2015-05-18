<%-- 
    Document   : employe
    Created on : 12 mai 2015, 13:01:30
    Author     : Damien Gallet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Espace employé</title>
    </head>
    <body>
        <h1>Bienvenue sur l'interface Predictif pour les employés</h1>
        <h2>Veuillez vous identifier</h2>
        <form action="employe?todo=action_login" method="POST">
            <label name='emp_id'>Numero d'employe</label>
            <input type="text" name="emp_id"/>
            
            <button type="submit">Login</button>
            <button type='reset'>Annuler</button>
        </form>
    </body>
</html>
