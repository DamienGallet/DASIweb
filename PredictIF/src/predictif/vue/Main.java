package predictif.vue;

/**
 * 
 * @author orlando_db
 *
 */

import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import predictif.metier.modele.*;
import predictif.metier.service.Service;
import predictif.util.Saisie;


public class Main {
	
    public static void main(String[] args) throws ParseException{
	//SaisieInteractiveClient();
        initialiser();
        //SaisieInteractiveHoroscope();
        afficherClients();

        
    }
    /**
     *
     */
    public static void SaisieInteractiveClient() throws ParseException{
		//creation interactive client
		System.out.println("Creation client \n");
		String nom = Saisie.lireChaine("Nom?\n");
		String prenom = Saisie.lireChaine("Prenom?\n");
		String civilite = Saisie.lireChaine("Civilite? (M. ou Mme.)\n");
		String dateChaine = Saisie.lireChaine("Date de naissance? (format AAAA-MM-JJ)\n");
		String adresse = Saisie.lireChaine("Adresse?\n");
		String tel = Saisie.lireChaine("Telephone:\n");
		String mail = Saisie.lireChaine("Mail?\n");
                DateFormat formatter ; 
                Date date ; 
                formatter = new SimpleDateFormat("dd-MM-yy");
                date = formatter.parse(dateChaine);
                String coupe = dateChaine.substring(3,5);
		SigneAstro signe = new SigneAstro (coupe);
                Service.ajouterSigneAstro(signe);
		Client c = new Client(nom, prenom, date, civilite, adresse, tel, mail, signe);
                Employe e = new Employe();
                Service.ajouterEmploye(e);
		Service.ajouterClient(c);
		//choix interactif de mediums
		List<Medium> mediums = Service.getMediums();
		List<Long> choixPossible = new ArrayList<>();
		choixPossible.add(0L);
		
		for(Medium m : mediums){
			choixPossible.add(m.getId());
		}
		
		Long mediumId;
		
		for(Medium m : mediums){
			System.out.println("Medium " + m.getNom() + " numero " + m.getId());
		}
		
		while(0 != (mediumId = Saisie.lireLong("Choix d'un medium (entrez le numero du medium choisi ou 0 quand termine)\n", choixPossible))){
                  Medium mediumAjoute = Service.getMedium(mediumId);
                 Service.ajouterMediumClient(mediumAjoute, c);
                    for(Medium m : mediums){
                        System.out.println("Medium " + m.getNom() + " numero " + m.getId());
                }
        }
		
		System.out.println(c.getNom() + " " + c.getPrenom() + " " + c.getCivilite() + " " + c.getAdresse() + " " + c.getNumTel() + " " + "signe: " + c.getSigne().getNom() );
		System.out.println("Mediums favoris: ");
                List<Medium> favoris = new ArrayList<>();
                favoris = c.getFavoris(); 
		for(Medium m : favoris){
			System.out.println(m.getNom());
		}
		//fin creation interactive client
	}
	
