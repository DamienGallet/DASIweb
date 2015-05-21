/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Client;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.PAmour;
import predictif.metier.modele.PSante;
import predictif.metier.modele.PTravail;
import predictif.metier.modele.Prediction;
import predictif.metier.service.Service;

/**
 *
 * @author Damien 
 */
public class ActionBindPrediction extends Action {
    @Override
    public boolean execute(HttpServletRequest request) 
    {
        String prediction_id_param = request.getParameter("prediction_id");
        String prediction_type_param = request.getParameter("type_prediction");
        Long client_id = (Long)request.getAttribute("client_id");
        if(client_id==-1) {
            return false;
        }
        
        Long prediction_id;
        try {
            prediction_id = Long.decode(prediction_id_param);
        } catch(Exception e) {
            return false;
        }

        Map<Long,Horoscope> mapClientHoro = (Map<Long,Horoscope>)request.getSession().getAttribute("mapClientHoro");
        Horoscope currentHoro = mapClientHoro.get(client_id);
        request.setAttribute("client_id", client_id);
        Prediction currentPred = Service.getPrediction(prediction_id);
        if(currentPred==null)
        {
            return false;
        }
        
        switch(prediction_type_param)
        {
            case "amour":
                currentHoro.setAmour((PAmour)currentPred);
                break;
            case "sante":
                currentHoro.setSante((PSante)currentPred);
                break;
            case "travail":
                currentHoro.setTravail((PTravail)currentPred);
                break;
            default :
                return false;
        }
        Client client = Service.getClient(client_id);
        if(client==null)
        {return false;}
        request.setAttribute("client",client);
        
        return true;
    }
}
