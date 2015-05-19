/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Client;
import predictif.metier.service.Service;

/**
 *
 * @author Damien
 */
public class ActionHistory extends Action {

    @Override
    public boolean execute(HttpServletRequest request) {
        Long client_id = (Long)request.getAttribute("client_id");
        if(client_id==-1){
            return false;
        }
        Client currentClient = Service.getClient(client_id);
        request.setAttribute("client",currentClient);
        return true;
    }
    
}
