package ma.ensa.etat.etatCommande;

import javax.persistence.Entity;

import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.Panier;

@Entity
public class EtatLivree  extends Etat{

	public EtatLivree(Commande commande) {
		super(commande);
		setState("Livree");
		// TODO Auto-generated constructor stub
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
		return new EtatEncours(commande);
	}

}
