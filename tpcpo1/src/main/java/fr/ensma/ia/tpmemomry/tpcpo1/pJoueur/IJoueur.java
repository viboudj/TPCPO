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
	 * lance la mise à jour du score du joueur avec un bonus eventuel
	 * @param bonus int : le bonus de score
	 */
	public void updateScore(int bonus);
	
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
