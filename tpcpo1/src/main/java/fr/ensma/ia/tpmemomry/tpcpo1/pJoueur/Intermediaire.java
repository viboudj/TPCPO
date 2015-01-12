package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

/**
 * IA d'intelligence intermédiaire
 * 
 * @author douaultc
 */

//non implementee
//idee pour l'implementation : l'IA garde en memoire jusqu'a 4 emplacements de carte
//elle choisit une carte au hasard sur le plateau et regarde si elle a deja une carte similaire en memoire

public class Intermediaire extends IA implements IJoueur {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Intermediaire
	 * @param p Plateau : la reference du plateau de jeu
	 */
	public Intermediaire(Plateau p) {
		super(p);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Intermediaire
	 * @param p Plateau : la reference du plateau de jeu
	 * @param nom String : le nom du joueur
	 */
	public Intermediaire(Plateau p,String nom) {
		super(p,nom);
	}
	
	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	@Override
	public void setNom(String nom) {
		this.nom=nom;
		
	}

	/**
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	@Override
	public Score getScore() {
		return score;
	}

	/**
	 * lance la mise à jour du score du joueur avec un bonus eventuel
	 * @param bonus int : le bonus de score
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
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}
}