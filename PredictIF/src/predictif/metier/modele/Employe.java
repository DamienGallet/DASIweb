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
import javax.persistence.OneToMany;

/**
 *
 * @author slegras
 */
@Entity
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String mail;
    
    @OneToMany
    private List<Client> clients;
    
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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Employe[ id=" + id + " ]";
    }
   
	/**
	 * Constructeur avec parametre
	 * @param mail - l'adresse mail de l'employe
	 */
	public Employe(String mail){
		this.mail = mail;
		this.clients = new ArrayList<>();
	}
	
	/**
	 * Constructeur sans parametre
	 */
	public Employe(){
		this.mail = "";
		this.clients = new ArrayList<>();
	}
	
	//Getters and setters
	/**
	 * 
	 * @return - l'adresse mail de l'employe
	 */
	public String getMail(){
		return mail;
	}
	
	/**
	 * Renvoie la liste de clients affectes a l'employe
	 * @return - liste de clients affectes a l'employe
	 */
	public List<Client> getClients(){
		return clients;
	}
	
	/**
	 * Ajoute un client a l'employe
	 * @param c - le client a ajouter
	 */
	public void ajouterClient(Client c){
		this.clients.add(c);
	}
	
	/**
	 * Afficher l'employe (numero et mail)
	 */
	public void afficher(){
		System.out.println("Employe numero: " + id);
		System.out.println("Mail: " + mail);
	}
        
        /**
	 * Ajoute un client à l'employé
	 * @param c - client à ajouter
	 */
	public void ajouteClient(Client c){
		this.clients.add(c);
	}
    
}
