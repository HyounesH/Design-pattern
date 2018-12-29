package ma.ensa.etat.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.ensa.etat.config.AppConfig;
import ma.ensa.etat.dao.IDao;
import ma.ensa.etat.entities.Commande;
import ma.ensa.etat.entities.LigneCommande;
import ma.ensa.etat.entities.Panier;
import ma.ensa.etat.entities.Produit;

public class Test {
	public static void main(String[] args) {
		
      ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
      IDao dao=(IDao) context.getBean("dao");
      Commande commande=new Commande();
      
      Produit p1=new Produit("prod1","prod1",1200, 5);
      Produit p2=new Produit("prod2","prod2",3200, 5);
      dao.addProduct(p1);
      dao.addProduct(p2);
      Panier panier=new Panier();
      panier.addItem(p1, 1);
      panier.addItem(p2, 2);
      commande.setItems(panier.getItems());
      commande.setDateCommande(new Date());
      dao.addCommande(commande);
      for(LigneCommande lc:panier.getItems()) {
    	  lc.setCommande(commande);
    	  dao.addLigneCommande(lc);
       } 
    
     System.out.println(commande.getEtat().getState());
     commande.nextState();
     System.out.println(commande.getEtat().getState());
	}
}
