/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author slegras
 */
/**
 * Cette classe modelise une prediction de type "amour"
 * Une prediction amour possede un signe astrologique partenaire
 * @author orlando_db
 *
 */
@Entity
public class PAmour extends Prediction {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
    @ManyToOne
    private SigneAstro signePartenaire;
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
//        if (!(object instanceof PAmour)) {
//            return false;
//        }
//        PAmour other = (PAmour) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "predictif.PAmour[ id=" + id + " ]";
//    }
    
	/**
	 * Constructeur avec parametres
	 * @param signePartenaire - le signe astrologique partenaire
	 * @param description - la description de la prediction
	 * @param force - la force de la prediction
	 */
	public PAmour(SigneAstro signePartenaire, String description, int force){
		super(description, force);
		this.signePartenaire = signePartenaire;
	}
	
	/**
	 * Constructeur sans parametre
	 */
	public PAmour(){
		super();
		this.signePartenaire = null;
	}
	
    @Override
        public SigneAstro getPartenaire(){
            return this.signePartenaire;
        }

    
}