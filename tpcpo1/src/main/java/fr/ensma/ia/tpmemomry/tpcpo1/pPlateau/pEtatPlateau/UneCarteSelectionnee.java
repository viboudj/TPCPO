package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.exceptions.TransitionImpossibleException;

/**
 * Description de l'etat UneCarteSelectionnee de l'automate
 * Pattern Etat 
 * 
 * @author douaultc
 */
public class UneCarteSelectionnee implements IEtatPlateau {
	/**
	 * Reference de l'automate
	 */
	private Plateau plateau;

	/**
	 * Constructeur de l'Žtat UneCarteSelectionnee
	 * @param plateau Plateau : reference de l'automate 
	 */
	public UneCarteSelectionnee(Plateau plateau) {
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
		if(plateau.getCarte2()!=null 
				&& plateau.getCarte2()!=plateau.getCarte1()) {
			plateau.getCarte2().setVisible(true);
			plateau.setEtatCourant(plateau.getdeuxCartesSelectionnees());
		} else {
			System.out.println("changement d'etat une carte visible sur le plateau a deux cartes visibles sur le plateau: bloque!");
		}
	}

	/**
	 * Transition comparaisonCartes
	 */
	public void comparaisonCartes() {
		throw new TransitionImpossibleException("Transition impossible");
	}

}
