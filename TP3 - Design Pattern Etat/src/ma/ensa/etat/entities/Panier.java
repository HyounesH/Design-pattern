package ma.ensa.etat.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier {
	private Map<Integer, LigneCommande> items = new HashMap<Integer, LigneCommande>();

	public void addItem(Produit p, int quantite) {
		if (items.get(p.getIdProduit()) == null) {
			LigneCommande c = new LigneCommande(quantite, p.getPrix());
			c.setProduit(p);
			items.put(p.getIdProduit(), c);
		} else {
          LigneCommande lc=items.get(p.getIdProduit());
          lc.setQuantite(lc.getQuantite()+quantite);
		}
	}
	
	public Collection<LigneCommande> getItems(){
		return items.values();
	}
	
}
