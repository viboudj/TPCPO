package fr.ensma.ia.tpmemomry.tpcpo1;

import java.util.ArrayList;

import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

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
	private int nbrJoueurs = 0;
	
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
	private int nbrToursJoues = 0;
	
	/**
	 * Instances de l'Etat pairesRestantes
	 */
	private IEtatPartie pairesRestantes = new PairesRestantes(this);
	
	/**
	 * Instances de l'état finPartie
	 */
	private IEtatPartie finPartie = new FinPartie(this);
	
	/**
	 * Etat actuel de la partie
	 */
	private IEtatPartie etatCourantPartie = null;
	
	// -- CONSTRUCTEURS -- //

	/**
	 * Constructeur sans parametre
	 * Cree une nouvelle partie avec des parametres par default (8 symboles, 2 paires par symbole)
	 * Plus une probabilite de 20% d'avoir des paires bonus
	 */
	public Partie() {
		super();
		nbrSymboles = 8;
		nbrPairesParSymboles = 2;
		plateau = new Plateau(this, nbrSymboles, nbrPairesParSymboles, true, 2);
		
		listeJoueurs = new ArrayList<Joueur>();
		
		etatCourantPartie = pairesRestantes;	
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une nouvelle partie avec des parametres personnalisés
	 * @param nbrSymboles int : nombre de symboles differents
	 * @param nbrPairesParSymbole int : nombre de paires par symbole
	 */
	public Partie(int nbrSymb, int nbrPairesParSymb, boolean pairesBonus, int probabiliteBonus) {
		super();
		this.nbrSymboles = nbrSymb;
		this.nbrPairesParSymboles = nbrPairesParSymb;
		plateau = new Plateau(this, nbrSymboles, nbrPairesParSymboles, pairesBonus, probabiliteBonus);
		
		listeJoueurs = new ArrayList<Joueur>();
		
		etatCourantPartie = pairesRestantes;
	}
	
	// -- GETTEURS ET SETTEURS -- //

	/**
	 * Obtient l'instance du plateau de jeu
	 * @return plateu Plateau : le plateau de jeu
	 * @see Plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * Modifie l'instance du plateau de jeu
	 * @param plateau Plateau : le nouveau plateau de jeu
	 * @see Plateau
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	/**
	 * Obtient le nombre de symboles de carte differents dans la partie
	 * @return nbrSymbole int : le nombre de symboles de carte
	 */
	public int getNbrSymboles() {
		return nbrSymboles;
	}

	/**
	 * Modifie le nombre de symboles de carte differents dans la partie
	 * @param nbrSymboles int : le nouveau nombre de symboles
	 */
	public void setNbrSymboles(int nbrSymboles) {
		this.nbrSymboles = nbrSymboles;
	}

	/**
	 * Obtient le nombre de paires par symbole dans la partie
	 * @return nbrPairesParSymboles int : le nombre de paires par symbole
	 */
	public int getNbrPairesParSymboles() {
		return nbrPairesParSymboles;
	}

	/**
	 * Modifie le nombre de paires par symbole dans la partie
	 * @param nbrPairesParSymboles int : le nouveau nombre de paires par symbole
	 */
	public void setNbrPairesParSymboles(int nbrPairesParSymboles) {
		this.nbrPairesParSymboles = nbrPairesParSymboles;
	}

	/**
	 * Obtient le nombre de joueurs jouant a la partie
	 * @return nbrJoueurs int : le nombre de joueurs
	 */
	public int getNbrJoueurs() {
		return this.nbrJoueurs;
	}

	/**
	 * Modifie le nombre de joueurs jouant a la partie
	 * @param newNbrJoueurs int : le nouveau nombre de joueurs
	 */
	private void setNbrJoueurs(int newNbrJoueurs) {
		this.nbrJoueurs = newNbrJoueurs;
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
		this.nbrJoueurs++;
	}
	
	public void supprimerJoueur(Joueur joueur){
		listeJoueurs.remove(joueur);
		this.nbrJoueurs--;
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
	 * @return nbrToursJoues int : le nombre de tours de jeu
	 */
	public int getnbrToursJoues() {
		return this.nbrToursJoues;
	}

	/**
	 * Modifie le nombre de tours de jeu durant la partie
	 * @param newNbrToursJoues int : le nouveau nombre de tours de jeu
	 */
	public void setnbrToursJoues(int newNbrToursJoues) {
		this.nbrToursJoues = newNbrToursJoues;
	}

	// -- GESTION DES ETATS -- //
	
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
	
	/**
	 * Declanche la transition paireTrouvee de l'automate
	 */
	public void paireCartesIdentiques() {
		etatCourantPartie.paireTrouvee();
	}

	/**
	 * 
	 */
	public void traitement() {
		
		if(plateau.comparaisonPaire()) {
			traitementPaireTrouvee();
		} else {
			traitementPaireNonTrouvee();
		}
	}
	
	/**
	 * Declanche la transition pasPaireTrouvee de l'automate
	 */
	public void paireCartesDifferentes() {
		etatCourantPartie.pasPaireTrouvee();
	}
	
	/**
	 * Traite les actions si une paire a ete trouvee par un joueur
	 */
	public void traitementPaireTrouvee() {
		joueurCourant.tourGagne(plateau.getCarte1().effetCarte());

		plateau.getCarte1().setSurPlateau(false);
		plateau.getCarte2().setSurPlateau(false);
		plateau.setNbrCartesRestantes(plateau.getNbrCartesRestantes()-2);
		if (plateau.getNbrCartesRestantes() == 0) {
			etatCourantPartie.plusPairePossible();
		}
	}
	
	/**
	 * Traite les actions si aucune paire n'a ete trouvee ce tour
	 */
	public void traitementPaireNonTrouvee() {
		joueurCourant.tourPerdu();	
		nbrToursJoues++;
		joueurSuivant();
	}
	
	public void tour(){
		
	}
	
	public String toString(){
		String phraseJoueur = "liste des joueur \n";
		for(int i=0;i<this.nbrJoueurs;i++){
			phraseJoueur=phraseJoueur + "Joueur" + i + " " + listeJoueurs.get(i).getNom() + "\n";
		}
		
		return "Ètat du plateau: " + this.plateau.toStringM() + "\n" + phraseJoueur +"\n" + this.etatCourantPartie ;
		
	}
}