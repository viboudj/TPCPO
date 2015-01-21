package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ControleurCarte;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.VueCarte;

/**
 * Classe representant l'etat ou la carte est face cachee sur le plateau.<br>
 * Pattern strategy
 * 
 * @author clementdouault
 *
 */
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
	
	public void updateActivationFaceCachee() {
		controleurCarte.getVueCarte().updateActivationFaceCachee();
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
