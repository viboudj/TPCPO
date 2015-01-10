package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.exceptions.TransitionImpossibleException;

/**
 * Description de l'etat DeuxCartesSelectionnees de l'automate
 * Pattern Etat
 * 
 * @author douaultc
 */
public class DeuxCartesSelectionnees implements IEtatPlateau {
	
	/**
	 * Reference de l'automate
	 */
	private Plateau plateau;

	/**
	 * Constructeur de l'Žtat DeuxCartesSelectionnees
	 * @param plateau Plateau : reference de l'automate
	 */
	public DeuxCartesSelectionnees(Plateau plateau) {
		super();
		this.plateau=plateau;
	}

	/**
	 * Transition selectCarte1
	 */
	public void selectCarte1() {
		throw new TransitionImpossibleException("Transition impossible");
	}

	/**
	 * Transition selectCarte2
	 */
	public void selectCarte2() {
		throw new TransitionImpossibleException("Transition impossible");
	}

	/**
	 * Transition comparaisonCartes
	 */
	public void comparaisonCartes() {
		
		plateau.setEtatCourant(plateau.getpasCarteSelectionnee());
		
		plateau.getCarte1().setVisible(false);
		plateau.getCarte2().setVisible(false);
		
		plateau.setCarte1(null);
		plateau.setCarte2(null);
	}

}
