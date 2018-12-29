package ma.ensa.etat.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import ma.ensa.etat.etatCommande.Etat;
import ma.ensa.etat.etatCommande.EtatEncours;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	private Date dateCommande;

	@OneToMany(mappedBy = "produit")
	private Collection<LigneCommande> items;

	@Transient
	private Etat etat;

	public Commande() {
		super();
		this.etat=new EtatEncours(this);
	}
	
	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Collection<LigneCommande> getItems() {
		return items;
	}

	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}
	public void addItem(Panier panier) {
		etat.addItem(panier);
	}
	public void nextState() {
		this.etat=etat.nextState();
	}
	

}