	/**
	 * 
	 */
	public static void SaisieInteractiveHoroscope(){
		//varuabkes necessaires a l'inscription d'un client
		Long empId, clientId, mediumId;
		int forceA, forceS, forceT;
		Long pAmourId, pTravailId, pSanteId;
		
		List<Long> empPossibles = new ArrayList<>();
		List<Employe> emp = Service.getEmployes();
		List<Long> clientsPossibles = new ArrayList<>();
		List<Long> mediumsPossibles = new ArrayList<>();
		List<Integer> forcesPossibles;
                forcesPossibles = new ArrayList<>();
                List<Long> pPredIdPossibles = new ArrayList<>();
		PAmour amour;
		PSante sante;
		PTravail travail;
		
		for(int i = 1; i < 5; i++){
			forcesPossibles.add(i);
		}
		
		//choix de l'employe
		
		for(Employe e : emp){
			empPossibles.add(e.getId());
			System.out.println("Employe numero: " + e.getId());
                        System.out.println("Mail: " + e.getMail());
		}
		
		empId = Saisie.lireLong("Numero d'employe?\n", empPossibles);
		Employe employe = Service.getEmploye(empId);
		for(Client c: employe.getClients()){
			clientsPossibles.add(c.getId());
			System.out.println("Numero client: " + c.getId());
			
                        System.out.println(c.getNom() + " " + c.getPrenom() + " " + c.getCivilite() + " " + c.getAdresse() + " " + c.getNumTel() + " " + "signe: " + c.getSigne().getNom() );
                        System.out.println("Mediums favoris: ");
                        List<Medium> favoris = new ArrayList<>();
                        favoris = c.getFavoris(); 
                        for(Medium m : favoris){
                            System.out.println(m.getNom());
                        }
		}
		
		//choix du client
                List <Medium> mediums = new ArrayList<>();
		clientId = Saisie.lireLong("Numero du client?\n", clientsPossibles);
		Client client = Service.getClient(clientId);
		mediums = client.getFavoris();
		
		//choix d'un medium du client
		for(Medium m: mediums){
			mediumsPossibles.add(m.getId());
			System.out.println("Medium " + m.getNom() + " numero " + m.getId());
		}
		mediumId = Saisie.lireLong("Numero du medium?\n", mediumsPossibles);
		Medium medium = Service.getMedium(mediumId);
		
		//saisie de la prediction amour
		forceA = Saisie.lireInteger("Force de la prediction amour?\n", forcesPossibles);
		List<Prediction> pAmourPossibles = Service.getPredictions(forceA, 0);
		for(Prediction p : pAmourPossibles){
			pPredIdPossibles.add(p.getId());
			p.afficherId();
                        System.out.println("Amour (" + p.getForce() +" )" );
                        System.out.println(p.getDescription());
                        System.out.println("Signe partenaire: " + p.getPartenaire().getNom() );
		}
		pAmourId = Saisie.lireLong("Entrez le numero de la prediction amour\n");
		amour = (PAmour)Service.getPrediction(pAmourId);
		
		//saisie de la prediction Sante
		forceS = Saisie.lireInteger("Force de la prediction sante?\n", forcesPossibles);
		List<Prediction> pSantePossibles = Service.getPredictions(forceS, 1);
		for(Prediction p : pSantePossibles){
			pPredIdPossibles.add(p.getId());
			p.afficherId();
                        System.out.println("Sante (" + p.getForce() +" )" );
                        System.out.println(p.getDescription());
                        System.out.println("Conseil: " + p.getConseil());
		}
		pSanteId = Saisie.lireLong("Entrez le numero de la prediction sante\n");
		sante = (PSante)Service.getPrediction(pSanteId);
		
		//saisie de la prediction travail
		forceT = Saisie.lireInteger("Force de la prediction travail?\n", forcesPossibles);
		List<Prediction> pTravailPossibles = Service.getPredictions(forceT, 2);
		for(Prediction p : pTravailPossibles){
			pPredIdPossibles.add(p.getId());
			p.afficherId();
                        System.out.println("Travail (" + p.getForce() +" )" );
                        System.out.println(p.getDescription());
		}
		pTravailId = Saisie.lireLong("Entrez le numero de la prediction travail\n");
		travail = (PTravail)Service.getPrediction(pTravailId);
		
		//creation de l'horoscope et persistance dans la base
		Date date = new Date();
		Horoscope horoscope = new Horoscope(date, medium, travail, amour, sante);
		horoscope.setAmour(amour);
		horoscope.setSante(sante);
		horoscope.setTravail(travail);
		Service.ajouterHoroscope(horoscope);
		
		//affichage de l'horoscope cree
		horoscope = Service.getHoroscope(horoscope.getId());
		System.out.println("Nouvel horoscope cree:");
		
                PAmour p = new PAmour();
                p = horoscope.getAmour();
                System.out.println("Amour (" + p.getForce() +" )" );
                System.out.println(p.getDescription());
                System.out.println("Signe partenaire: " + p.getPartenaire().getNom() );
                
                PSante s = new PSante();
                s = horoscope.getSante();
                System.out.println("Sante (" + s.getForce() +" )" );
                System.out.println(s.getDescription());
                System.out.println("Conseil: " + s.getConseil());
                
                PTravail t = new PTravail();
                t = horoscope.getTravail();
                System.out.println("Travail (" + t.getForce() +" )" );
                System.out.println(t.getDescription());
		
		//affichage du mail envoye au client
		System.out.println("Mail envoye au client: \n");
		Service.ajouterHoroscopeClient(horoscope, client);
                
                
                //affichage
                String res = "";

                res = client.getPrenom() + " " + client.getNom() + "\n";
		res += client.getAdresse() + "\n";
		res += client.getNumTel() + "\n";
		res += "Votre numero client est " + client.getId() + "\n";
		res += "Votre signe astrologique est " +  client.getSigne().getNom() + "\n";
		res += "Vos mediums favoris: ";
		for(Medium m : client.getFavoris()){
			res += (m.getNom()+" ");
		}
		res += "\n";
                
                res += "\nLe" + horoscope.getDate() + "\n\n";
	    		
	    	if(client.getCivilite().equals("M.")){
	    		res += "Cher";
	    	}else{
	    		res += "Chere";
	    	}
	    		
	    	res += " " + client.getPrenom() + ", aujourd'hui votre voyance vous est offerte par " + horoscope.getAuteur().getNom() + ".";
	    	System.out.println(res);

                PAmour pa = new PAmour();
                p = horoscope.getAmour();
                System.out.println("Amour (" + pa.getForce() +" )" );
                System.out.println(pa.getDescription());
                System.out.println("Signe partenaire: " + pa.getPartenaire().getNom() );
                
                PSante sa = new PSante();
                s = horoscope.getSante();
                System.out.println("Sante (" + sa.getForce() +" )" );
                System.out.println(sa.getDescription());
                System.out.println("Conseil: " + sa.getConseil());
                
                PTravail ta = new PTravail();
                t = horoscope.getTravail();
                System.out.println("Travail (" + ta.getForce() +" )" );
                System.out.println(ta.getDescription());
        }
        
