package fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ControleurPartie;

public class FinPartie implements IEtatPartie {

	/**
	 * Reference du controleur de la partie
	 */
	private ControleurPartie controleurPartie;
	
	/**
	 * Constructeur.</br>
	 * Cree une instance de l'etat FinPartie
	 * @param controleurPartie ControleurPartie : la reference du controleur de la partie
	 */
	public FinPartie(ControleurPartie controleurPartie) {
		this.controleurPartie = controleurPartie;
	}

	public void updateVue() {
		controleurPartie.getVuePartie().updateVictoire();
	}

	public void plusPaireRestante() {		
	}
}
