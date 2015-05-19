/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Prediction;
import predictif.metier.service.Service;
import presentation.utilitaires.Utilitaires;

/**
 *
 * @author Damien
 */
public class ActionPrintPrediction extends Action {

    @Override
    public boolean execute(HttpServletRequest request) {
        Long client_id = (Long)request.getAttribute("client_id");
        if(client_id==-1) {
            return false;
        }
        
        String prediction_type_param = request.getParameter("type_prediction");
        int prediction_type = Utilitaires.typePredictionIntFromString(prediction_type_param);

        //On regarde si, pour ce type de prediction, l'horscope n'est deja pas rempli
        Map<Long,Horoscope> mapClientHoro = (Map<Long,Horoscope>)request.getSession().getAttribute("mapClientHoro");
        Horoscope currentHoro = mapClientHoro.get(client_id);
        long id_prediction = 0;
        switch(prediction_type_param)
        {
            case "amour":
                if(currentHoro.getAmour()!=null)
                    id_prediction = currentHoro.getAmour().getId();
                break;
            case "sante":
                if(currentHoro.getSante()!=null)
                    id_prediction = currentHoro.getSante().getId();
                break;
            case "travail":
                if(currentHoro.getTravail()!=null)
                    id_prediction = currentHoro.getTravail().getId();
                break;
            default:
                return false;
        }


        List<Prediction> predictions;
        //TODO: GET ALL PREDICTIONS !!!!!!
        predictions = Service.getPredictions(1, prediction_type);
        
        request.setAttribute("predictions", predictions);
        request.setAttribute("client_id", client_id);
        request.setAttribute("prediction_type", prediction_type_param);
        request.setAttribute("id_previous_prediction", id_prediction);
        return true;
    }
    
}
