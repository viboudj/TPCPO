package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ControleurCarte;

/**
 * Classe representant l'etat ou la carte est face visible sur le plateau.<br>
 * Pattern strategy
 * 
 * @author clementdouault
 *
 */
public class FaceVisible implements IEtatCarte {

	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Contructeur.
	 * Cree une instance de l'etat FaceVisible
	 * @param controleurCarte ControleurCarte : la reference du controleur
	 */
	public FaceVisible(ControleurCarte controleurCarte) {
		this.controleurCarte = controleurCarte;
	}
	
	public void updateActivationFaceCachee() {		
	}
	
	public void carteVisible() {		
	}

	public void carteCachee() {
		controleurCarte.getVueCarte().updateFaceCachee();
		controleurCarte.setEtatCourantCarte(controleurCarte.getFaceCachee());
	}

	public void carteHorsPlateau() {
		controleurCarte.getVueCarte().updateHorsPlateau();
		controleurCarte.setEtatCourantCarte(controleurCarte.getHorsPlateau());
	}

	public void carteCliquee() {		
	}
}
