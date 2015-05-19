/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import predictif.dao.JpaUtil;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Medium;
import predictif.metier.modele.PAmour;
import predictif.metier.modele.PSante;
import predictif.metier.modele.PTravail;
import predictif.metier.modele.Prediction;
import predictif.metier.service.Service;
import presentation.controleur.actions.Action;
import presentation.controleur.contexte.Contexte;
import presentation.controleur.contexte.ContexteClient;
import presentation.controleur.contexte.ContexteEmploye;
import presentation.utilitaires.Utilitaires;


/**
 *
 * @author tguegan
 */
public class MainServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        
        /* Permet de router le client vers le bon service
        */
        String contexte = request.getRequestURI();
        String[] ressources = contexte.split("/");
        String ressource;
        try {
            ressource = ressources[2];
        } catch(Exception e) {
            ressource = "";
        }
        
        String todo = request.getParameter("todo");
        if(todo==null) {
            todo ="";
        }
        
        String id_client_param = request.getParameter("client_id");
        long id_client;
        if(id_client_param==null) {
            id_client = -1;
        } else {
            try {
                id_client = Long.decode(id_client_param);
            } catch(Exception e) {
                id_client = -1;
            }
        }
        request.setAttribute("client_id", id_client);
        
        
        Contexte ctx = null;
        switch (ressource){
            case "":
                //TODO REMOVE
                System.out.println("----RACINE");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                break;
            case "inscriptionClient":
                //TODO REMOVE
                System.out.println("++++inscrClient");
                ctx = new ContexteClient();
                break;
            case "employe":
                ctx = new ContexteEmploye();
            default:
                //TODO REMOVE
                System.err.println("xxxx404");
                break;
        }
        if(ctx!=null)
        {
            Action action = ctx.getAction(todo);
            String vue = ctx.getVue(todo);
            if(action!=null) {
                action.execute(request);
            }
            request.getRequestDispatcher(vue).forward(request, response);
        }
        
    }
    
    
    public String getVue(String todo) {
        String vue = "";
        
        return vue;
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public void Error(){
        
    }

    @Override
    public void init() throws ServletException {
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
    }
    
    
}
