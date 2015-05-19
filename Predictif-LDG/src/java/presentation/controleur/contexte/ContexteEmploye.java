/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.contexte;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Medium;
import predictif.metier.modele.PAmour;
import predictif.metier.modele.PSante;
import predictif.metier.modele.PTravail;
import predictif.metier.modele.Prediction;
import predictif.metier.service.Service;
import presentation.controleur.MainServlet;
import presentation.controleur.actions.Action;
import presentation.controleur.actions.ActionBindPrediction;
import presentation.controleur.actions.ActionHistory;
import presentation.controleur.actions.ActionLogin;
import presentation.controleur.actions.ActionLogout;
import presentation.controleur.actions.ActionPrintPrediction;
import presentation.controleur.actions.ActionSelectClient;
import presentation.controleur.actions.ActionValidateHoro;
import presentation.utilitaires.Utilitaires;

/**
 *
 * @author Damien
 */
public class ContexteEmploye extends Contexte {

    @Override
    public Action getAction(String todo) {
        Action action = null;
        switch(todo) {
            case "action_login":
                action = new ActionLogin();
                break;
            case "select_client":
                action = new ActionSelectClient();
                break;
            case "select_prediction":
                action = new ActionPrintPrediction();
                break;
            case "bind_prediction":
                action = new ActionBindPrediction();
                break;
            case "history":
                action = new ActionHistory();
                break;
            case "validate":
                action = new ActionValidateHoro();
                break;
            case "logout":
                action = new ActionLogout();
                break;
            default:
                action = null;
                break;
        }
        
        return action;
    }

    @Override
    public String getVue(String todo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
