/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;



/**
 * Description of IA.
 * Classe m�re des diff�rentes IA
 * @author douaultc
 */
public abstract class IA implements IJoueur {
	
	/**
	 * nombre d'IA ipl�ment�es
	 */
	private static int numInstance = 0;
	
	/**
	 * nom de l'IA
	 */	
	protected String nom;
	
	/**
	 * score de l'IA
	 */
	protected Score score;
	
	/**
	 * Connaissance du plateau par l'IA 
	 */
	protected Plateau plateau;
	
	/**
	 * nombre de paire d'affil�es trouv�es
	 */
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
