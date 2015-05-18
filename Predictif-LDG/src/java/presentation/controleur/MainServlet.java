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
        
        switch (ressource){
            case "":
                //TODO REMOVE
                System.out.println("----RACINE");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                break;
            case "inscriptionClient":
                //TODO REMOVE
                System.out.println("++++inscrClient");
                break;
            case "employe":
                //TODO REMOVE
                System.out.println("++++employe");
                
                Employe currentEmp;
                try {
                    currentEmp = identificationEmploye(request, response, session);
                } catch(Exception e) {
                    throw new IOException();
                }
                
                // Lecture TODO
                String todo_param = request.getParameter("todo");
                if(currentEmp==null)
                {
                    //premier acces
                    //TODO REMOVE
                    System.out.println("First access");
                    todo_param = "print_login";
                }
                
                if(todo_param==null)
                {
                    throw new IOException();
                }
                String client_id_param;
                Long client_id;
                Map<Long,Horoscope> mapClientHoro;
                Horoscope currentHoro;
                String prediction_type_param;
                switch(todo_param){
                    case "print_login":
                        request.getRequestDispatcher("WEB-INF/employe.jsp").forward(request, response);
                        break;
                    case "action_login":
                        request.setAttribute("clients",currentEmp.getClients());
                        for(Client client : currentEmp.getClients())
                            System.out.println(client.getNom());
                        request.getRequestDispatcher("WEB-INF/employe_select_client.jsp").forward(request, response);
                        break;
                    case "select_client":
                        System.out.println("!!!!!!!!!Select_client");
                        // Lecture ID CLIENT
                        client_id_param = request.getParameter("client_id");

                        try {
                            client_id = Long.decode(client_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        mapClientHoro = (Map<Long,Horoscope>) session.getAttribute("mapClientHoro");
                        currentHoro = mapClientHoro.get(client_id);
                        request.setAttribute("currentHoro", currentHoro);
                        request.setAttribute("client_id", client_id);
                        request.getRequestDispatcher("WEB-INF/employe_horo.jsp").forward(request, response);
                        break;
                    case "bind_prediction":
                        String prediction_id_param = request.getParameter("prediction_id");
                        client_id_param = request.getParameter("client_id");
                        prediction_type_param = request.getParameter("type_prediction");
                        
                        Long prediction_id;
                        try {
                            prediction_id = Long.decode(prediction_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        
                        try {
                            client_id = Long.decode(client_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        
                        mapClientHoro = (Map<Long,Horoscope>)session.getAttribute("mapClientHoro");
                        currentHoro = mapClientHoro.get(client_id);
                        request.setAttribute("client_id", client_id);
                        Prediction currentPred = Service.getPrediction(prediction_id);
                        switch(prediction_type_param)
                        {
                            case "amour":
                                currentHoro.setAmour((PAmour)currentPred);
                                break;
                            case "sante":
                                currentHoro.setSante((PSante)currentPred);
                                break;
                            case "travail":
                                currentHoro.setTravail((PTravail)currentPred);
                                break;
                            default :
                                throw new IOException();
                        }
                        request.getRequestDispatcher("WEB-INF/employe_horo.jsp").forward(request, response);

                        break;
                    case "validate":
                        client_id_param = request.getParameter("client_id");
                        String medium_id_param = request.getParameter("medium_id");
                        System.out.println("@@@@@@@@@@@ Validate @@@@@@@@@@@");
                        System.out.println(medium_id_param);
                        Long medium_id;
                        try {
                            client_id = Long.decode(client_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        try {
                            medium_id = Long.decode(medium_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        Medium medium = Service.getMedium(medium_id);
                        Client currentClient = Service.getClient(client_id);
                        mapClientHoro = (Map<Long,Horoscope>)session.getAttribute("mapClientHoro");
                        currentHoro = mapClientHoro.get(client_id);
                        currentHoro.setAuteur(medium);
                        
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
                        
                        currentHoro.setDate(date);
                        Service.ajouterHoroscope(currentHoro);
                        Service.ajouterHoroscopeClient(currentHoro, currentClient);
                        
                        break;
                    case "history":
                        client_id_param = request.getParameter("client_id");
                        try {
                            client_id = Long.decode(client_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        currentClient = Service.getClient(client_id);
                        request.setAttribute("client",currentClient);
                        request.getRequestDispatcher("WEB-INF/employe_history.jsp").forward(request, response);
                        break;
                    case "select_prediction":
                        client_id_param = request.getParameter("client_id");
                        prediction_type_param = request.getParameter("type_prediction");
                        int prediction_type = typePredictionIntFromString(prediction_type_param);

                        try {
                            client_id = Long.decode(client_id_param);
                        } catch(Exception e) {
                            throw new IOException();
                        }
                        
                        //On regarde si, pour ce type de prediction, l'horscope n'est deja pas rempli
                        mapClientHoro = (Map<Long,Horoscope>)session.getAttribute("mapClientHoro");
                        currentHoro = mapClientHoro.get(client_id);
                        long id_prediction = 0;
                        switch(prediction_type_param)
                        {
                            case "amour":
                                if(currentHoro.getAmour()!=null)
                                    id_prediction = currentHoro.getAmour().getId();
                                break;
                            case "sante":
                                if(currentHoro.getSante()!=null)
                                    id_prediction = currentHoro.getSante().getId();
                                break;
                            case "travail":
                                if(currentHoro.getTravail()!=null)
                                    id_prediction = currentHoro.getTravail().getId();
                                break;
                        }
                        
                        
                        List<Prediction> predictions;
                        predictions = Service.getPredictions(1, prediction_type);
                        for(Prediction p : predictions)
                        {
                            System.out.println("-----Prediction");
                            System.out.println(p.getDescription());
                            System.out.println(p.getId());
                        }
                        request.setAttribute("predictions", predictions);
                        request.setAttribute("client_id", client_id);
                        request.setAttribute("prediction_type", prediction_type_param);
                        request.setAttribute("id_previous_prediction", id_prediction);
                        request.getRequestDispatcher("WEB-INF/employe_predictions.jsp").forward(request, response);
                        break;
                    case "logout":
                        session.setAttribute("emp", null);
                        break;
                    default:
                        break;
                }
                break;
            default:
                //TODO REMOVE
                System.err.println("xxxx404");
                break;
        }
        
    }
    
    private int typePredictionIntFromString(String typePrediction) {
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
    
    private Employe identificationEmploye(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        //TODO
        if(session.getAttribute("emp")==null)
        {
            // L'employe n'est pas encore identifie
            long emp_id;
            String emp_id_param = request.getParameter("emp_id");
            if(emp_id_param == null)
                //L'employe n'a pas cherche a s'identifier
                return null;
            
            try {
                emp_id = Long.decode(emp_id_param);
            } catch (Exception e) {
                //TODO
                throw new IOException();
            }
            Employe emp;
            try {
                emp = Service.getEmploye(emp_id);
            } catch(Exception e) {
                //TODO
                throw new IOException();
            }
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
            return emp;
        } else {
            //L'employe est deja identifie
            return (Employe)session.getAttribute("emp");
        }
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
