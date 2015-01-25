package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;

public class ModeleInitialisation {
	
	/**
	 * Reference du controleur de l'initialisation
	 */
	private ControleurInitialisation controleur;
	
	
	
	/**
	 * Constructeur du modele de l'initialisation
	 */
	public ModeleInitialisation(){
		controleur = new ControleurInitialisation(this);
	}

	

}
