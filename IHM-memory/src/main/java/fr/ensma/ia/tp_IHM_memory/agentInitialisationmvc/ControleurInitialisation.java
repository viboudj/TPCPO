package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.vue.VueInitialisation;

/**
 * Classe representant le controleur de l'initialisation conformement a l'architecture MVC.</br>
 * 
 * @author clementdouault
 *
 */
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

	/**
	 * Previens le modele que la vue a fini d'acquerir les donnees
	 */
	public void acquerirParametresPartie() {
		modeleInitialisation.acquisitionParametres();
	}
	
	/**
	 * Obtient la reference de la vue de l'initialisation
	 * @return vueInitialisation VueInitialisation
	 */
	public VueInitialisation getVueInitialisation() {
		return vueInitialisation;
	}
}
