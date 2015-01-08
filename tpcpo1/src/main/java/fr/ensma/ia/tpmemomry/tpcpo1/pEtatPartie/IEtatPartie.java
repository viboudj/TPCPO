package fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie;

/**
 * Interface representant un etat de l'automate partie
 * Pattern Etat
 * 
 * @author douaultc
 */
public interface IEtatPartie {

	/**
	 * Transition paireTrouvee de l'automate
	 */
	public void paireTrouvee();
	
	/**
	 * Transition pasPaireTrouvee de l'automate
	 */
	public void pasPaireTrouvee();

	/**
	 * Transition plusPairePossible de l'automate
	 */
	public void plusPairePossible();

}
