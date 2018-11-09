package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("VOL")
public class Vol extends DecorateurAbstrait{

	
	
	
	public Vol(Assurance assurance) {
		super(assurance);
		description="Vol";
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return assurance.cout()+60;
	}

}
