package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

/**
 * Description de la classe Score
 * @author clementdouault
 *
 */
public class Score {

	/**
	 * Reference du joueur ayant ce score
	 */
	private Joueur joueur;
	
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
	 * Constructeur avec parametre
	 * @param joueur Joueur : reference du joueur possedant ce score
	 * @see Joueur
	 */
	public Score(Joueur joueur) {
		this.setJoueur(joueur);
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
	 * Obtient le joueur possedant ce score
	 * @return Joueur : le joueur possedant ce score
	 * @see Joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * Modifie le joueur possedant ce score
	 * @param joueur Joueur : le nouveau joueur possedant ce score
	 * @see Joueur
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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
