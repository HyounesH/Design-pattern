package ma.ensa.tp1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ES")
public class VoitureEssence  extends Voiture{

	public VoitureEssence(String modele, int puissance) {
		super(modele, puissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afficherdetails() {
    System.out.println("Voiture Essence");		
	}

}
