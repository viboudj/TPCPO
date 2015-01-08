package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;

/**
 * Interface representant un etat de l'automate plateau
 * 
 * @author douaultc
 */
public interface IEtatPlateau {

	/**
	 * Transition selectCarte1 de l'automate
	 */
	public void selectCarte1();

	/**
	 * Transition selectCarte2 de l'automate
	 */
	public void selectCarte2();

	/**
	 * Transition comparaisonCartes de l'automate
	 */
	public void comparaisonCartes();

}
