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
public class ActionLogout extends Action {

    @Override
    public boolean execute(HttpServletRequest request) {
        request.getSession().setAttribute("emp", null);
        return true;
    }
    
}
