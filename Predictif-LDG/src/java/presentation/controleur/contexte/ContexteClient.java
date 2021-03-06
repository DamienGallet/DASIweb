/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.contexte;

import presentation.controleur.actions.Action;
import presentation.controleur.actions.ActionForm;
import presentation.controleur.actions.ActionRegister;

/**
 *
 * @author Damien
 */
public class ContexteClient extends Contexte {

    @Override
    public Action getAction(String todo) {
        Action action;
        switch(todo) {
            case "valid_inscr":
                action = new ActionRegister();
                break;
            default:
                action = new ActionForm();
                break;
        }
        return action;
    }

    @Override
    public String getVue(String todo, boolean success) {
        String vue="WEB-INF/";
        switch(todo) {
            case "valid_inscr":
                if(success)
                    vue += "index.jsp";
                else
                    vue += "inscriptionClient.jsp";
                break;
            default:
                vue += "inscriptionClient.jsp";
                break;
        }
        return vue;
    }
    
}
