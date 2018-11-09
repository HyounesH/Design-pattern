package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("INC")
public class Incendie extends DecorateurAbstrait {

	public Incendie(Assurance assurance) {

		super(assurance);
		description = "Incendie";
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return assurance.cout() + 80;
	}

}
