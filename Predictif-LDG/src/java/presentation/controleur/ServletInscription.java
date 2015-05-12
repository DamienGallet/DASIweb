/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.service.Service;
import predictif.vue.Main;

/**
 *
 * @author tguegan
 */
public class ServletInscription extends HttpServlet {
    public static final String VUE = "/WEB-INF/inscriptionClient.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prénom";
    public static final String CHAMP_MAIL = "mail";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String nom = request.getParameter(CHAMP_NOM);
        String prenom = request.getParameter(CHAMP_PRENOM);
        String mail = request.getParameter(CHAMP_MAIL);
        try {
            Main.initialiser();
        } catch (ParseException ex) {
            Logger.getLogger(ServletInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        Client nouveauClient = new Client(nom,prenom,null,null,null,null,mail,null);
        Service.ajouterClient(nouveauClient);
    }
}
