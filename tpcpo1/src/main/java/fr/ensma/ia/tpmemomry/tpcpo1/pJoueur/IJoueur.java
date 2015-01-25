package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;

/**
 * Interface regroupant les comportements des cartes sans et avec effet
 * Pattern Strategy
 * 
 * @author viboudj
 */

public interface IJoueur {
	
	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	public String getNom();
	
	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	public void setNom(String nom);
	
	/**
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	public Score getScore();
	
	/**
	 * Obtient la reference de la premiere carte selectionnee par l'IA
	 * @return carte1 ICarte : la premiere carte selectionnee par l'IA
	 */
	public ICarte getCarte1();
	
	/**
	 * Obtient la reference de la deuxieme carte selectionnee par l'IA
	 * @return carte2 ICarte : la deuxieme carte selectionnee par l'IA
	 */
	public ICarte getCarte2();
	
	/**
	 * Obtient le nombre de paires successives trouvee lors d'un meme tour
	 * @return nbrPairesSuccessives int : le nombre de paires successives
	 */
	public int getNbrPairesSuccessives();
	
	/**
	 * Obtient le nombre total de paires trouvees par le joueur
	 * @return nbrPairesTrouvees int : le nombren total de paires trouvees
	 */
	public int getNbrPairesTrouvees();
	
	/**
	 * lance le jeu des joueur IA
	 */
	public void jouer() ;
	
	/**
	 * traitement du tour perdu du joueur
	 */
	public void tourPerdu();
	
	/**
	 * traitement du tour gagné du joueur
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	public void tourGagne(int effetCarte);

}
