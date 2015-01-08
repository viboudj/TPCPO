/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau;


import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of PasCarte.
 * 
 * @author douaultc
 */
public class PasCarte implements IEtatPlateau {
	/**
	 * Description of the property plateau.
	 */
	private Plateau plateau = null;

	// Start of user code (user defined attributes for PasCarte)

	// End of user code

	/**
	 * The constructor.
	 */
	public PasCarte(Plateau p) {
		// Start of user code constructor for PasCarte)
		super();
		plateau =p;
		// End of user code
	}

	/**
	 * Description of the method selectCarte1.
	 */
	public void selectCarte1() {
		if(plateau.getCarte1()!=null){
			plateau.setEtatCourant(plateau.getEtatUneCarte());
			plateau.getCarte1().setVisible(true);
		} else {
			System.out.println("changement d'état pas de carte visible sur le plateau à une carte visible sur le plateau: bloqué!");
		}

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
		// Start of user code for method retourDebut
		// End of user code
	}

	// Start of user code (user defined methods for PasCarte)

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
