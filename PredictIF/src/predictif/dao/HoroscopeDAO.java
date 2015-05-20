package predictif.dao;



import javax.persistence.EntityManager;
import predictif.dao.JpaUtil;
import predictif.metier.modele.Horoscope;
/**
 * 
 * @author orlando_db
 *
 */
public class HoroscopeDAO {
	
    public static void ajouterHoroscope(Horoscope h){
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(h);	
    }
	
    public static Horoscope getHoroscope(Long id){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Horoscope h = em.find(Horoscope.class, id);
        return h;
    }

}
