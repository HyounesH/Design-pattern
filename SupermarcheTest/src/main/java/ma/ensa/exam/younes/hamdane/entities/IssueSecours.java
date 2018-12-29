package ma.ensa.exam.younes.hamdane.entities;

import ma.ensa.exam.younes.hamdane.issuesState.IssuState;
import ma.ensa.exam.younes.hamdane.issuesState.OuvrirState;

public class IssueSecours {
    
	private int nombreDeRayon;
	private int currentRayon;
	private String issuId;
	private int nombreDePersonne;
	private IssuState issuState;
    /**
     * 
     * @param nombreDeRayon : le nombre des rayon d'un supermarché
     * @param currentRayon  : le rayon d'un issu correspondant
     * @param issuId : l'identifiant d'un rayon
     */
	public IssueSecours(int nombreDeRayon, int currentRayon, String issuId) {
		super();
		this.nombreDeRayon = nombreDeRayon;
		this.currentRayon = currentRayon;
		this.issuId = issuId;
		this.issuState=new OuvrirState(this);
	}
	/**
	 * 
	 * @param rayon :le rayon à partir de quel on va evacuer le supermarché
	 * @return la distance entre le rayon de issue et le rayon spécificie en parametre
	 */
	public int getDistanceFromRayonToEvacuate(int rayon) {
		return issuState.getDistanceFromRayonToEvacuate(rayon);
	}
	public int getNombreDeRayon() {
		return nombreDeRayon;
	}

	public void setNombreDeRayon(int nombreDeRayon) {
		this.nombreDeRayon = nombreDeRayon;
	}

	public int getCurrentRayon() {
		return currentRayon;
	}

	public void setCurrentRayon(int currentRayon) {
		this.currentRayon = currentRayon;
	}

	public String getIssuId() {
		return issuId;
	}

	public void setIssuId(String issuId) {
		this.issuId = issuId;
	}

	public IssuState getIssuState() {
		return issuState;
	}

	public void setIssuState(IssuState issuState) {
		this.issuState = issuState;
	}

	public int getNombreDePersonne() {
		return nombreDePersonne;
	}

	public void setNombreDePersonne(int nombreDePersonne) {
		this.nombreDePersonne = nombreDePersonne;
	}
    
}
