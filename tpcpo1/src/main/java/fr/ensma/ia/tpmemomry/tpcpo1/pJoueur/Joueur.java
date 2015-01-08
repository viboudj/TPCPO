package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

/**
 * Description of Joueur.
 * 
 * @author douaultc
 */
/**
 * Description de la classe abstraite Joueur
 * @author clementdouault
 *
 */
public abstract class Joueur {
	/**
	 * numJoueur : stocke le nombre d'instance de Joueur creees
	 */
	private static int numJoueur=0;
	
	/**
	 * nom : le nom du joueur
	 */
	protected String nom = "";
	
	/**
	 * score : le score du joueur
	 * @see Score
	 */
	private Score score;

	/**
	 * pairesSuccessives : nombre de paires trouvées successivement
	 */
	private int pairesSuccessives = 0;

	/**
	 * Constructeur sans parametre
	 */
	public Joueur() {
		super();
		numJoueur++;
		nom="joueur"+numJoueur;
	}
	
	/**
	 * Constructeur avec parametre
	 * @param nom String : le nom a donner au joueur
	 */
	public Joueur(String nom){
		super();
		numJoueur++;
		this.nom=nom;
	}

	/**
	 * Obtient le nom du joueur
	 * @return nom String : le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Modifie le nom du joueur 
	 * @param newNom String : le nouveau nom du joueur
	 */
	public void setNom(String newNom) {
		this.nom = newNom;
	}

	/**
	 * Obtient le nombre de paires trouvées successivement par le joueur
	 * @return pairesSuccessives int : nombre de paires trouvées successivement
	 */
	public int getpairesSuccessives() {
		return this.pairesSuccessives;
	}

	/**
	 * Modifie le nombre de paires trouvées successivement par le joueur 
	 * @param newpairesSuccessives int : nouveau nombre de paire trouvées successivement
	 */
	public void setpairesSuccessives(int newpairesSuccessives) {
		this.pairesSuccessives = newpairesSuccessives;
	}

	/**
	 * Obtient le score du joueur
	 * @return Score : le score du joueur
	 * @see Score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * Modifie le score du joueur
	 * @param score Score : le nouveau score
	 * @see Score
	 */
	public void setScore(Score score) {
		this.score = score;
	}
	
	/**
	 * Le joueur trouve deux paires identiques
	 */
	public void tourGagne(){
		this.pairesSuccessives++;
		score.updateScore(pairesSuccessives);
	}
	
	/**
	 * Le joueur trouve deux paires differentes
	 */
	public void tourPerdu(){
		this.pairesSuccessives = 0;
	}

}
