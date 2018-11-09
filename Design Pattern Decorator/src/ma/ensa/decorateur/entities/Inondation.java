package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("INO")
public class Inondation extends DecorateurAbstrait{

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return assurance.cout()+100;
	}

	public Inondation(Assurance assurance) {
		super(assurance);
		description= "Inondation";
	}
	

}
