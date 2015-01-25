package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import java.util.ArrayList;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;

/**
 * IA d'intelligence intermediaire.</br>
 * Peut retenir jusqu'a 2 cartes du plateau et composer avec elles.
 * 
 * @author douaultc
 */
public class Intermediaire extends IA implements IJoueur {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Intermediaire
	 * @param p Plateau : la reference du plateau de jeu
	 */
	public Intermediaire(Plateau p) {
		super(p);
		capaciteMemoire = 4;
		cartesEnMemoire = new ArrayList<ICarte>(capaciteMemoire);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Intermediaire
	 * @param p Plateau : la reference du plateau de jeu
	 * @param nom String : le nom du joueur
	 */
	public Intermediaire(Plateau p,String nom) {
		super(p,nom);
		capaciteMemoire = 4;
		cartesEnMemoire = new ArrayList<ICarte>(capaciteMemoire);
	}
}