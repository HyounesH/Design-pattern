package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("DMC")
public class DommageCollision extends DecorateurAbstrait {
	
	public DommageCollision(Assurance assurance) {
		super(assurance);
       description="Dommage et collision";
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return assurance.cout()+50;
	}

}
