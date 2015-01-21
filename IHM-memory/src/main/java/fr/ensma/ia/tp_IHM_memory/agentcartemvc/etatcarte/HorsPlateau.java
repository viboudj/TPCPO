package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ControleurCarte;

public class HorsPlateau implements IEtatCarte {

	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Contructeur.
	 * Cree une instance de l'etat HorsPlateau
	 * @param controleurCarte ControleurCarte : la reference du controleur
	 */
	public HorsPlateau(ControleurCarte controleurCarte) {
		this.controleurCarte = controleurCarte;
	}
	
	public void carteVisible() {		
	}

	public void carteCachee() {		
	}

	public void carteHorsPlateau() {		
	}

	public void carteCliquee() {		
	}
}
