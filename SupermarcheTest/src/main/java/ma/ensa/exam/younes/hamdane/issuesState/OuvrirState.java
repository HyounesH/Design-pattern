package ma.ensa.exam.younes.hamdane.issuesState;

import ma.ensa.exam.younes.hamdane.entities.IssueSecours;

public class OuvrirState extends IssuState {

	public OuvrirState(IssueSecours issueSecours) {
		super(issueSecours);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fermer() {
		issueSecours.setIssuState(new FermerState(issueSecours));

	}

	@Override
	public void ouvrir() {
		throw new IllegalStateException("issu est déjà ouvert !");
	}

	@Override
	public int getDistanceFromRayonToEvacuate(int rayon) {
		return (rayon > issueSecours.getCurrentRayon()) ? (rayon - issueSecours.getCurrentRayon())
				: (issueSecours.getCurrentRayon() - rayon);
	}

}
