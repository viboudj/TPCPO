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
	 * lance le jeu des joueur IA
	 */
	@Override
	public void jouer() {
	}
}