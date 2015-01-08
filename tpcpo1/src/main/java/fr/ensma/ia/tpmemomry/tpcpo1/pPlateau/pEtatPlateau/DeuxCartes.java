/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;


import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of DeuxCartes.
 * 
 * @author douaultc
 */
public class DeuxCartes implements IEtatPlateau {
	/**
	 * Description of the property plateau.
	 */
	private Plateau plateau = null;

	// Start of user code (user defined attributes for DeuxCartes)

	// End of user code

	/**
	 * The constructor.
	 */
	public DeuxCartes(Plateau p) {
		// Start of user code constructor for DeuxCartes)
		super();
		plateau=p;
		// End of user code
	}

	/**
	 * Description of the method selectCarte1.
	 */
	public void selectCarte1() {
		// Start of user code for method selectCarte1
		// End of user code
	}

	/**
	 * Description of the method selectCarte2.
	 */
	public void selectCarte2() {
		// Start of user code for method selectCarte2
		// End of user code
	}

	/**
	 * Description of the method retourDebut.
	 */
	public void retourDebut() {
		plateau.getCarte1().setVisible(false);
		plateau.getCarte2().setVisible(false);
		plateau.setEtatCourant(plateau.getEtatPasCarte());
		plateau.setCarte1(null);
		plateau.setCarte2(null);
	}

	// Start of user code (user defined methods for DeuxCartes)

	// End of user code
	/**
	 * Returns plateau.
	 * @return plateau 
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * Sets a value to attribute plateau. 
	 * @param newPlateau 
	 */
	public void setPlateau(Plateau newPlateau) {
		this.plateau = newPlateau;
	}

}
