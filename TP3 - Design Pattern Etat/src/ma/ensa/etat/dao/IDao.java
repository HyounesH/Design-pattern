package ma.ensa.etat.dao;

import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.LigneCommande;
import ma.ensa.etat.entities.Produit;

public interface IDao {
	
	public void addProduct(Produit produit);
	public void addCommande(Commande commande);
	
	public void addLigneCommande(LigneCommande ligneCommande);
}
