package fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte;

/**
 * Classe representant un etat de la carte sur le plateau.</br>
 * Pattern Strategy
 * 
 * @author clementdouault
 *
 */
public interface IEtatCarte {

	/**
	 * Appelle la vue pour mettre a jour la "cliquabilite" de la face cachee de la carte
	 */
	public void updateActivationFaceCachee();
	
	/**
	 * Appelle la vue pour que la carte soit placee face visible
	 */
	public void carteVisible();

	/**
	 * Appelle la vue pour que la carte soit placee face cachee
	 */
	public void carteCachee();
	
	/**
	 * Appelle la vue pour que la carte soit mise en dehors du plateau
	 */
	public void carteHorsPlateau();
	
	/**
	 * Previent le modele que la carte a ete cliquee
	 */
	public void carteCliquee();
	
}
