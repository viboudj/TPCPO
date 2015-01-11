/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

/**
 * IA d'intelligence intermédiaire
 * 
 * @author douaultc
 */

//non implémentée
public class Intermediaire extends IA implements IJoueur {

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

	@Override
	public void tourPerdu() {
		this.nbrPairesTrouvees=0;
		
	}

	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}

	
}
