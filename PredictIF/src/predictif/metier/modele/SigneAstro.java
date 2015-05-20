/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author slegras
 */
/**
 * Cette classe modelise un signe astrologique
 * Un signe astrologique possede un nom et un mois (entier entre 1 et 12)
 * @author orlando_db
 *
 */
@Entity
public class SigneAstro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String mois;
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom(){
		return nom;
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
        if (!(object instanceof SigneAstro)) {
            return false;
        }
        SigneAstro other = (SigneAstro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.SigneAstro[ id=" + id + " ]";
    }
    
    public void calculSigne(){
        switch (mois) {
            case "01" : nom = "capricorne" ;
                break;
            case "02" : nom = "verseau" ;
                break;
            case "03" : nom = "poisson" ;
                break;
            case "04" : nom = "bélier" ;
                break;
            case "05" : nom = "taureau" ;
                break;
            case "06" : nom = "gémeaux" ;
                break;
            case "07" : nom = "cancer" ;
                break;
            case "08" : nom = "lion" ;
                break;
            case "09" : nom = "vierge" ;
                break;
            case "10" : nom = "balance" ;
                break;
            case "11" : nom = "scorpion" ;
                break;
            case "12" : nom = "sagitaire" ;
                break;
        } 
    }
    
    	public SigneAstro(String mois){
		this.mois = mois;
	}
	
	public SigneAstro(){
		this.nom = "";
		this.mois = "";
	}
    
}