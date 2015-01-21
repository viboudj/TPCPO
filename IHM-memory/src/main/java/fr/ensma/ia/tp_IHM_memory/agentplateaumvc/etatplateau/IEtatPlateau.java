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
	 * Verifie si la carte cliquee est la premiere ou la seconde carte selectionnee
	 * @param carte
	 */
	public void carteCliquee(ModeleCarte carte);
	
	/**
	 * Demande au modele de comparer les deux cartes selectionnees
	 */
	public void comparaisonCartes();
	
}
