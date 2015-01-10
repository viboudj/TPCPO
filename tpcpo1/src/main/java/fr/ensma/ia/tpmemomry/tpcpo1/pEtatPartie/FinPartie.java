package fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie;

import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.exceptions.TransitionImpossibleException;

/**
 * Description de l'Žtat FinPartie de l'automate
 * Pattern Etat
 *  
 * @author douaultc
 */
public class FinPartie implements IEtatPartie {
	
	/**
	 * Reference de l'automate
	 */
	private Partie partie;

	/**
	 * Constructeur de l'Etat FinPartie
	 * @param partie Partie : reference de l'automate
	 */
	public FinPartie(Partie partie) {
		super();
		this.partie = partie;
	}

	/**
	 * Transition paireTrouvee
	 */
	public void paireTrouvee(){
		throw new TransitionImpossibleException("Transition impossible");
	}

	/**
	 * Transition pasPaireTrouvee
	 */
	public void pasPaireTrouvee(){
		throw new TransitionImpossibleException("Transition impossible");
	}
	
	/**
	 * Transition plusPairePossible
	 */
	public void plusPairePossible(){
		throw new TransitionImpossibleException("Transition impossible");
	}

}
