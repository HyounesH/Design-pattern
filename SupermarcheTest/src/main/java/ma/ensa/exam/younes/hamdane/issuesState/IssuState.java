package ma.ensa.exam.younes.hamdane.issuesState;

import ma.ensa.exam.younes.hamdane.entities.IssueSecours;
/**
 * 
 * @author Younes Hamdane
 *
 *clas qui défine l'etat d'un issue
 */
public abstract class IssuState {
	protected IssueSecours issueSecours;

	public IssuState(IssueSecours issueSecours) {
		super();
		this.issueSecours = issueSecours;
	}
	/**
	 * four states are identified : fermer et ouvert
	 */
	public abstract void fermer();
	public abstract void ouvrir();
	/**
	 *  le methode nouss permet de calculer le distance entre le rayon en paramétre et le rayon de issue
	 * @param rayon
	 * @return  la distance entre le rayon en paramétre et l'issue
	 */
	public abstract int getDistanceFromRayonToEvacuate(int rayon);
	
	

}
