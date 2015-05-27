/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import predictif.dao.JpaUtil;
import presentation.controleur.actions.Action;
import presentation.controleur.contexte.Contexte;
import presentation.controleur.contexte.ContexteClient;
import presentation.controleur.contexte.ContexteEmploye;


/**
 *
 * @author tguegan & dgallet
 */
public class MainServlet extends HttpServlet {

    public static final String ERROR_VIEW = "WEB-INF/error.jsp";
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
            boolean success = true;
            if(action!=null) {
                success = action.execute(request);
            }
            String vue = ctx.getVue(todo,success);
            if(vue==null) {
                vue = getPreviousVue(request);
            }
            request.getSession().setAttribute("previousVue", vue);
            System.out.println(vue);
            System.out.println(success);
            request.getRequestDispatcher(vue).forward(request, response);
        }
        
    }
    
    public String getPreviousVue(HttpServletRequest request) {
        String vue;
        vue = (String)request.getSession().getAttribute("previousVue");
        if(vue==null) {
            vue = "WEB-INF/index.jsp";
        }
        return vue;
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
