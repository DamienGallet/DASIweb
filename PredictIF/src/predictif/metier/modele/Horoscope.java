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
 * @author slegras
 */
/**
 * Cettle clase modelise un horoscope de Predict'IF
 * Un horoscope est caracterise par la date de creation et son auteur
 * @author orlando_db
 *
 */
@Entity
public class Horoscope implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Medium auteur;
    
    @ManyToOne
    private PTravail travail;
    @ManyToOne
    private PAmour amour;
    @ManyToOne
    private PSante sante;
    
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAuteur(Medium auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horoscope)) {
            return false;
        }
        Horoscope other = (Horoscope) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Horoscope[ id=" + id + " ]";
    }
    
    	/**
	 * Constructeur avec parametres
	 * @param date - date de creation de l'horoscope
	 * @param auteur - auteur de l'horoscope
     * @param pt
     * @param pa
     * @param ps
	 */
	public Horoscope(Date date, Medium auteur, PTravail pt, PAmour pa, PSante ps){
		this.date = date;
		this.auteur = auteur;
                this.amour = pa;
                this.sante = ps;
                this.travail = pt;
	}
	
	/**
	 * Constructeur sans parametre
	 */
	public Horoscope(){
		this(null, null, null, null, null);
	}
	
	/**
	 * 
	 * @return - prediction travail de l'horoscope
	 */
	public PTravail getTravail(){
		return travail;
	}
	
	/**
	 * 
	 * @param travail - la nouvelle prediction travail de l'horoscope 
	 */
	public void setTravail(PTravail travail){
		this.travail = travail;
	}
	
	/**
	 * 
	 * @return - la prediction amour de l'horoscope
	 */
	public PAmour getAmour(){
		return amour;
	}
	
	/**
	 * 
	 * @param amour - la nouvelle prediction amour de l'horoscope 
	 */
	public void setAmour(PAmour amour){
		this.amour = amour;
	}
	
	/**
	 * 
	 * @return - la prediction sante de l'horoscope 
	 */
	public PSante getSante(){
		return sante;
	}
	
	/**
	 * 
	 * @param sante - la nouvelle prediction sante de l'horoscope 
	 */
	public void setSante(PSante sante){
		this.sante = sante;
	}
	
	/**
	 * 
	 * @return - la date de l'horoscope
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * 
	 * @return - medium auteur de l'horoscope
	 */
	public Medium getAuteur(){
		return auteur;
	}
	
    
}