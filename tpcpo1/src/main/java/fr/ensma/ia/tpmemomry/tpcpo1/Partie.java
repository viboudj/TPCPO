package fr.ensma.ia.tpmemomry.tpcpo1;

import java.util.ArrayList;

import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;
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
	public ArrayList<IJoueur> listeJoueurs = new ArrayList<IJoueur>();
	
	/**
	 * Joueur courant
	 */
	private IJoueur joueurCourant = null;
	
	/**
	 * Compteur suivant le nombre de tours joues dans la partie
	 */
	private int nbrToursJoues = 0;
	
	/**
	 * Instances de l'Etat pairesRestantes
	 */
	private IEtatPartie pairesRestantes = new PairesRestantes(this);
	
	/**
	 * Instances de l'Žtat finPartie
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
		plateau = new Plateau(nbrSymboles, nbrPairesParSymboles, false, 0);
		
		listeJoueurs = new ArrayList<IJoueur>();
		
		etatCourantPartie = pairesRestantes;	
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une nouvelle partie avec des parametres personnalisŽs
	 * @param nbrSymboles int : nombre de symboles differents
	 * @param nbrPairesParSymbole int : nombre de paires par symbole
	 */
	public Partie(int nbrSymb, int nbrPairesParSymb, boolean pairesBonus, int probabiliteBonus) {
		super();
		this.nbrSymboles = nbrSymb;
		this.nbrPairesParSymboles = nbrPairesParSymb;
		plateau = new Plateau( nbrSymboles, nbrPairesParSymboles, pairesBonus, probabiliteBonus);
		
		listeJoueurs = new ArrayList<IJoueur>();
		
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
	 * Obtient la liste des joueurs jouant une partie
	 * @return listeJoueurs ArrayList : la liste des joueurs
	 * @see Joueur
	 */
	public ArrayList<IJoueur> getListeJoueurs() {
		return listeJoueurs;
	}
	
	/**
	 * Ajout d'un joueur a la liste des joueurs
	 * @param joueur : le joueur a ajouter a la liste
	 * @see Joueur
	 */
	public void ajouterJoueur(IJoueur joueur) {
		if (listeJoueurs.size()==0){
			this.joueurCourant=joueur;
		}
		listeJoueurs.add(joueur);
		this.nbrJoueurs++;
	}
	
	/**
	 * suupprime un joueur
	 * @param joueur
	 */
	
	public void supprimerJoueur(IJoueur joueur){
		listeJoueurs.remove(joueur);
		this.nbrJoueurs--;
	}
	
	/**
	 * créer un joueur humain
	 */
	public void ajoutJoueurHumain(){
		ajouterJoueur(new Humain());
	}
	
	/**
	 * créer un joueur humain de nom "nom"
	 * @param nom
	 */
	public void ajoutJoueurHumain(String nom){
		ajouterJoueur(new Humain(nom));
	}
	
	/**
	 * créer une IA Stupide
	 */
	public void ajoutJoueurIAStupide(){
		ajouterJoueur(new Stupide(plateau));
	}
	
	/**
	 * créer une IA stupide de nom "nom"
	 * @param nom
	 */
	public void ajoutJoueurIAStupide(String nom){
		ajouterJoueur(new Stupide(plateau,nom));
	}

	/**
	 * Obtient la reference du joueur courant
	 * @return joueurCourant Joueur : le joueur courant
	 * @see Joueur
	 */
	public IJoueur getJoueurCourant() {
		return joueurCourant;
	}

	/**
	 * Modifie le joueur courant
	 * @param joueurCourant Joueur : le nouveau joueur courant
	 * @see Joueur
	 */
	public void setJoueurCourant(IJoueur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
	
	/**
	 * Modifie joueurCourant en selectionnant le joueur suivant dans la listeJoueurs
	 * Si joueurCourant est le dernier de la listeJoueurs, le suivant est le premier joueur de la listeJoueurs
	 */
	public void joueurSuivant() {
	 int _suivant = 0;	
		
		if(listeJoueurs.indexOf(joueurCourant) == listeJoueurs.size()-1) {
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

	// -- COMPORTEMENT DE LA PARTIE -- //

	/**
	 * Compare les deux cartes d'une paire et lance les actions adequates
	 */
	public void traitement() {
		
		if(plateau.comparaisonPaire()) {
			etatCourantPartie.paireTrouvee(); 
		} else {
			traitementPaireNonTrouvee();
		}
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
	
	
	/**
	 * donne le joueur gagnant de la partie
	 * @return joueur gagnant
	 */
	public IJoueur joueurGagant(){
		IJoueur gagnant;
		int nbrGagnant=0;
		if(this.etatCourantPartie==this.finPartie){
			gagnant=listeJoueurs.get(0);
			for(int i=0; i<listeJoueurs.size();i++){
				if(listeJoueurs.get(i).getScore().getScore()>gagnant.getScore().getScore()) gagnant=listeJoueurs.get(i);
			}
			for(int i=0; i<listeJoueurs.size();i++){
				if(listeJoueurs.get(i).getScore().getScore()==gagnant.getScore().getScore()) nbrGagnant++;
			}
			
			if(nbrGagnant>1){
				return null;
			}
			return gagnant;
			
		}
		System.out.println("La partie n'est pas finie!!");
		return null;
	}
	
	// -- OVERRIDE -- //
	
	/**
	 * mise en string le plateau
	 */
	@Override
	public String toString(){
		String phraseJoueur = "liste des joueur \n";
		for(int i=0;i<this.nbrJoueurs;i++){
			phraseJoueur=phraseJoueur + "Joueur" + i + " " + listeJoueurs.get(i).getNom() + "\n";
		}
		
		return "état du plateau: " + this.plateau.toStringM() + "\n" + phraseJoueur +"\n" + this.etatCourantPartie ;
		
	}
}