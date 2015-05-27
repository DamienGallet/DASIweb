/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Medium;
import predictif.metier.service.Service;
import presentation.controleur.MainServlet;
import presentation.utilitaires.Utilitaires;

/**
 *
 * @author Damien
 */
public class ActionValidateHoro extends Action {
    @Override
    public boolean execute(HttpServletRequest request) 
    {
        //Client 
        Long client_id = (Long)request.getAttribute("client_id");
        if(client_id==-1){
            return false;
        }
        Client currentClient = Service.getClient(client_id);
        if(currentClient==null){
            return false;
        }
        
        //Medium
        String medium_id_param = request.getParameter("medium_id");
        Long medium_id;
        try {
            medium_id = Long.decode(medium_id_param);
        } catch(Exception e) {
            return false;
        }
        Medium medium = Service.getMedium(medium_id);
        if(medium==null){
            return false;
        }
        
        Map<Long,Horoscope> mapClientHoro = (Map<Long,Horoscope>)request.getSession().getAttribute("mapClientHoro");
        Horoscope currentHoro = mapClientHoro.get(client_id);
        currentHoro.setAuteur(medium);
        currentHoro.setDate(Utilitaires.getAujourdhui());
        
        Service.ajouterHoroscope(currentHoro);
        Service.ajouterHoroscopeClient(currentHoro, currentClient);
        
        request.setAttribute("currentHoro", currentHoro);
        request.setAttribute("success", "L'horoscope a bien été enregistré");
        request.setAttribute("client", currentClient);
        return true;
    }
}
