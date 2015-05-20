<%-- 
    Document   : listeMedium
    Created on : 11 mai 2015, 16:03:12
    Author     : tguegan
--%>

<%@page import="predictif.metier.modele.Medium"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="formInscription.css" />
    </head>
    <body>
            <% java.util.Vector<Medium> z = (java.util.Vector) request.getAttribute("mediums");%>
            <select name="listeDesMediums" size="1">
                <%for (int j = 0; j < z.size(); j++) {
                        Medium m = (Medium) z.get(j);
                %>
                <option value=<%=m.getId() %>><%out.println(m.getNom()); %></option>
                    <%}%>
            </select>
    </body>
</html>
