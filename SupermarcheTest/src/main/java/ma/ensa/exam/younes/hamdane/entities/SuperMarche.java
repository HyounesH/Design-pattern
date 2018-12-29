package ma.ensa.exam.younes.hamdane.entities;

import java.util.HashMap;
import java.util.Map;

import ma.ensa.exam.younes.hamdane.dispatcher.Dispatcher;

public class SuperMarche {
	private int nombreDeRayon;

	/**
	 * dicision is delegated to dispatcher class in order to respect correctly the
	 * solid principe of design pattern
	 */
	private Dispatcher dispatcher = Dispatcher.getInstance();
	private Map<String, IssueSecours> issueSecours;

	/**
	 * 
	 * @param nombreDeRayon
	 *            : le nombre des rayons d'un supermatché
	 * @param issues
	 *            : les issues qui compose le supermarché dont le format est
	 *            IssueId:currentRayon
	 */
	public SuperMarche(int nombreDeRayon, String... issues) {
		this.nombreDeRayon = nombreDeRayon;
		issueSecours = new HashMap<String, IssueSecours>();
		for (String issu : issues) {
			int currentRayon = Integer.parseInt(issu.split(":")[1]);
			String issuId = issu.split(":")[0];
			IssueSecours is = new IssueSecours(nombreDeRayon, currentRayon, issuId);
			issueSecours.put(issuId, is);
		}
		dispatcher.init(issueSecours);
	}

	/**
	 * 
	 * @param rayon
	 *            : le rayon a partir de quel on va evacué le supermarché
	 * @return : issuId de l'issu que on va utilisé pour évacuer le supermarché
	 */
	public String selectIssueFrom(int rayon) {
		return dispatcher.selectIssueFrom(rayon);
	}

	public int getNombreDeRayon() {
		return nombreDeRayon;
	}

	public void setNombreDeRayon(int nombreDeRayon) {
		this.nombreDeRayon = nombreDeRayon;
	}

	/**
	 * 
	 * @param issuId
	 *            : l'identifiant de issu que on va fermé
	 */
	public void fermer(String issuId) {
		IssueSecours secours = this.issueSecours.get(issuId);
		secours.getIssuState().fermer();
	}

	public Map<String, IssueSecours> getIssuesSecours() {
		return issueSecours;
	}

	public void setIssuesSecours(Map<String, IssueSecours> issueSecours) {
		this.issueSecours = issueSecours;
	}

}
