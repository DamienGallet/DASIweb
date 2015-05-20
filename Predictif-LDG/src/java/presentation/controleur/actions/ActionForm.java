/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.actions;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import predictif.metier.modele.Medium;
import predictif.metier.service.Service;

/**
 *
 * @author Damien
 */
public class ActionForm extends Action {

    @Override
    public boolean execute(HttpServletRequest request) {
        List<String> nomMedium;
        nomMedium = new ArrayList<>();
        List<Medium> mediums = Service.getMediums();
        if(mediums==null){
            return false;
        }
        
        for (Medium medium : mediums) {
            nomMedium.add(medium.getNom());
        }
        request.setAttribute("mediums", mediums);
        return true;
    }
    
}