        public static void initialiser() throws ParseException {
            Medium m1 = new Medium("Irma", "Mirage mirage");
            Medium m2 = new Medium("Lalilalou", "Medium de la blague");
            Medium m3 = new Medium("Madame Soleil", "Le jour se lève");
            Medium m4 = new Medium("Madame Lune", "La nuit tombe");
            Medium m5 = new Medium("Irmama", "Maman pour vous");
            Service.ajouterMedium(m1);
            Service.ajouterMedium(m2);
            Service.ajouterMedium(m3);
            Service.ajouterMedium(m4);
            Service.ajouterMedium(m5);
            
            Employe e1 = new Employe("john-le-killeur@medium.fr");
            Employe e2 = new Employe("mireille@medium.fr");
            Employe e3 = new Employe("lily-des-roses@medium.fr");
            Service.ajouterEmploye(e1);
            Service.ajouterEmploye(e2);
            Service.ajouterEmploye(e3);
            
            String dateChaine = "12-05-06";
            DateFormat formatter ; 
            Date date ; 
            formatter = new SimpleDateFormat("dd-MM-yy");
            date = formatter.parse(dateChaine);
            String coupe = dateChaine.substring(3,5);
            SigneAstro signe = new SigneAstro (coupe);
            Service.ajouterSigneAstro(signe);
            Client c1 = new Client("Jackson", "Florian", date, "M", "14 rue des bonbons", "054675829", "jackson@insa-lyon.fr", signe);
            Client c2 = new Client("Jacky", "Michel", date, "M", "87 rue des fraisiers", "014675829", "michel-le-papy@free.fr", signe);
            Client c3 = new Client("Hubert", "Hubert", date, "M", "1 allée des fleurs roses et bleues", "094675829", "kitsch@hotmail.com", signe);
            Client c4 = new Client("Dalida", "Francine", date, "Mme", "Rue du petit pont", "094675829", "dalida@hahtag.com", signe);
            Service.ajouterClient(c1);
            Service.ajouterClient(c2);
            Service.ajouterClient(c3);
            Service.ajouterClient(c4);
            
            Service.ajouterMediumClient(m1,c1);
            Service.ajouterMediumClient(m2,c4);
            Service.ajouterMediumClient(m2,c1);
            Service.ajouterMediumClient(m3,c1);
            Service.ajouterMediumClient(m4,c1);
            Service.ajouterMediumClient(m5,c1);
            Service.ajouterMediumClient(m1,c2);
            Service.ajouterMediumClient(m3,c3);
            Service.ajouterMediumClient(m4,c3);
            

            Service.ajouterClientEmploye(c3, e3);
            Service.ajouterClientEmploye(c2, e3);
            Service.ajouterClientEmploye(c1, e1);
            
            PTravail t1 = new PTravail ("Vous allez soulever des montagnes", 4);
            PTravail t2 = new PTravail ("Allez vous recoucher", 1);
            PAmour a1 = new PAmour (signe, "Vous tomberez amoureux demain", 5);
            PAmour a2 = new PAmour (signe, "Vous vous ferez larguer", 1);
            PSante s1 = new PSante ("Ne marchez pas !", "Vous  vous cassez un genou", 1);
            PSante s2 = new PSante ("Bougez-vous", "Vous perdrez du poids", 4);
            Service.ajouterPrediction(t1);
            Service.ajouterPrediction(t2);
            Service.ajouterPrediction(a1);
            Service.ajouterPrediction(a2);
            Service.ajouterPrediction(s1);
            Service.ajouterPrediction(s2);
            
            Horoscope h1 = new Horoscope(date, m1, t1, a2, s1);
            Horoscope h2 = new Horoscope(date, m5, t2, a1, s2);
            Service.ajouterHoroscope(h1);
            Service.ajouterHoroscope(h2);
            Service.ajouterHoroscopeClient(h1, c1);
            Service.ajouterHoroscopeClient(h2, c2);
            Service.ajouterHoroscopeClient(h1, c3);
            
            
            
            
            
            
        }
        
        public static void afficherClients(){
            List<Client> liste = new ArrayList<>();
            liste = Service.getClients();
            for (int i =0; i<liste.size(); i++) {
                Client a = liste.get(i);
                
                
                System.out.println(a.getNom() + " " + a.getPrenom() + " " + a.getCivilite() + " " + a.getAdresse() + " " + a.getNumTel() + " " + "signe: " + a.getSigne().getNom() );
		System.out.println("Mediums favoris: ");
                List<Medium> favoris = new ArrayList<>();
                favoris = a.getFavoris(); 
		for(Medium m : favoris){
			System.out.println(m.getNom());
		}
            }
        }

}
