/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Damien
 */
public abstract class Action {

    public Action() {
    }
    
    public abstract boolean execute(HttpServletRequest request);
}
