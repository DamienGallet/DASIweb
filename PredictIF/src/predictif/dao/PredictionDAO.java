package predictif.dao;

import java.util.*;

import predictif.metier.modele.Prediction;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 * 
 * @author orlando_db
 *
 */

public class PredictionDAO {

	 public static void ajouterPrediction(Prediction p){
		 EntityManager em = JpaUtil.obtenirEntityManager();
		 em.persist(p);	 
	 }
	 
	 public static Prediction getPrediction(Long id){
	     EntityManager em = JpaUtil.obtenirEntityManager();
	     Prediction p = em.find(Prediction.class, id);
	     return p;
	 }
	 
	 public static List<Prediction> getPredictions(int force, int type) {
       EntityManager em = JpaUtil.obtenirEntityManager();
       List<Prediction> predictions;
       Query query;
       switch(type){
           case(0): query = em.createQuery("Select p from PAmour p where p.force = :force");
               break;
           case(1): query = em.createQuery("Select p from PSante p where p.force = :force");
               break;
           case(2): query = em.createQuery("Select p from PTravail p where p.force = :force");
               break;
           case(3): query = em.createQuery("Select p from Prediction p where p.force = :force");
               break;
           default: query = null;
       }
       query.setParameter("force", force);
       try{
       predictions = (List<Prediction>)query.getResultList();
       return predictions;
       }
       catch(Exception e){
           System.out.println("Erreur lors de la récupération des predictions.");
           return null;
       }
   }  
}
