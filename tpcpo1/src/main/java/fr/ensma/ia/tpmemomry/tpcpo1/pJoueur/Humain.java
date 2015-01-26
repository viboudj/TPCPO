package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;

/**
 * joueur humain
 * @author clementdouault
 * @see IJoueur
 */
public class Humain implements IJoueur {
	
	/**
	 * nom du joueur
	 */
	private String nom;
	/**
	 * nombre de joueur humain
	 */
	private static int numInstanceHumain = 0;
	
	/**
	 * score du joueur
	 */
	private Score score;
	
	/**
	 * nombre de paires trouvees successivement dans un meme tour
	 */
	private int nbrPairesSuccessives = 0;
	
	/**
	 * nombre total de paires trouvees par le joueur
	 */
	private int nbrPairesTrouvees=0;

	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur sans parametre
	 * Cree une instance de Humain
	 */
	public Humain() {
		super();
		numInstanceHumain++;
		this.nom= "Humain " +numInstanceHumain;
		score = new Score();
		}
	
	/**
	 * Constructeur a un parametre
	 * Cree une instance de Humain
	 * @param nom String : le nom du joueur
	 */
	public Humain(String nom){
		super();
		numInstanceHumain++;
		this.nom=nom;
		score = new Score();
	}

	// -- COMPORTEMENT -- //
	
	@Override
	public void majMemoireIA() {
	}

	@Override
	public void jouer() {
	}
	
	@Override
	public ICarte getCarte1() {
		return null;
	}
	
	@Override
	public ICarte getCarte2() {
		return null;
	}

	/**
	 * traitement du tour perdu du joueur
	 */
	@Override
	public void tourPerdu() {
		nbrPairesSuccessives = 0;		
	}

	/**
	 * traitement du tour gagné du joueur
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesSuccessives, effetCarte);
		nbrPairesSuccessives++;
		nbrPairesTrouvees++;
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	@Override
	public void setNom(String nom) {
		this.nom=nom;
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
	@Override
	public Score getScore() {
		return score;
	}
}
