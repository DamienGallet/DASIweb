/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.util.*;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author o
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String civilite;
    private String adresse;
    private String numTel;
    private String mail;
    
    @ManyToOne
    private SigneAstro signe;
	
    @OneToMany
    private List<Horoscope> historique;
	
    @OneToMany
    private List<Medium> favoris;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Client[ id=" + id + " ]";
    }
    
    
    	/**
	 * Constructeur avec parametres
	 * @param nom - nom du client
	 * @param prenom - prenom du client
	 * @param dateNaissance - date de naissance du client
	 * @param civilite - civilite du client 
	 * @param adresse - adresse du client
	 * @param numTel - numero de telephone du client
	 * @param mail - adresse couriel
	 * @param signe - le signe astrologique du client
	 */
	public Client(String nom, String prenom, Date dateNaissance, String civilite, String adresse, String numTel, String mail, SigneAstro signe){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.civilite = civilite;
		this.adresse = adresse;
		this.numTel = numTel;
		this.mail = mail;
		this.historique = new ArrayList<Horoscope>();
		this.favoris = new ArrayList<Medium>();
                this.signe = signe;
	}
	
	/**
	 * Constructeur sans parametre 
	 */
	public Client(){
		this("","",null,"?","","","",null);
	}
	
	//Getters et setters
	
	/**
	 * @return - liste contenant les precedents horoscopes du client
	 */
	public List<Horoscope> getHistorique(){
		return historique;
	}
	
	/**
	 * @return - nom du client
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * @return - prenom du client
	 */
	public String getPrenom(){
		return prenom;
	}
	
	/**
	 * @return - adresse couriel du client
	 */
	public String getMail(){
		return mail;
	}
	
	/**
	 * @return - liste contenant les mediums favoris du client
	 */
	public List<Medium> getFavoris(){
		return favoris;
	}
	
	/**
	 * @return - civilite du client
	 */
	public String getCivilite(){
		return civilite;
	}
	
        /**
	 * @return - adresse du client
	 */
	public String getAdresse(){
		return adresse;
	}
        
        /**
	 * @return - numéro de téléphone du client
	 */
	public String getNumTel(){
		return numTel;
	}
        
	/**
	 * @return - signe astrologique du client
	 */
	public SigneAstro getSigne(){
		return signe;
	}
	
	/**
	 * @param signe - signe astrologique a associer au client
	 */
	public void setSigne(SigneAstro signe){
		this.signe = signe;
	}
	
	
	/**
	 * Ajoute un horoscope a un client
	 * @param h - horoscope a ajouter
	 */
	public void ajouteHoroscope(Horoscope h){
		this.historique.add(h);
	}
	
	/**
	 * Ajoute un medium favori au client
	 * @param m - medium a ajouter
	 */
	public void ajouteMedium(Medium m){
		this.favoris.add(m);
	}
	
	/**
	 * @return  - date du dernier horoscope
	 */
	public Date getDateDernierHoroscope(){
		if(historique.size() > 0){
			return historique.get(historique.size() - 1).getDate();
		}else{
			return null;
		}
	}
	
}