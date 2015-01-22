package fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ControleurPartie;

public class PartieEnCours implements IEtatPartie {

	/**
	 * Reference du controleur de la partie
	 */
	private ControleurPartie controleurPartie;
	
	/**
	 * Constructeur.</br>
	 * Cree une instance de l'etat PartieEnCours
	 * @param controleurPartie ControleurPartie : la reference du controleur de la partie
	 */
	public PartieEnCours(ControleurPartie controleurPartie) {
		this.controleurPartie = controleurPartie;
	}

	public void updateVue() {
		
	}
	
	public void plusPaireRestante() {
		// TODO Auto-generated method stub
		
	}

	public void ReLancerPartie() {
		// TODO Auto-generated method stub
		
	}
}
