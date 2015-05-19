/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.contexte;

import presentation.controleur.actions.Action;
import presentation.controleur.actions.ActionBindPrediction;
import presentation.controleur.actions.ActionHistory;
import presentation.controleur.actions.ActionLogin;
import presentation.controleur.actions.ActionLogout;
import presentation.controleur.actions.ActionPrintPrediction;
import presentation.controleur.actions.ActionSelectClient;
import presentation.controleur.actions.ActionValidateHoro;

/**
 *
 * @author Damien
 */
public class ContexteEmploye extends Contexte {

    @Override
    public Action getAction(String todo) {
        Action action;
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
        String vue="WEB-INF/";
        switch(todo) {
            case "action_login":
                vue += "employe_select_client.jsp";
                break;
            case "select_client":
                vue += "employe_horo.jsp";
                break;
            case "select_prediction":
                vue += "employe_predictions.jsp";
                break;
            case "bind_prediction":
                vue += "employe_horo.jsp";
                break;
            case "history":
                vue += "employe_history.jsp";;
                break;
            case "validate":
                vue += "employe.jsp";
                break;
            case "logout":
                vue += "employe.jsp";
                break;
            default:
                vue += "employe.jsp";
                break;
        }
        return vue;
    }
    
}
