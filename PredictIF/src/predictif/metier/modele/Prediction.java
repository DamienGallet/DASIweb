/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author slegras
 */
/**
 * Cette classe abstraite modelise une prediction
 * Une prediction contienne un numero (unique), une description et une "force"
 * La force peut aller entre 1 (la pire) et 4 (le meilleur)
 * @author orlando_db
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Prediction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String description;
    protected int force;
    
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
        if (!(object instanceof Prediction)) {
            return false;
        }
        Prediction other = (Prediction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Prediction[ id=" + id + " ]";
    }
    
    	public Prediction(String description, int force){
		this.description = description;
		this.force = force;
	}
	
	public Prediction(){
		this.description = "";
		this.force = 0;
	}
	
	//Getters et setters
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getForce(){
		return force;
	}
	
	public void setForce(int force){
		this.force = force;
	}
	
        public String getConseil(){
        return null;
        }
	
	public void afficherId(){
		System.out.println(id);
	}
        
        public SigneAstro getPartenaire(){
            return null;
        }

    
}