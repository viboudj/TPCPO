/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
// Start of user code (user defined imports)
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

// End of user code

/**
 * Description of Intermediaire.
 * 
 * @author douaultc
 */
public class Intermediaire extends IA implements IJoueur {
	// Start of user code (user defined attributes for Intermediaire)

	// End of user code

	/**
	 * The constructor.
	 */
	public Intermediaire(Plateau p) {
		super(p);
	}
	
	public Intermediaire(Plateau p,String nom) {
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
