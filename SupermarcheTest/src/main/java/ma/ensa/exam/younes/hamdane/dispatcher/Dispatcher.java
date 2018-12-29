package ma.ensa.exam.younes.hamdane.dispatcher;

import java.util.Map;

import ma.ensa.exam.younes.hamdane.entities.IssueSecours;

/**
 *
 * The dispatcher is responsible for deciding issue to use to evacuate the
 * supermarket
 *
 */
public class Dispatcher {

	private Map<String, IssueSecours> issueSecours;
	/**
	 * Implementation of singleton pattern for Dispatcher class
	 */
	public static Dispatcher _instance = null;

	private Dispatcher() {
	}

	public static Dispatcher getInstance() {
		if (_instance == null)
			return new Dispatcher();
		return _instance;
	}

	/**
	 * initiate an instance of dispatcher to decide about a list of issues of
	 * supermarket
	 */
	public void init(Map<String, IssueSecours> issueSecours) {
		this.issueSecours = issueSecours;
	}

	/**
	 * la methode nous permet d'identifier issu que on va utilisé pour evacuer  le supermarché
	 * from a giving rayon. il est supposé évacuer à partir d’un rayon donné.
	 * L’évacuation suit les règles: 
	 * 1. L’évacuation est faite par les issuesouvertes 
	 * 2. L’évacuation est faite par l’issue la plus proche du rayon 
	 * 3. Si la distance vers les issues de secours est la même, l’évacation est faite par
	 * l’issue qui contient moins de personne à évacuer.
	 */
	public String selectIssueFrom(int rayon) {
		int minDist = 10;
		String issuId = null;
		for (String id : issueSecours.keySet()) {
			if (issueSecours.get(id).getDistanceFromRayonToEvacuate(rayon) != -1
					&& issueSecours.get(id).getDistanceFromRayonToEvacuate(rayon) < minDist) {
				minDist = issueSecours.get(id).getDistanceFromRayonToEvacuate(rayon);
				issuId = id;
			} else if (issueSecours.get(id).getDistanceFromRayonToEvacuate(rayon) != -1
					&& issueSecours.get(id).getDistanceFromRayonToEvacuate(rayon) == minDist && issuId != null) {
				if (issueSecours.get(id).getNombreDePersonne() < issueSecours.get(issuId).getNombreDePersonne()) {
					issuId = id;
				}
			}
		}
		return issuId;
	}
    //les getters et les setters 
	public Map<String, IssueSecours> getIssueSecours() {
		return issueSecours;
	}

	public void setIssueSecours(Map<String, IssueSecours> issueSecours) {
		this.issueSecours = issueSecours;
	}

}
