package ma.ensa.exam.younes.hamdane.issuesState;

import ma.ensa.exam.younes.hamdane.entities.IssueSecours;

public class FermerState extends IssuState {

	public FermerState(IssueSecours issueSecours) {
		super(issueSecours);
	}

	@Override
	public void fermer() {
		throw new IllegalStateException("issue déjà fermer");
		
	}

	@Override
	public void ouvrir() {
		issueSecours.setIssuState(new OuvrirState(issueSecours));
	}

	@Override
	public int getDistanceFromRayonToEvacuate(int rayon) {
		// TODO Auto-generated method stub
		return -1;
	}

}
