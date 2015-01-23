package fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.ControleurPlateau;

/**
 * Classe representant l'etat ou une carte a ete selectionnee.</br></br>
 * 
 * Pattern strategy
 * @author clementdouault
 *
 */
public class UneCarteSelectionnee implements IEtatPlateau {

	/**
	 * Reference du controleur du plateau
	 */
	private ControleurPlateau controleurPlateau;
	
	/**
	 * Constructeur.</br>
	 * Cree une instance de l'etat UneCarteSelectionnee.
	 * @param controleurPlateau ControleurPlateau : la reference du controleur
	 */
	public UneCarteSelectionnee(ControleurPlateau controleurPlateau) {
		this.controleurPlateau = controleurPlateau;
	}
	
	public void carteCliquee(ModeleCarte carte) {
		controleurPlateau.setEtatCourantPlateau(controleurPlateau.getDeuxCartesSelectionnees());		
		controleurPlateau.carte2Selectionnee(carte);
	}

	public void comparaisonCartes() {		
	}

}
