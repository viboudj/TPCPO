/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
// Start of user code (user defined imports)
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

// End of user code

/**
 * Description of Expert.
 * 
 * @author douaultc
 */
public class Expert extends IA implements IJoueur {
	// Start of user code (user defined attributes for Expert)

	// End of user code

	/**
	 * The constructor.
	 */
	public Expert(Plateau p) {
		// Start of user code constructor for Expert)
		super(p);
		// End of user code
	}

	@Override
	public String getNom() {
		return nom;
	}


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
