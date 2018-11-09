package ma.ensa.tp1.dao;

import org.springframework.context.annotation.Scope;

import ma.ensa.tp1.entities.Moto;
import ma.ensa.tp1.entities.MotoEssence;
import ma.ensa.tp1.entities.Voiture;
import ma.ensa.tp1.entities.VoitureEssence;
@Scope("singleton")
public class FabriqueVehiculeEssence extends FabriqueAbstraite {
    
	
	private static FabriqueVehiculeEssence instance=null;
	@Override
	public Moto creeMoto(String modele) {
		Moto m =new MotoEssence(modele);
		return m;
	}

	@Override
	public Voiture creeVoiture(String modele,int puissance) {
		Voiture v=new VoitureEssence(modele,puissance);
		return v;
	}
	private FabriqueVehiculeEssence() {
		
	}
	
	public static FabriqueVehiculeEssence getInstance() {
		if(instance==null) instance=new FabriqueVehiculeEssence();
		return instance;
	}

}
