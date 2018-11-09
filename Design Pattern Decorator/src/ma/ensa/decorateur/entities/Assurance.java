package ma.ensa.decorateur.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Assurance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	protected String description;
	
	public abstract int cout();
}
