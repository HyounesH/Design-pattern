package ma.ensa.etat.etatCommande;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.Panier;

@Entity
public abstract class Etat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	protected String state;
	protected Commande commande;
	public Etat(Commande commande) {
		this.commande=commande;
		state="En Cours";
	}
	
	public abstract void addItem(Panier panier);
	public abstract void removeItem(int id);
	public abstract Etat nextState();

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
