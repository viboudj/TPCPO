package fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.ControleurPlateau;

/**
 * Classe representant l'etat ou deux cartes ont ete selectionnees.</br></br>
 * 
 * Pattern strategy
 * @author clementdouault
 *
 */
public class DeuxCartesSelectionnees implements IEtatPlateau {
	
	/**
	 * Reference du controleur du plateau
	 */
	private ControleurPlateau controleurPlateau;
	
	/**
	 * Constructeur.</br>
	 * Cree une instance de l'etat DeuxCartesSelectionnees.
	 * @param controleurPlateau ControleurPlateau : la reference du controleur
	 */
	public DeuxCartesSelectionnees(ControleurPlateau controleurPlateau) {
		this.controleurPlateau = controleurPlateau;
	}
	
	public void carteCliquee(ModeleCarte carte) {		
	}

	public void comparaisonCartes() {
		controleurPlateau.comparerCartes();
		controleurPlateau.setEtatCourantPlateau(controleurPlateau.getPasCarteSelectionnee());
	}

}
