package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("BRG")
public class BrisGlace extends DecorateurAbstrait {

	public BrisGlace(Assurance assurance) {
		super(assurance);
		description ="Bris de glace";
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return assurance.cout() + 70;
	}

}
