package ma.ensa.etat.etatCommande;

import javax.persistence.Entity;

import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.Panier;

@Entity
public class EtatEncours extends Etat {

	public EtatEncours(Commande commande) {
		super(commande);
		setState("En Cours");
	}

	@Override
	public void addItem(Panier panier) {
		commande.setItems(panier.getItems());
	}

	@Override
	public void removeItem(int id) {
	commande.getItems().remove(id);	
	}

	@Override
	public Etat nextState() {
		Etat etat=new EtatValidee(commande);
		return etat;
	}

}
