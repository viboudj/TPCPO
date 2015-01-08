/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Joueur.
 * 
 * @author douaultc
 */
public abstract class Joueur {
	/**
	 * Description of the property nom.
	 */
	
	private static int numJoueur=0;
	
	private String nom = "";
	
	private Score score;

	/**
	 * Description of the property nbrTourRejoue.
	 */
	private int nbrTourRejoue = 0;

	// Start of user code (user defined attributes for Joueur)

	// End of user code

	/**
	 * The constructor.
	 */
	public Joueur() {
		// Start of user code constructor for Joueur)
		super();
		numJoueur++;
		nom="joueur"+numJoueur;
		// End of user code
	}
	
	public Joueur(String nom){
		super();
		numJoueur++;
		this.nom=nom;
	}


	// Start of user code (user defined methods for Joueur)

	// End of user code
	/**
	 * Returns nom.
	 * @return nom 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Sets a value to attribute nom. 
	 * @param newNom 
	 */
	public void setNom(String newNom) {
		this.nom = newNom;
	}

	/**
	 * Returns nbrTourRejoue.
	 * @return nbrTourRejoue 
	 */
	public int getNbrTourRejoue() {
		return this.nbrTourRejoue;
	}

	/**
	 * Sets a value to attribute nbrTourRejoue. 
	 * @param newNbrTourRejoue 
	 */
	public void setNbrTourRejoue(int newNbrTourRejoue) {
		this.nbrTourRejoue = newNbrTourRejoue;
	}


	public Score getScore() {
		return score;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	public static int getNumJoueur() {
		return numJoueur;
	}


	public static void setNumJoueur(int numJoueur) {
		Joueur.numJoueur = numJoueur;
	}
	
	
	public void tourGagne(){
		this.nbrTourRejoue++;
		score.updateScore(nbrTourRejoue);
	}
	
	public void tourPerdu(){
		this.nbrTourRejoue = 0;
	}

}
