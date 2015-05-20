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
 * Cette classe modelise une prediction de type "travail"
 * @author orlando_db
 *
 */
@Entity

public class PTravail extends Prediction {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Override
//    public Long getId() {
//        return id;
//    }

    @Override
    public String toString() {
        return "Prediction travail : "+super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     */
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof PTravail)) {
//            return false;
//        }
//        PTravail other = (PTravail) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "predictif.PTravail[ id=" + id + " ]";
//    }
    
    
    	
	/**
	 * Constructeur avec parametres
	 * @param description - la description de la prediction
	 * @param force - la force de la prediction
	 */
	public PTravail(String description, int force){
		super(description, force);
	}
	
	/**
	 * Constructeur sans parametre
	 */
	public PTravail(){
		super();
	}


}
