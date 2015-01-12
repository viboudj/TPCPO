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
	 * Constructeur a un parametre
	 * Cree une instance de Stupide
	 */
	public Intermediaire(Plateau p) {
		super(p);
	}
	
	/**
	 * 
	 * @param p
	 * @param nom
	 */
	public Intermediaire(Plateau p,String nom) {
		super(p,nom);
	}

	/**
	 * donne le nom du joueur
	 * @return nom du joueur
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * installe le nom du joueur
	 * @param String
	 */
	@Override
	public void setNom(String nom) {
		this.nom=nom;
		
	}

	/**
	 * donne le score du joueur
	 * @return classe score du joueur
	 */
	@Override
	public Score getScore() {
		return score;
	}

	/**
	 * lance la mise à jour du score du joueur
	 * @param bonus au score
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
	 */
	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}
}
