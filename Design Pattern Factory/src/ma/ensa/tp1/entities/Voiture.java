package ma.ensa.tp1.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="carbu",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Voiture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String modele;
	private int puissance;
	
	public Voiture(String modele, int puissance) {
		super();
		this.modele = modele;
		this.puissance = puissance;
	}

	public  abstract void afficherdetails();

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
	

}
