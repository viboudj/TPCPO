package fr.ensma.ia.tpmemomry.tpcpo1;

import java.util.ArrayList;
import java.util.HashSet;

import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.PairesRestantes;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.FinPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;

/**
 * Classe modelisant une partie de memory
 * 
 * @author douaultc
 */
public class Partie {
	
	/**
	 * Le plateau de jeu
	 */
	private Plateau plateau;
	
	/**
	 * Nombre de symboles de carte differents 
	 */
	private int nbrSymboles;
	
	/**
	 * Nombre de cartes par symbole
	 */
	private int nbrPairesParSymboles;
	
	/**
	 * Nombre de joueurs jouant une partie
	 */
	private int nbrJoueur = 0;
	
	/**
	 * Liste des joueurs jouant une partie
	 */
	public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	
	/**
	 * Joueur courant
	 */
	private Joueur joueurCourant = null;
	
	/**
	 * Compteur suivant le nombre de tours joues dans la partie
	 */
	private int nbrTourJoue = 0;
	
	/**
	 * Instances de l'état pairesRestantes
	 */
	private IEtatPartie pairesRestantes;
	
	/**
	 * Instances de l'état finPartie
	 */
	private IEtatPartie finPartie;
	
	/**
	 * Etat actuel de la partie
	 */
	private IEtatPartie etatCourantPartie;

	/**
	 * Constructeur sans parametre
	 * Cree une nouvelle partie avec des parametres par default (8 symboles, 2 paires par symbole)
	 */
	public Partie() {
		super();
		nbrSymboles = 8;
		nbrPairesParSymboles = 2;
		plateau = new Plateau(this, nbrSymboles, nbrPairesParSymboles);
		
		listeJoueurs = new ArrayList<Joueur>();
		
		etatCourantPartie = pairesRestantes;	
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une nouvelle partie avec des parametres personnalisés
	 * @param nbrSymboles int : nombre de symboles differents
	 * @param nbrPairesParSymbole int : nombre de paires par symbole
	 */
	public Partie(int nbrSymboles, int nbrPairesParSymbole) {
		super();
		this.nbrSymboles = nbrSymboles;
		this.nbrPairesParSymboles = nbrPairesParSymbole;
		plateau = new Plateau(this, nbrSymboles, nbrPairesParSymboles);
		
		listeJoueurs = new ArrayList<Joueur>();
		
		etatCourantPartie = pairesRestantes;
	}

	/**
	 * Obtient le nombre de joueurs jouant a la partie
	 * @return nbrJoueur int : le nombre de joueurs
	 */
	public int getNbrJoueur() {
		return this.nbrJoueur;
	}

	/**
	 * Modifie le nombre de joueurs jouant a la partie
	 * @param newNbrJoueur int : le nouveau nombre de joueurs
	 */
	public void setNbrJoueur(int newNbrJoueur) {
		this.nbrJoueur = newNbrJoueur;
	}
	
	/**
	 * Obtient la liste des joueurs jouant une partie
	 * @return listeJoueurs ArrayList : la liste des joueurs
	 * @see Joueur
	 */
	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	
	/**
	 * Ajout d'un joueur a la liste des joueurs
	 * @param joueur : le joueur a ajouter a la liste
	 * @see Joueur
	 */
	public void ajouterJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}

	/**
	 * Obtient la reference du joueur courant
	 * @return joueurCourant Joueur : le joueur courant
	 * @see Joueur
	 */
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	/**
	 * Modifie le joueur courant
	 * @param joueurCourant Joueur : le nouveau joueur courant
	 * @see Joueur
	 */
	public void setJoueurCourant(Joueur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
	
	/**
	 * Modifie joueurCourant en selectionnant le joueur suivant dans la listeJoueurs
	 * Si joueurCourant est le dernier de la listeJoueurs, le suivant est le premier joueur de la listeJoueurs
	 */
	public void joueurSuivant() {
		int _suivant = 0;
		
		if(listeJoueurs.indexOf(joueurCourant) == listeJoueurs.size()) {
			_suivant = 0;
		} else {
			_suivant = listeJoueurs.indexOf(joueurCourant)+1;
		}
		
		joueurCourant = listeJoueurs.get(_suivant);
	}

	/**
	 * Obtient le nombre de tours de jeu durant la partie
	 * @return nbrTourJoue int : le nombre de tours de jeu
	 */
	public int getNbrTourJoue() {
		return this.nbrTourJoue;
	}

	/**
	 * Modifie le nombre de tours de jeu durant la partie
	 * @param newNbrTourJoue int : le nouveau nombre de tours de jeu
	 */
	public void setNbrTourJoue(int newNbrTourJoue) {
		this.nbrTourJoue = newNbrTourJoue;
	}

	public void paireCartesIdentiques() {
		etatCourantPartie.paireTrouvee();
	}
	
	public void paireCartesDifferentes() {
		etatCourantPartie.pasPaireTrouvee();
	}
	
	public void traitementPaireTrouvee() {
		joueurCourant.tourGagne();
		
		plateau.getCarte1().setSurPlateau(false);
		plateau.getCarte2().setSurPlateau(false);
		plateau.setNbrCartesRestantes(plateau.getNbrCartesRestantes()-2);
	}
	
	/**
	 * Obtient l'instance de l'etat PairesRestantes
	 * @return pairesRestantes IEtatPartie
	 */
	public IEtatPartie getPairesRestantes() {
		return pairesRestantes;
	}
	
	/**
	 * Obtient l'instance de l'etat FinPartie
	 * @return finPartie IEtatPartie
	 */
	public IEtatPartie getFinPartie() {
		return finPartie;
	}
	
	/**
	 * Obtient l'etat courant de la partie
	 * @return etatCourantPartie IEtatPartie : l'etat courant
	 */
	public IEtatPartie getEtatCourantPartie() {
		return etatCourantPartie;
	}
	
	/**
	 * Modifie l'etat courant de la partie
	 * @param newEtatCourant IEtatCourant : le nouvel etat courant
	 */
	public void setEtatCourantPartie(IEtatPartie newEtatCourant) {
		this.etatCourantPartie = newEtatCourant;
	}
}