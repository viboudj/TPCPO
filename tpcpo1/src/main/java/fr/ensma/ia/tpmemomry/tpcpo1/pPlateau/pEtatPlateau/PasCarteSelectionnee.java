package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.exceptions.TransitionImpossibleException;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;

/**
 * Description de l'etat PasCarteSelectionnee de l'automate
 * Pattern Etat
 * 
 * @author douaultc
 */
public class PasCarteSelectionnee implements IEtatPlateau {
	
	/**
	 * Reference de l'automate
	 */
	private Plateau plateau;
	
	/**
	 * Constructeur de l'Žtat PasCarteSelectionnee
	 * @param plateau Plateau : reference de l'automate 
	 */
	public PasCarteSelectionnee(Plateau plateau) {
		super();
		this.plateau =plateau;
	}

	/**
	 * Transition selectCartes2
	 */
	public void selectCarte1() {
		if(plateau.getCarte1()!=null){
			plateau.setEtatCourant(plateau.getuneCarteSelectionnee());
			plateau.getCarte1().setVisible(true);
		} else {
			System.out.println("changement d'etat pas de carte visible sur le plateau a une carte visible sur le plateau: bloque!");
		}

	}

	/**
	 * Transition selectCartes2
	 */
	public void selectCarte2() {
		throw new TransitionImpossibleException("Transition impossible");
	}

	/**
	 * Transition comparaisonCartes
	 */
	public void comparaisonCartes() {
		throw new TransitionImpossibleException("Transition impossible");
	}

}
