package ma.ensa.tp1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GA")
public class VoitureGasoil  extends Voiture{

	public VoitureGasoil(String modele, int puissance) {
		super(modele, puissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afficherdetails() {
    System.out.println("Voiture Gasoil");		
	}

}
