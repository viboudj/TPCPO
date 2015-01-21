package fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.ControleurPlateau;

/**
 * Classe representant l'etat ou aucune carte n'a ete selectionnee.</br></br>
 * 
 * Pattern strategy
 * @author clementdouault
 *
 */
public class PasCarteSelectionnee implements IEtatPlateau {

	/**
	 * Reference du controleur du plateau
	 */
	private ControleurPlateau controleurPlateau;
	
	/**
	 * Constructeur.</br>
	 * Cree une instance de l'etat PasCarteSelectionnee.
	 * @param controleurPlateau ControleurPlateau : la reference du controleur
	 */
	public PasCarteSelectionnee(ControleurPlateau controleurPlateau) {
		this.controleurPlateau = controleurPlateau;
	}

	public void carteCliquee(ModeleCarte carte) {
		controleurPlateau.carte1Selectionnee(carte);
		controleurPlateau.setEtatCourantPlateau(controleurPlateau.getUneCarteSelectionnee());
	}

	public void comparaisonCartes() {		
	}

}
