package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;

/**
 * Description de la classe Humaine, classe fille de Joueur
 * @author clementdouault
 * @see Joueur
 *
 */
public class Humain extends Joueur {

	private static int numInstanceHumain = 0;
	
	/**
	 * Constructeur sans parametre
	 */
	public Humain() {
		super("Joueur humain "+ ++numInstanceHumain);
	}
	
	/**
	 * Constucteur avec parametre
	 * @param nom String : le nouveau du joueur humain
	 */
	public Humain(String nom){
		super(nom);
	}

}
