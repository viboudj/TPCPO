/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;



/**
 * Description of IA.
 * Classe mère des différentes IA
 * @author douaultc
 */
public abstract class IA {
	
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
	 * Premiere carte selectionnee par l'IA
	 */
	protected ICarte carte1;
	
	/**
	 * Deuxieme carte selectionnee par l'IA
	 */
	protected ICarte carte2;
	
	/**
	 * nombre de paires trouvees successivement dans un meme tour
	 */
	private int nbrPairesSuccessives = 0;
	
	/**
	 * nombre total de paires trouvees par le joueur
	 */
	protected int nbrPairesTrouvees = 0;

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

	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	/**
	 * Obtient la reference de la premiere carte selectionnee par l'IA
	 * @return carte1 ICarte : la premiere carte selectionnee par l'IA
	 */
	public ICarte getCarte1() {
		return carte1;
	}

	/**
	 * Obtient la reference de la deuxieme carte selectionnee par l'IA
	 * @return carte2 ICarte : la deuxieme carte selectionnee par l'IA
	 */
	public ICarte getCarte2() {
		return carte2;
	}

	/**
	 * Obtient le nombre de paires successives trouvee lors d'un meme tour
	 * @return nbrPairesSuccessives int : le nombre de paires successives
	 */
	public int getNbrPairesSuccessives() {
		return nbrPairesSuccessives;
	}
	
	/**
	 * Obtient le nombre total de paires trouvees par le joueur
	 * @return nbrPairesTrouvees int : le nombren total de paires trouvees
	 */
	public int getNbrPairesTrouvees() {
		return nbrPairesTrouvees;
	}

	/**
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * Effectue les actions correspondantes si le joueur n'a pas trouve de paire
	 */
	public void tourPerdu() {
		nbrPairesSuccessives = 0;		
	}

	/**
	 * Effectue les actions correspondantes si le joueur a trouve une paire
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesSuccessives, effetCarte);	
		nbrPairesSuccessives++;
		nbrPairesTrouvees++;
	}
}
