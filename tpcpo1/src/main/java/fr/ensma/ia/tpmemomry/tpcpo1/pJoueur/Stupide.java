package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import java.util.ArrayList;
import java.util.Random;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;


/**
 * IA n'ayant pas compris les règles du jeu
 * selectionne au hasard des cartes
 * 
 * @author douaultc
 */
public class Stupide extends IA implements IJoueur{

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Stupide
	 * @param p Plateau : la reference du plateau de jeu
	 */
	public Stupide(Plateau p) {
		super(p);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Stupide
	 * @param p Plateau : la reference du plateau de jeu
	 * @param nom String : le nom du joueur
	 */
	public Stupide(Plateau p,String nom) {
		super(p,nom);
		capaciteMemoire = 0;
	}
	
	/**
	 * Override de la methode de la classe mere car inutile pour l'IA stupide
	 */
	@Override
	public void majMemoireIA() {
	}
	
	/**
	 * Selectionne deux cartes au hasard sur le plateau
	 */
	@Override
	public void jouer() {
		// liste servant a retenir les cartes potentiellement selectionnables
		ArrayList<ICarte> listeCartesPossibles = new ArrayList<ICarte>();
		// sert a choisir une carte aleatoirement parmis celles selectionnables
		Random random = new Random();
		
		//enregistrement des cartes pouvant etre selectionnees
		for(int i=0 ; i<plateau.getListeCartesMelangees().size() ; i++) {
			if (plateau.getListeCartesMelangees().get(i).getSurPlateau() == true) {
				listeCartesPossibles.add(plateau.getListeCartesMelangees().get(i));
			}
		}
		
		// choix aleatoire de la premiere carte
		carte1 =listeCartesPossibles.get(random.nextInt(listeCartesPossibles.size()));
		
		//choix aleatoire de la seconde carte
		listeCartesPossibles.remove(carte1);
		carte2 =listeCartesPossibles.get(random.nextInt(listeCartesPossibles.size()));
		
		plateau.setCartesSelectionnees(true);
	}
}
