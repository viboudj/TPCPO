package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;


/**
 * Description de la classe Humaine, classe fille de Joueur
 * @author clementdouault
 * @see Joueur
 *
 */
public class Humain implements IJoueur {
	
	private String nom;

	private static int numInstanceHumain = 0;
	
	private Score score;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Score getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}

}
