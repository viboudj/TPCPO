package fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;

/**
 * Classe representant un etat du plateau.</br></br>
 * 
 * Pattern Strategy
 * @author clementdouault
 *
 */
public interface IEtatPlateau {

	/**
	 * Verifie si la carte cliquee est la premiere ou la seconde carte selectionnee.</br>
	 * Transition de l'etat pasCarteSelectionnee a uneCarteSelectionnee puis de l'etat
	 * uneCarteSelectionnee a DeuxCartesSelectionnees.
	 * @param carte ModeleCarte : la carte selectionnee
	 */
	public void carteCliquee(ModeleCarte carte);
	
	/**
	 * Demande au modele de comparer les deux cartes selectionnees.</br>
	 * Transition de l'etat DeuxCartesSelectionnees a pasCarteSelectionnee.
	 */
	public void comparaisonCartes();
	
}
