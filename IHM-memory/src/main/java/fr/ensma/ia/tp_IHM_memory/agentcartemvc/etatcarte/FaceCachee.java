package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ControleurCarte;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.VueCarte;

/**
 * Classe representant l'etat ou la carte est face cachee sur le plateau.</br></br>
 * 
 * Pattern strategy
 * @author clementdouault
 *
 */
public class FaceCachee implements IEtatCarte {

	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Contructeur.</br>
	 * Cree une instance de l'etat FaceCachee.
	 * @param controleurCarte ControleurCarte : la reference du controleur
	 */
	public FaceCachee(ControleurCarte controleurCarte) {
		this.controleurCarte = controleurCarte;
	}
	
	public void desactiveFaceCachee() {
		controleurCarte.getVueCarte().desactiveFaceCachee();
	}
	
	public void carteVisible() {
		controleurCarte.setEtatCourantCarte(controleurCarte.getFaceVisible());
		controleurCarte.getVueCarte().updateFaceVisible();
	}

	public void carteCachee() {		
	}

	public void carteHorsPlateau() {		
	}

	public void carteCliquee() {
		controleurCarte.clicDetecte();
	}

}
