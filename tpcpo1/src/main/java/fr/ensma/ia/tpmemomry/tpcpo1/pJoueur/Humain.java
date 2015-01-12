package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;


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

	/**
	 * Constructeur sans parametre
	 * Cree une instance de Humain
	 */
	public Humain() {
		super();
		numInstanceHumain++;
		this.nom= "Joueur humain " +numInstanceHumain;
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

	/**
	 * lance le jeu des joueur IA
	 */
	@Override
	public void jouer() {
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
		nbrPairesSuccessives++;
		nbrPairesTrouvees++;
		this.score.updateScore(nbrPairesSuccessives, effetCarte);
		
	}
}
