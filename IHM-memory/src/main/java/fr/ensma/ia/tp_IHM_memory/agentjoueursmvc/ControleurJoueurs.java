package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.VueJoueurs;

public class ControleurJoueurs {
	
	/**
	 * Reference du modele de joueurs
	 */
	private ModeleJoueurs modeleJoueurs;
	
	/**
	 * Reference de la vue de joueurs
	 */
	private VueJoueurs vueJoueurs;
	
	/**
	 * Constructeur du controleur de joueurs
	 * @param modeleJoueurs ModeleJoueurs : la reference du modele de joueurs
	 */
	public ControleurJoueurs(ModeleJoueurs modeleJoueurs){
		this.modeleJoueurs = modeleJoueurs;
		vueJoueurs = new VueJoueurs(modeleJoueurs, this);
	}

	/**
	 * Informe la vue qu'elle doit se mettre a jour
	 */
	public void updateVue() {
		vueJoueurs.refreshVue();
	}

	public VueJoueurs getVueJoueurs() {
		return vueJoueurs;
	}
}
