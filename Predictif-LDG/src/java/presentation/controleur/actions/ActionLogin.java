/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.service.Service;

/**
 *
 * @author Damien
 */
public class ActionLogin extends Action {

    @Override
    public boolean execute(HttpServletRequest request) 
    {
        HttpSession session = request.getSession();
        long emp_id;
        String emp_id_param = request.getParameter("emp_id");
        if(emp_id_param == null)
            //L'employe n'a pas cherche a s'identifier
            return false;

        try {
            emp_id = Long.decode(emp_id_param);
        } catch (Exception e) {
            //TODO
            return false;
        }
        Employe emp;
        try {
            emp = Service.getEmploye(emp_id);
        } catch(Exception e) {
            //TODO
            return false;
        }
        if(emp==null)
            return false;
        session.setAttribute("emp", emp);
        
        
        // Definition d'un tableau persistant conservant les horoscopes
        Map<Long,Horoscope> mapClientHoro = new TreeMap<Long,Horoscope>();
        Map<Long,Client> mapClients = new TreeMap<Long,Client>();
        List<Client> listeClients = emp.getClients();
        for(Client client : listeClients) {
            mapClientHoro.put(client.getId(), new Horoscope());
            mapClients.put(client.getId(),client);
        }
        session.setAttribute("mapClientHoro", mapClientHoro);
        session.setAttribute("map",mapClients);
        session.setAttribute("current_client_id", listeClients.get(0));
        
        request.setAttribute("clients",emp.getClients());
        return true;
    }
}
