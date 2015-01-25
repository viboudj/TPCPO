package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.niveauIA;

import java.util.ArrayList;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IJoueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;

/**
 * IA experte dans le jeu.</br>
 * Peut retenir jusqu'a 6 cartes du plateau et composer avec elles.
 * @author douaultc
 */
public class Expert extends IA implements IJoueur {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Expert
	 * @param p Plateau : la reference du plateau de jeu
	 */
	public Expert(Plateau p) {
		super(p);
		capaciteMemoire = 6;
		cartesEnMemoire = new ArrayList<ICarte>(capaciteMemoire);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Expert
	 * @param p Plateau : la reference du plateau de jeu
	 * @param nom String : le nom du joueur
	 */
	public Expert(Plateau p,String nom) {
		super(p,nom);
		capaciteMemoire = 6;
		cartesEnMemoire = new ArrayList<ICarte>(capaciteMemoire);
	}
}
