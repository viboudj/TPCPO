/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;


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
	
	private String nom;
	
	private Score score;

	/**
	 * The constructor.
	 */
	public IA() {
		super();
		numInstance++;
		nom = "IA " + numInstance;
		score = new Score();
	}
	
	public IA(String nom) {
		super();
		numInstance++;
		this.nom=nom;
		score = new Score();
	}
	
	/**
	 * Description of the method jouer.
	 */
	public void  jouer() {

	}


	// Start of user code (user defined methods for IA)

	// End of user code

}
