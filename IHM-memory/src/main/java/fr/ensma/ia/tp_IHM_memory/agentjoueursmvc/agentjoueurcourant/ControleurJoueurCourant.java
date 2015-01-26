package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

/**
 * Classe representant le controleur du joueur courant conformement a l'architecture MVC.
 * 
 * @author clementdouault
 *
 */
public class ControleurJoueurCourant {

	/**
	 * Reference du modele de joueur courant
	 */
	private ModeleJoueurCourant modeleJoueurCourant;
	
	/**
	 * Reference de la vue de joueur courant
	 */
	private VueJoueurCourant vueJoueurCourant;
	
	/**
	 * Constructeur du controleur de joueur courant
	 * @param modeleJoueurCourant ModeleJoueurCourant : la reference du modele de joueur courant
	 */
	public ControleurJoueurCourant(ModeleJoueurCourant modeleJoueurCourant) {
		this.modeleJoueurCourant = modeleJoueurCourant;
		vueJoueurCourant = new VueJoueurCourant(modeleJoueurCourant, this);
	}
	
	/**
	 * Informe la vue qu'elle doit se mettre a jour
	 */
	public void updateVue() {
		vueJoueurCourant.refreshVue();
	}

	/**
	 * Obtient la reference de la vue du joueur courant
	 * @return vueJoueurCourant VueJoueurCourant : la reference de la vue
	 */
	public VueJoueurCourant getVueJoueurCourant() {
		return vueJoueurCourant;
	}
}
