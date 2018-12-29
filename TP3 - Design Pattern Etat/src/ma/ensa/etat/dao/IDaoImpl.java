package ma.ensa.etat.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.LigneCommande;
import ma.ensa.etat.entities.Produit;
@Component(value="dao")
public class IDaoImpl implements IDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Produit produit) {
		Session session=sessionFactory.openSession();
		session.save(produit);
	}

	@Override
	public void addCommande(Commande commande) {
		Session session=sessionFactory.openSession();
		session.save(commande);
	}

	@Override
	public void addLigneCommande(LigneCommande ligneCommande) {
		Session session=sessionFactory.openSession();
		session.save(ligneCommande);
	}
	
}
