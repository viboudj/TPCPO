package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

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
