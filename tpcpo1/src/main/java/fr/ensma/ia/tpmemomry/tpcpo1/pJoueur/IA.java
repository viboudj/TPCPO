/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of IA.
 * 
 * @author douaultc
 */
public abstract class IA implements IJoueur {
	// Start of user code (user defined attributes for IA)
	private static int numInstance = 0;
	
	protected String nom;
	
	protected Score score;
	
	protected Plateau plateau;
	
	protected int nbrPairesTrouvees=0;

	/**
	 * The constructor.
	 */
	public IA(Plateau p) {
		super();
		numInstance++;
		nom = "IA " + numInstance;
		score = new Score();
		plateau=p;
	}
	
	public IA(Plateau p,String nom) {
		super();
		numInstance++;
		this.nom=nom;
		score = new Score();
		plateau=p;
	}


	

}
