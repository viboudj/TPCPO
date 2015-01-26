package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.FinPartie;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.PartieEnCours;

/**
 * Classe representant le controleur de la partie conformement a l'architecture MVC.</br>
 * Automate gerant les differents etats de la partie.
 * 
 * @author clementdouault
 *
 */
public class ControleurPartie {

	/**
	 * Reference du modele de la partie
	 */
	private ModelePartie modelePartie;
	
	/**
	 * Reference de la vue de la partie
	 */
	private VuePartie vuePartie;
	
	/**
	 * Etat courant de la partie
	 */
	private IEtatPartie	etatCourantPartie;

	/**
	 * Instance de l'etat PartieEnCours
	 */
	private IEtatPartie partieEnCours = new PartieEnCours(this);
	
	/**
	 * Instance de l'etat FinPartie
	 */
	private IEtatPartie finPartie = new FinPartie(this);
	
	/**
	 * Constructeur du controleur de la partie
	 * @param modelePartie ModelePartie : la reference du modele de la partie
	 */
	public ControleurPartie(ModelePartie modelePartie) {
		this.modelePartie = modelePartie;
		vuePartie = new VuePartie(modelePartie, this);
		
		// initialisation de l'automate gerant les etats du plateau
		etatCourantPartie = partieEnCours;
	}
	
	// -- GESTION DES ETATS DE L'AUTOMATE -- //
	
	/**
	 * Obtient l'etat courant de la partie
	 * @return etatCourantPartie IEtatPartie : l'etat courant de la partie
	 */
	public IEtatPartie getEtatCourantPartie() {
		return etatCourantPartie;
	}

	/**
	 * Modifie l'etat courant de la partie
	 * @param etatCourantPartie IEtatPartie : le nouvel etat courant
	 */
	public void setEtatCourantPartie(IEtatPartie etatCourantPartie) {
		this.etatCourantPartie = etatCourantPartie;
	}

	/**
	 * Obtient la reference de l'etat PartieEnCours
	 * @return partieEnCours IEtatPartie : la reference de l'etat PartieEnCours
	 */
	public IEtatPartie getPartieEnCours() {
		return partieEnCours;
	}

	/**
	 * Obtient la reference de l'etat FinPartie
	 * @return finPartie IEtatPartie : la reference de l'etat FinPartie
	 */
	public IEtatPartie getFinPartie() {
		return finPartie;
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient la reference de la vue de la partie
	 * @return vuePartie VuePartie : la reference de la vue de la partie
	 */
	public VuePartie getVuePartie() {
		return vuePartie;
	}
}
