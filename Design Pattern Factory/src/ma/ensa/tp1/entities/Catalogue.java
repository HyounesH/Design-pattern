package ma.ensa.tp1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import ma.ensa.tp1.dao.FabriqueAbstraite;

@Entity
public class Catalogue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	Moto moto;
	@OneToOne
	Voiture voiture;
	@Transient
	private FabriqueAbstraite fb;

	public void creeMoto(String modele) {
		this.moto = fb.creeMoto(modele);
	}

	public void creeVoiture(String modele, int puissance) {
		this.voiture = fb.creeVoiture(modele, puissance);
	}

	public void setFb(FabriqueAbstraite fb) {
		this.fb = fb;
	}

}
