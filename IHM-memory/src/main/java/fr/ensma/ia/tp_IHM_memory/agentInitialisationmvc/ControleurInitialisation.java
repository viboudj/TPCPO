package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.vue.VueInitialisation;

public class ControleurInitialisation {
	
	/**
	 * Reference du modele de l'initialisation
	 */
	private  ModeleInitialisation modeleInitialisation;
	
	/**
	 * Reference de la vue d'initialisation
	 */
	private VueInitialisation vueInitialisation;
	
	/**
	 * Constructeur du controleur de l'initialisation
	 * @param modeleInitialisation ModeleInitialisation : la reference du modele de l'initialisation
	 */
	public ControleurInitialisation(ModeleInitialisation modeleInitialisation) {
		this.modeleInitialisation=modeleInitialisation;
		vueInitialisation = new VueInitialisation(modeleInitialisation, this);
	}

	public void acquerirParametresPartie() {
		modeleInitialisation.acquisitionParametres();
	}

	public VueInitialisation getVueInitialisation() {
		return vueInitialisation;
	}
}
