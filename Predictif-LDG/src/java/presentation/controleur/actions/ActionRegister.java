/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;
import predictif.metier.modele.SigneAstro;
import predictif.metier.service.Service;
import predictif.presentation.controleur.ServletInscription;

/**
 *
 * @author Damien
 */
public class ActionRegister extends Action{

    public static final String VUE = "/WEB-INF/inscriptionClient.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String RADIO_CIVILITE = "civilite";
    public static final String CHAMP_NAISSANCE = "naissance";
    public static final String CHAMP_ADRESSE = "adresse";
    public static final String CHAMP_TELEPHONE = "telephone";
    public static final String CHAMP_MAIL = "mail";
    public static final String OPTION_MEDIUM = "listeDesMediums";
    
    @Override
    public boolean execute(HttpServletRequest request) {
        System.out.println("########### INSCRIPTION CLIENT ###########");
        String nom = request.getParameter(CHAMP_NOM);
        String prenom = request.getParameter(CHAMP_PRENOM);
        String civilite = request.getParameter(RADIO_CIVILITE);
        String naissance = request.getParameter(CHAMP_NAISSANCE);
        String adresse = request.getParameter(CHAMP_ADRESSE);
        String telephone = request.getParameter(CHAMP_TELEPHONE);
        String mail = request.getParameter(CHAMP_MAIL);
        String medium = request.getParameter(OPTION_MEDIUM);
        if(nom==null || prenom==null || civilite==null || naissance==null || adresse==null || telephone==null || mail==null || medium==null) {
            return false;
        }

        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(naissance);
        } catch (ParseException ex) {
            return false;
        }
        String coupe = naissance.substring(3, 5);
        SigneAstro signe = new SigneAstro(coupe);
        Service.ajouterSigneAstro(signe);
        Medium m = Service.getMedium(Long.parseLong(medium));
        if(m==null){
            return false;
        }
        
        Client nouveauClient = new Client(nom, prenom, date, civilite, adresse, telephone, mail, signe);
        Service.ajouterClient(nouveauClient);
        Service.ajouterMediumClient(m, nouveauClient);
        return true;
    }
    
}
