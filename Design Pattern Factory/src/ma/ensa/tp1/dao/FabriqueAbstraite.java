package ma.ensa.tp1.dao;

import org.hibernate.SessionFactory;

import ma.ensa.tp1.entities.Moto;
import ma.ensa.tp1.entities.Voiture;

public abstract class FabriqueAbstraite {
	
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public abstract Moto creeMoto(String modele);

	public abstract Voiture creeVoiture(String modele, int puissance);

}
