/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
// Start of user code (user defined imports)
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

// End of user code

/**
 * Description of Stupide.
 * 
 * @author douaultc
 */
public class Stupide extends IA implements IJoueur{
	// Start of user code (user defined attributes for Stupide)

	// End of user code

	/**
	 * The constructor.
	 */
	public Stupide(Plateau p) {
		super(p);
	}
	
	public Stupide(String nom,Plateau p) {
		super(p,nom);
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

	

}
