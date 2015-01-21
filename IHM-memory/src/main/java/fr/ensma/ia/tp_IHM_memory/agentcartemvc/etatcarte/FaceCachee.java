package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ControleurCarte;

public class FaceCachee implements IEtatCarte {

	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Contructeur.
	 * Cree une instance de l'etat FaceCachee
	 * @param controleurCarte ControleurCarte : la reference du controleur
	 */
	public FaceCachee(ControleurCarte controleurCarte) {
		this.controleurCarte = controleurCarte;
	}
	
	public void carteVisible() {
		controleurCarte.getVueCarte().updateFaceVisible();
		controleurCarte.setEtatCourantCarte(controleurCarte.getFaceVisible());
	}

	public void carteCachee() {		
	}

	public void carteHorsPlateau() {		
	}

	public void carteCliquee() {
		// TODO Auto-generated method stub
		
	}

}
