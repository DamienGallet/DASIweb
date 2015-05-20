package predictif.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import predictif.metier.modele.Client;

/**
 * 
 * @author orlando_db
 *
 */

public class ClientDAO {

	public static void ajouterClient(Client c){
	EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(c);
	}
	
	public static Client getClient(Long Id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Client c = em.find(Client.class, Id);
        return c;		
	}
	    
    public static List<Client> getClients(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        List<Client> clients;
        Query query = em.createQuery("Select c from Client c order by c.nom, c.prenom");
        try{
        	clients = (List<Client>)query.getResultList();
        	return clients;
        }
        catch(Exception e){
            System.out.println("Erreur lors de la récupération des clients.");
            return null;
        }  
    }
    		
    public static void updateClient(Client c){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.merge(c);
   }
}
