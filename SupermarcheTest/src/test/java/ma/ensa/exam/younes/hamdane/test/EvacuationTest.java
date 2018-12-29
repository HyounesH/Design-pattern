package ma.ensa.exam.younes.hamdane.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ma.ensa.exam.younes.hamdane.entities.SuperMarche;

/*
    * Un supermarché est composé de : plusieurs rayons et plusieurs issues de secours.
	* Une issue de secours peut être ouverte ou fermée. 
	* L’objectif est d’évacuer ce supermarché. Pour evacuer une personne du supermarché, 
	* il est supposé évacuer à partir d’un rayon donné.
	* L’évacuation suit les règles:
	*  1. L’évacuation est faite par les issues ouvertes
	*  2. L’évacuation est faite par l’issue la plus proche du rayon
	*  3. Si la distance vers les issues de secours est la même, 
	*  l’évacation est faite par l’issue qui contient moins de personne à évacuer.
 */
public class EvacuationTest {
   
	@Test
	public void issuePlusProche1() {
		int nombreDeRayon=10;
		SuperMarche supermarche = new SuperMarche(nombreDeRayon,"issu1:3","issu2:9");
	   /* les deux issues sont toutes les deux ouvertes
	    * 
		*                     issu1                         issu2              
		*                      ||                            ||
		*  
		*            ||   ||   ||   ||   ||   ||   ||   ||   ||   ||    
		*            r1   r2   r3   r4   r5   r6   r7   r8   r9   r10
		* Si l'évacuation est faite du rayon 5 l'issue la plus proche est issu1
		*/
		String issuId = supermarche.selectIssueFrom(5);
		assertEquals("issu1", issuId);
		}
  
	@Test
	public void issuePlusProche2(){
		int nombreDeRayon=10;
		SuperMarche supermarche = new SuperMarche(nombreDeRayon,"issu1:3","issu2:10");
		/* fermer l'issue 1 
		*                     issu1 
		*                     ____                              issu2              
		*                      ||                                 ||
		*  
		*            ||   ||   ||   ||   ||   ||   ||   ||   ||   ||    
		*            r1   r2   r3   r4   r5   r6   r7   r8   r9   r10
		 */          
		supermarche.fermer("issu1");
		String issuId = supermarche.selectIssueFrom(4);
		assertEquals("issu2", issuId);
	}


	@Test
	public void issuePlusProche3() {
		int nombreDeRayon=10;
		SuperMarche supermarche = new SuperMarche(nombreDeRayon,"issu1:3","issu2:9");
		// la distance vers l'issue 1 et 2 est la mêmme, mais le nombre de persoones 
		// à évacuer par l'issue 1 est plus élevé. L'evacuation choisit l'issue 2
		supermarche.getIssuesSecours().get("issu1").setNombreDePersonne(10);
		supermarche.getIssuesSecours().get("issu2").setNombreDePersonne(4);
		String issuId = supermarche.selectIssueFrom(6);
		assertEquals("issu2", issuId);
		}
}
