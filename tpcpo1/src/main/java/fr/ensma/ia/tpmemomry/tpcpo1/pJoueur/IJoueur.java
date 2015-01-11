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
	 * @return nom du joueur
	 */
	public String getNom();
	
	/**
	 * installe le nom du joueur
	 * @param String
	 */
	public void setNom(String nom);
	
	/**
	 * donne le score du joueur
	 * @return classe score du joueur
	 */
	public Score getScore();
	
	/**
	 * lance la mise à jour du score du joueur
	 * @param bonus au score
	 */
	public void updateScore(int bonus);
	
	/**
	 * lance e jeu des joueur IA
	 */
	public void jouer() ;
	
	/**
	 * traitement du tour perdu du joueur
	 */
	public void tourPerdu();
	
	/**
	 * traitement du tour gagné du joueur
	 */
	public void tourGagne(int effetCarte);

}
