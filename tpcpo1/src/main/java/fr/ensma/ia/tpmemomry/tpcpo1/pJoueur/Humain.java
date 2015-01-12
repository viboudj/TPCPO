package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;


/**
 * joueur humain
 * @author clementdouault
 * @see Joueur
 *
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
	 * nombre de paire trouvée par le joueur
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
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	@Override
	public Score getScore() {
		return score;
	}

	/**
	 * lance la mise à jour du score du joueur avec un bonus eventuel
	 * @param bonus int : le bonus de score
	 */
	@Override
	public void updateScore(int bonus) {
		score.updateScore(nbrPairesTrouvees, bonus);
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
		this.nbrPairesTrouvees=0;
		
	}

	/**
	 * traitement du tour gagné du joueur
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}
}
