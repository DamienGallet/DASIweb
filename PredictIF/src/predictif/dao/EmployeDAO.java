package predictif.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import predictif.metier.modele.Employe;

/**
 * 
 * @author orlando_db
 *
 */

public class EmployeDAO {
	
    public static void ajouterEmploye(Employe e){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(e);
    }
    
    public static Employe getEmploye(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Employe e;
        Query query = em.createQuery("Select e from Employe e ");
        try{
            List<Employe> results = query.getResultList();
            e = null;
            if(!results.isEmpty()){
                e = results.get(0);
               for(Employe emp : results){
                   if(emp.getClients().size() < e.getClients().size()){
                       e = emp;
                   }
               } 
            }
            return e;
        }catch(Exception ex){
            System.out.println("Erreur lors de la récupération de l'employé.");
            return null;
        }
    }
    
    public static void updateEmploye(Employe e){
         EntityManager em = JpaUtil.obtenirEntityManager();
        Employe merge;
        merge = em.merge(e);
    }
    
    public static boolean employeExiste(String mail) throws Exception{
        boolean res;
        EntityManager em = JpaUtil.obtenirEntityManager();
        Employe e;
        Query query = em.createQuery("Select e from Employe e where e.mail = '"+mail+"'");
        if(!query.getResultList().isEmpty()){
            res = true;
        }else{
            res = false;
        }
        return res;
    }
    
     public static Employe getEmploye(String mail) throws Exception{
        Employe e;
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("Select e from Employe e where e.mail = '"+mail+"'");
        e = (Employe)query.getSingleResult();
        return e;
    }
     
     
     public static Employe getEmploye(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Employe e;
        try{
            e = em.find(Employe.class, id);
            return e;
        }catch(Exception ex){
            System.out.println("Erreur lors de la récupération de l'employé.");
            return null;
        }
    }
     
     public static List<Employe> getEmployes(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        List<Employe> employe;
        Query query = em.createQuery("Select e from Employe e order by e.mail");
        try{
        employe = (List<Employe>)query.getResultList();
        return employe;
        }
        catch(Exception e){
            System.out.println("Erreur lors de la récupération des employes.");
            return null;
        }
    }
	 	

}
