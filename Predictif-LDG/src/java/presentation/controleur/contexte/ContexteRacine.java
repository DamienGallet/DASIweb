/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.contexte;

import presentation.controleur.actions.Action;

/**
 *
 * @author Damien
 */
public class ContexteRacine extends Contexte{

    @Override
    public Action getAction(String todo) {
        return null;
    }

    @Override
    public String getVue(String todo, boolean success) {
        return "WEB-INF/index.jsp";
    }
    
}
