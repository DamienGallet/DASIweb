/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.utilitaires;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.controleur.MainServlet;

/**
 *
 * @author Damien
 */
public class Utilitaires {
    public static int typePredictionIntFromString(String typePrediction) {
        switch(typePrediction.toLowerCase()) {
            case "amour":
                return 0;
            case "sante":
                return 1;
            case "travail":
                return 2;
            case "all":
                return 3;
            default :
                return 3;
        }
    }
    
    public static Date getAujourdhui(){
        GregorianCalendar calendar = new GregorianCalendar();

        String dateChaine = calendar.get(GregorianCalendar.DAY_OF_MONTH)+"-"+
                            calendar.get(GregorianCalendar.MONTH)+"-"+
                            calendar.get(GregorianCalendar.YEAR);
        DateFormat formatter ; 
        Date date = new Date() ; 
        formatter = new SimpleDateFormat("dd-MM-yy");
        {
            try {
                date = formatter.parse(dateChaine);
            } catch (ParseException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return date;
    }
}
