package ma.ensa.tp1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ES")
public class MotoEssence extends Moto{

	public MotoEssence(String modele) {
		super(modele);
	}

	@Override
	public void afficherdetails() {
     System.out.println("motoEssence");		
	}

}
