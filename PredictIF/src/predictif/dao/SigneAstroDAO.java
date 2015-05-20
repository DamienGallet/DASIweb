package predictif.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import predictif.metier.modele.Client;
import predictif.metier.modele.SigneAstro;
/**
 * 
 * @author orlando_db
 *
 */
public class SigneAstroDAO {
	
    public static SigneAstro get(int month){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("Select s from SigneAstro s where s.mois = " + month);
        SigneAstro s;
        try{
        	s = (SigneAstro) query.getSingleResult();
        	return s;
        }catch(Exception e){
            System.out.println("aucun signe ne correspond au mois donné");
        }
        SigneAstro defaut = new SigneAstro();
        return defaut;
    }
	
    public static SigneAstro get(String nom){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("Select s from SigneAstro s where s.nom = '"+ nom + "'");
        SigneAstro s;
        try{
        s = (SigneAstro) query.getSingleResult();
        return s;
        }catch(Exception e){
            System.out.println("aucun signe ne correspond au nom donné");
        }
        SigneAstro defaut = new SigneAstro();
        return defaut; 
    }
	
	public static void ajouterSigne(SigneAstro s){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(s);
    }

}
