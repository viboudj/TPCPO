/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;



/**
 * Description of IA.
 * Classe mère des différentes IA
 * @author douaultc
 */
public abstract class IA implements IJoueur {
	
	/**
	 * nombre d'IA iplémentées
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
	 * nombre de paire d'affilées trouvées
	 */
	protected int nbrPairesTrouvees=0;

	/**
	 * Constructeur a un parametre
	 * @param p Plateau : la reference du plateau
	 */
	public IA(Plateau p) {
		super();
		numInstance++;
		nom = "IA " + numInstance;
		score = new Score();
		plateau=p;
	}
	
	/**
	 * Constructeur a deux parametres
	 * @param p Plateau : la reference du plateau
	 * @param nom String : le nmo du joueur
	 */
	public IA(Plateau p,String nom) {
		super();
		numInstance++;
		this.nom=nom;
		score = new Score();
		plateau=p;
	}


	

}
