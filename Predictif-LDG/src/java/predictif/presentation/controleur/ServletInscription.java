/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.presentation.controleur;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import predictif.dao.JpaUtil;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;
import predictif.metier.modele.SigneAstro;
import predictif.metier.service.Service;
import static predictif.presentation.controleur.ServletInscription.VUE;
import predictif.vue.Main;

/**
 *
 * @author tguegan
 */
@WebServlet(name = "ServletInscritption", urlPatterns = {"/ServletInscritption"})
public class ServletInscription extends HttpServlet {
@Deprecated
    public static final String VUE = "/WEB-INF/inscriptionClient.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String RADIO_CIVILITE = "civilite";
    public static final String CHAMP_NAISSANCE = "naissance";
    public static final String CHAMP_ADRESSE = "adresse";
    public static final String CHAMP_TELEPHONE = "telephone";
    public static final String CHAMP_MAIL = "mail";
    public static final String OPTION_MEDIUM = "listeDesMediums";

    String paramTODO = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        formulaire(request, response);

        request.setCharacterEncoding("UTF-8");
        paramTODO = request.getParameter("todo_param");
        switch (paramTODO) {
            case "valid_inscr":
                inscriptionClient(request);
                break;
            default:
                formulaire(request, response);
                break;
        }
    }

    public void formulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> nomMedium;
        nomMedium = new ArrayList<>();
        List<Medium> mediums = Service.getMediums();
        for (Medium medium : mediums) {
            nomMedium.add(medium.getNom());
        }
        request.setAttribute("mediums", mediums);
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    public void inscriptionClient(HttpServletRequest request) {
        String nom = request.getParameter(CHAMP_NOM);
        String prenom = request.getParameter(CHAMP_PRENOM);
        String civilite = request.getParameter(RADIO_CIVILITE);
        String naissance = request.getParameter(CHAMP_NAISSANCE);
        String adresse = request.getParameter(CHAMP_ADRESSE);
        String telephone = request.getParameter(CHAMP_TELEPHONE);
        String mail = request.getParameter(CHAMP_MAIL);
        String medium = request.getParameter(OPTION_MEDIUM);

        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(naissance);
        } catch (ParseException ex) {
            Logger.getLogger(ServletInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        String coupe = naissance.substring(3, 5);
        SigneAstro signe = new SigneAstro(coupe);
        Service.ajouterSigneAstro(signe);
        Medium m = Service.getMedium(Long.parseLong(medium));
        Client nouveauClient = new Client(nom, prenom, date, civilite, adresse, telephone, mail, signe);
        Service.ajouterClient(nouveauClient);
        Service.ajouterMediumClient(m, nouveauClient);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Init and Destroy Methods for Servlet and JPA. Click on the + sign on the left to edit the code.">
    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
        try {
            Main.initialiser();
        } catch (ParseException ex) {
            Logger.getLogger(ServletInscription.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void destroy() {
        super.destroy();
        JpaUtil.destroy();//To change body of generated methods, choose Tools | Templates.
    }
}
