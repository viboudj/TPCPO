package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

/**
 * score du joueur
 * @author clementdouault
 *
 */
public class Score {

	/**
	 * Reference du joueur ayant ce score
	 */
	
	/**
	 * la valeur du score
	 */
	private int score = 0;

	/**
	 * Constructeur sans parametre
	 */
	public Score() {
		super();
	}
	
	/**
	 * Obtient la valeur du score
	 * @return int : la valeur du score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Modifie la valeur du score
	 * @param score int : la nouvelle valeur du score
	 */
	public void setScore(int score) {
		this.score = score;
	}


	/**
	 * Calcul de la valeur du score en fonction du nombre de paires successivement trouvées par le joueur
	 * @param pairesSuccessives int : le nombre de paires successivement trouvées
	 */
	public void updateScore(int pairesSuccessives, int bonus){
		if(pairesSuccessives==0){
			this.score=this.score+2;
		} else {
			this.score=this.score+(2+(pairesSuccessives*2-1));
		}
		score = score + bonus;
	}
	
}
