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
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.service.Service;

/**
 *
 * @author Damien
 */
public class ActionCheckLogin extends Action {
    @Override
    public boolean execute(HttpServletRequest request) 
    {
        if(request.getSession().getAttribute("emp")==null)
        {
            return false;
        } else {
            //L'employe est deja identifie
            return true;
        }
    }
}
