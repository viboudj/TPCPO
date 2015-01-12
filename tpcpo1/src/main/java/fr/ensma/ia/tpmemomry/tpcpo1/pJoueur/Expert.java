package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

/**
 * IA experte dans le jeu 
 * @author douaultc
 */

// non implementee
// idee pour l'implementation : l'IA garde en memoire jusqu'a 10 emplacements de carte
// elle choisit une carte au hasard sur le plateau et regarde si elle a deja une carte similaire en memoire

public class Expert extends IA implements IJoueur {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Stupide
	 * @param p Plateau
	 */
	public Expert(Plateau p) {
		super(p);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Stupide
	 * @param p Plateau
	 * @param nom String
	 */
	public Expert(Plateau p,String nom) {
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
