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
import predictif.metier.service.Service;

/**
 *
 * @author Damien
 */
public class ActionSelectClient extends Action {
    @Override
    public boolean execute(HttpServletRequest request) 
    {
        Long client_id = (Long)request.getAttribute("client_id");
        if(client_id==-1) {
            return false;
        }
        Map<Long,Horoscope> mapClientHoro = (Map<Long,Horoscope>) request.getSession().getAttribute("mapClientHoro");
        Horoscope currentHoro = mapClientHoro.get(client_id);
        request.setAttribute("currentHoro", currentHoro);
        request.setAttribute("client_id", client_id);
        Client client = Service.getClient(client_id);
        if(client==null)
        {return false;}
        request.setAttribute("client",client);
        return true;
    }
}
