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
	

	

}
