package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("RSV")
public class RespoCivil  extends Assurance{
 
	
	
	public RespoCivil() {
		super();
    description="Responsabilité civil";
	}

	@Override
	public int cout() {
		return 1000;  
	}

}
