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

/**
 *
 * @author slegras
 */
/**
 * Cettle clase modelise un medium de Predict'IF
 * Un medium est un individu caracterise par un nom et un description
 * Un medium est identifie par son numero
 * @author orlando_db
 *
 */
@Entity
public class Medium implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    private String nom;
    private final String talent;

        
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
        if (!(object instanceof Medium)) {
            return false;
        }
        Medium other = (Medium) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Medium[ id=" + id + " ]";
    }
    
    	/**
	 * Constructeur avec parametres
	 * @param nom - nom du medium
	 * @param description - description du medium
	 */
	public Medium(String nom, String description){
		this.nom = nom;
		this.description = description;
                this.talent = "";
	}
	
	/**
	 * Constructeur sans parametre
	 */
	public Medium(){
		this.nom = "";
		this.description = "";
                this.talent = "";
	}
	
	//Getters
	/**
	 * 
	 * @return - nom du medium
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * 
	 * @return - description du medium
	 */
	public String getDescription(){
		return description;
	}
	


    
}