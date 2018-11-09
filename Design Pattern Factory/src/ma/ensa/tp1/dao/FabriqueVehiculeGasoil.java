package ma.ensa.tp1.dao;

import org.springframework.context.annotation.Scope;

import ma.ensa.tp1.entities.Moto;
import ma.ensa.tp1.entities.MotoGasoil;
import ma.ensa.tp1.entities.Voiture;
import ma.ensa.tp1.entities.VoitureGasoil;
@Scope("singleton")
public class FabriqueVehiculeGasoil extends FabriqueAbstraite {
	
	
	private static FabriqueVehiculeGasoil instance=new FabriqueVehiculeGasoil();

	@Override
	public Moto creeMoto(String modele) {
		Moto m=new MotoGasoil(modele);
		return m;
	}

	@Override
	public Voiture creeVoiture(String modele,int puissance) {
        Voiture v=new VoitureGasoil(modele,puissance);
		return v;
	}
	
	private FabriqueVehiculeGasoil() {
		
	}
	public static FabriqueVehiculeGasoil getInstance() {
		return instance;
	}

}
