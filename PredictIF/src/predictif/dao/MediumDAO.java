package predictif.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import predictif.metier.modele.Medium;

/**
 * 
 * @author orlando_db
 *
 */

public class MediumDAO {

	
	public static void ajouterMedium(Medium m){
		 EntityManager em = JpaUtil.obtenirEntityManager();
	     em.persist(m);
	}
	
	public static List<Medium> getMediums() {
		EntityManager em = JpaUtil.obtenirEntityManager();
        List<Medium> mediums;
        Query query = em.createQuery("Select m from Medium m order by m");
        try{
        	mediums = (List<Medium>)query.getResultList();
        	return mediums;
        }
        catch(Exception e){
            System.out.println("Erreur lors de la récupération des mediums.");
            return null;
        }  
	}
	
	public static Medium getMedium(Long Id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Medium m = em.find(Medium.class, Id);
        return m;	
	}
	
	
}


