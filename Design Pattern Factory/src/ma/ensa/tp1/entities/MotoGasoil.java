package ma.ensa.tp1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GA")
public  class MotoGasoil extends Moto {

	public MotoGasoil(String modele) {
		super(modele);
	}

	@Override
	public void afficherdetails() {
   System.out.println("MotoGasoil");		
	}

}
