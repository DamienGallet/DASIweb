/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
                System.out.println("----RACINE");
                break;
            case "inscriptionClient":
                System.out.println("++++inscrClient");
                break;
            case "employe":
                System.err.println("++++employe");
                Employe currentEmp;
                try {
                    currentEmp = identificationEmploye(request, response, session);
                } catch(Exception e) {
                    throw new IOException();
                }
                currentEmp.afficher();
                

                break;
            default:
                System.err.println("xxxx404");
                break;
        }
        
    }
    
    
    private Employe identificationEmploye(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        //TODO
        if(session.getAttribute("emp")==null)
        {
            // L'employe n'est pas encore identifie
            long emp_id;
            String emp_id_param = request.getParameter("emp_id");
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
