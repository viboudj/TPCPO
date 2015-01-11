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
	 */
	public Humain() {
		super();
		numInstanceHumain++;
		this.nom= "Joueur humain " +numInstanceHumain;
		score = new Score();
		}
	
	/**
	 * Constucteur avec parametre
	 * @param nom String : le nouveau du joueur humain
	 */
	public Humain(String nom){
		super();
		numInstanceHumain++;
		this.nom=nom;
		score = new Score();
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom=nom;
	}

	@Override
	public Score getScore() {
		return score;
	}

	@Override
	public void updateScore(int bonus) {
		score.updateScore(nbrPairesTrouvees, bonus);
	}

	@Override
	public void jouer() {
	}

	@Override
	public void tourPerdu() {
		this.nbrPairesTrouvees=0;
		
	}

	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}
	

	

}
