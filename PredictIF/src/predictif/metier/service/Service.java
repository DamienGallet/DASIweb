package predictif.metier.service;

import predictif.dao.ClientDAO;
import predictif.dao.EmployeDAO;
import predictif.dao.JpaUtil;
import predictif.dao.MediumDAO;
import predictif.dao.HoroscopeDAO;
import predictif.dao.PredictionDAO;
import predictif.dao.SigneAstroDAO;
import java.util.*;
import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Medium;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.SigneAstro;

/**
 * Cette classe contient les services metier necessaires au fonctionnement de Predict'IF
 * @author orlando_db
 *
 */

public class Service {
	
	/**
	 * 
	 * @param c
	 */
	public static void ajouterClient(Client c){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				
                                ClientDAO.ajouterClient(c);
                                Employe e = EmployeDAO.getEmploye();
                               	e.ajouterClient(c);
				EmployeDAO.updateEmploye(e);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
		}
	}
	
	/**
	 * 	
	 * @param h
	 * @param c
	 * @return
	 */
	public static void ajouterHoroscopeClient(Horoscope h, Client c){
	    try{
	    	JpaUtil.creerEntityManager();
	    	try{
	    		JpaUtil.ouvrirTransaction();
	    		Client c2 = ClientDAO.getClient(c.getId());
	    		Horoscope h2 = HoroscopeDAO.getHoroscope(h.getId());
	    		c2.ajouteHoroscope(h);
	    		ClientDAO.updateClient(c2);
                        
	    		JpaUtil.validerTransaction();
	    	}catch (Exception ex2){
	    		ex2.printStackTrace();
	    		JpaUtil.annulerTransaction();
	    	}finally{
	    		JpaUtil.fermerEntityManager();
	    	}
	    }catch(Exception ex1){
	    	ex1.printStackTrace();
	    }	
	}
	
	/**
	 * 
	 * @param m
	 * @param c
	 */
	public static void ajouterMediumClient(Medium m, Client c){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				Medium m2 = MediumDAO.getMedium(m.getId());
				Client c2 = ClientDAO.getClient(c.getId());
				c2.ajouteMedium(m2);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
	    }
	}
        
        /**
	 * 
	 * @param m
	 * @param c
	 */
	public static void ajouterClientEmploye(Client c, Employe e){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				//Employe e2 = EmployeDAO.getEmploye(e.getId());
				Client c2 = ClientDAO.getClient(c.getId());
				e.ajouteClient(c);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
	    }
	}
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public static Client getClient(Long Id){
        Client c;
        try{
            JpaUtil.creerEntityManager();
            try{
                JpaUtil.ouvrirTransaction();
                c = ClientDAO.getClient(Id);
                JpaUtil.validerTransaction();
            }catch(Exception ex2){
                ex2.printStackTrace();
                JpaUtil.annulerTransaction();
                c = null;
            }
            finally{
                JpaUtil.fermerEntityManager();
            }
        }catch(Exception ex1){
            ex1.printStackTrace();
            c = null;
        }
        return c;
    }
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public static Horoscope getHoroscope(Long Id){
		Horoscope h;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				h = HoroscopeDAO.getHoroscope(Id);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				h = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		} catch (Exception ex1){
			ex1.printStackTrace();
			h = null;
		}
		return h;		
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Client> getClients(){
		List<Client> clients;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				clients = ClientDAO.getClients();
				JpaUtil.validerTransaction();
			} catch (Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				clients = null;
			} finally {
				JpaUtil.fermerEntityManager();
			}
		} catch (Exception ex1){
			ex1.printStackTrace();
			clients = null;
		}
		return clients;
	}
	
	/**
	 * 
	 * @param nom
	 * @return
	 */
	public static SigneAstro getSigne(String nom){
		SigneAstro s;
		try{ 
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				s = SigneAstroDAO.get(nom);
				JpaUtil.validerTransaction();
			} catch (Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				s = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		} catch (Exception ex1){
			ex1.printStackTrace();
			s = null;
		}
		return s;
	}
	
	/**
	 * 
	 * @param mois
	 * @return
	 */
	public static SigneAstro getSigne(int mois){
		SigneAstro s;
		try{ 
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				s = SigneAstroDAO.get(mois);
				JpaUtil.validerTransaction();
			} catch (Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				s = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		} catch (Exception ex1){
			ex1.printStackTrace();
			s = null;
		}
		return s;		
	}
	
	/**
	 * 
	 * @param s
	 */
	public static void ajouterSigneAstro(SigneAstro s){
		try{ 
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				s.calculSigne();
                                SigneAstroDAO.ajouterSigne(s);
				JpaUtil.validerTransaction();
			} catch (Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		} catch (Exception ex1){
			ex1.printStackTrace();
		}			
	}
	
	/**
	 * 
	 * @param e
	 */
	public static void ajouterEmploye(Employe e){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				EmployeDAO.ajouterEmploye(e);
				JpaUtil.validerTransaction();
			} catch (Exception ex2) {
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Employe getEmploye(){
		Employe e;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				e = EmployeDAO.getEmploye();
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				e = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			e = null;
		}
		return e;
	}
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public static Employe getEmploye(Long Id){
		Employe e;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				e = EmployeDAO.getEmploye(Id);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				e = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			e = null;
		}
		return e;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Employe> getEmployes(){
		List<Employe> employes;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				employes = EmployeDAO.getEmployes();
			}catch (Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				employes = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			employes = null;
		}
		return employes;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Prediction getPrediction(Long id){
		Prediction p;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				p = PredictionDAO.getPrediction(id);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				p = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			p = null;
		}
		return p;
	}
	
	/**
	 * 
	 * @param force
	 * @param type
	 * @return
	 */
	public static List<Prediction> getPredictions(int force, int type){
		List<Prediction> predictions;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				predictions = PredictionDAO.getPredictions(force, type);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				predictions = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			predictions = null;
		}
		return predictions;
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void ajouterPrediction(Prediction p){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				PredictionDAO.ajouterPrediction(p);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param m
	 */
	public static void ajouterMedium(Medium m){
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				MediumDAO.ajouterMedium(m);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
		}		
	}
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public static Medium getMedium(Long Id){
		Medium m;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				m = MediumDAO.getMedium(Id);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				m = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			m = null;
		}
		return m;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Medium> getMediums(){
        List<Medium> mediums;
        try{
            
            JpaUtil.creerEntityManager();
            try{
                JpaUtil.ouvrirTransaction();
                mediums = MediumDAO.getMediums();
                JpaUtil.validerTransaction();
            }catch(Exception ex2){
                ex2.printStackTrace();
                
                JpaUtil.annulerTransaction();
                mediums = null;
            }
            finally{
                JpaUtil.fermerEntityManager();
            }
            
        }catch(Exception ex1){
            ex1.printStackTrace();
            mediums = null;
        }
        return mediums;		
	}
	
	/**
	 * 
	 * @param h
	 */
	public static void ajouterHoroscope(Horoscope h){
        try{      
            JpaUtil.creerEntityManager();
            try{               
                JpaUtil.ouvrirTransaction();
                
                HoroscopeDAO.ajouterHoroscope(h);
                JpaUtil.validerTransaction();
            }catch(Exception ex2){
                ex2.printStackTrace();
                JpaUtil.annulerTransaction();
            }
            finally{
                JpaUtil.fermerEntityManager();
            }
            
        }catch(Exception ex1){
            ex1.printStackTrace();
        }		
	}
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	public static boolean employeExiste(String mail){
		boolean res;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				res = EmployeDAO.employeExiste(mail);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				res = false;
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			res = false;
		}
		return res;
	}
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	public static Employe getEmploye(String mail){
		Employe e;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				e = EmployeDAO.getEmploye(mail);
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				e = null;
				JpaUtil.annulerTransaction();
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			e = null;
		}
		return e;
	}
	/**
	 * 
	 * @param nbMediums
	 * @return
	 */
	public static List<Medium> getMediumsAleatoire(int nbMediums){
		List<Medium> mediums;
		try{
			JpaUtil.creerEntityManager();
			try{
				JpaUtil.ouvrirTransaction();
				mediums = MediumDAO.getMediums();
				while(mediums.size() > nbMediums){
					int indice_aleat = (int)(Math.random()*mediums.size());
					mediums.remove(indice_aleat);
				}
				JpaUtil.validerTransaction();
			}catch(Exception ex2){
				ex2.printStackTrace();
				JpaUtil.annulerTransaction();
				mediums = null;
			}finally{
				JpaUtil.fermerEntityManager();
			}
		}catch(Exception ex1){
			ex1.printStackTrace();
			mediums = null;
		}
		return mediums;
	}
}
