package ma.ensa.decorateur.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public abstract class DecorateurAbstrait  extends Assurance{
	@OneToOne
	protected Assurance assurance;

	public DecorateurAbstrait(Assurance assurance) {
		super();
		this.assurance=assurance;
	}
	
	

}
