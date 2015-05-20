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
 * Cette classe modelise un prediction de type "sante"
 * Une prediction sante est une prediction componant un conseil
 * @author orlando_db
 *
 */
@Entity
public class PSante extends Prediction {
    private static final long serialVersionUID = 1L;

    @Override
	public String toString(){
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
	}

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    
    private String conseil;
//
//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     *
//     * @param id
//     */
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
//
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
//        if (!(object instanceof PSante)) {
//            return false;
//        }
//        PSante other = (PSante) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "predictif.PSante[ id=" + id + " ]";
//    }
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

//
    /**
     * Constructeur avec parametres
     * @param conseil - le conseil de la prediction
     * @param description - la description de la prediction
     * @param force - la force de la prediction
     */
    public PSante(String conseil, String description, int force) {
        super(description, force);
        this.conseil = conseil;
    }
	
	/**
	 * Constructeur sans parametre
	 */
	public PSante(){
		super();
		this.conseil = "";
	}
	
        @Override
        public String getConseil(){
        return this.conseil;
        }

}