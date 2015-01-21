package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;


import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.*;


/**
 * Plateau : classe gerant le plateau de jeu
 * @author clementdouault
 *
 */
public class Plateau {
	
	/**
	 * Nombre de cartes dont est compose le plateau
	 */
	private int nbrCartes = 0;
	
	/**
	 * Nombre de symboles de carte differents
	 */
	private int nbrSymboles = 0;
	
	/**
	 * Nombre de cartes par symbole
	 */
	private int nbrPairesParSymbole = 0;
		
	/**
	 * Nombre de cartes restantes sur le plateau
	 */
	private int nbrCartesRestantes;
	
	/**
	 * Liste des cartes composant le plateau
	 */
	private ArrayList<ICarte> listeCartes;

	/**
	 * Liste des cartes melangees composant le plateau
	 */
	private ArrayList<ICarte> listeCartesMelangees = null;

	/**
	 * Reference de la premiere carte selectionnee par le joueur
	 */
	private ICarte carte1 = null;

	/**
	 * Reference de la deuxieme carte selectionnee par le joueur
	 */
	private ICarte carte2 = null;

	/**
	 * Instance de l'état PasCarteSelectionnee
	 */
	private IEtatPlateau pasCarteSelectionnee = new PasCarteSelectionnee(this);
	
	/**
	 * Instance de l'état UneCarteSelectionnee
	 */
	private IEtatPlateau uneCarteSelectionnee = new UneCarteSelectionnee(this);

	/**
	 * Instance de l'état DeuxCartesSelectionnees
	 */
	private IEtatPlateau deuxCartesSelectionnees = new DeuxCartesSelectionnees(this);

	/**
	 * Etat actuel du plateau
	 */
	private IEtatPlateau etatCourant = null;

	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur sans parametre
	 * Cree un plateau compose de 32 cartes sans effet avec 8 symboles differents (2 paires par symbole)
	 */
	public Plateau(){
		super();
		etatCourant = pasCarteSelectionnee;
		
		nbrSymboles = 8;
		nbrPairesParSymbole = 2;
		nbrCartes=nbrSymboles*nbrPairesParSymbole*2;
		nbrCartesRestantes = nbrCartes;
		
		listeCartes= new ArrayList<ICarte>(nbrCartes);
		listeCartesMelangees = new ArrayList<ICarte>(nbrCartes);
		
		tirerCartes(nbrSymboles, nbrPairesParSymbole);
		melangerCartes();
	}
	
	/**
	 * Constructeur a quatre parametres
	 * Cree un plateau avec nbrSymboles symboles et nbrPairesParSymbole paires par symbole
	 * @param nbrSymboles int : le nombre de symboles differents
	 * @param nbrPairesParSymbole int : le nombre de paires par symboles
	 * @param cartesBonus boolean : indique si, oui ou non, les cartes bonus sont autorisees sur le plateau
	 * @param probabiliteBonus int : la probabilite d'apparition des paires bonus (entre 0 et 10)
	 */
	public Plateau(int nbrSymboles, int nbrPairesParSymbole, boolean cartesBonus, int probabiliteBonus) {
		super();
		etatCourant = pasCarteSelectionnee;
		
		this.nbrSymboles = nbrSymboles;
		this.nbrPairesParSymbole = nbrPairesParSymbole;
		nbrCartes = nbrSymboles*nbrPairesParSymbole*2;
		nbrCartesRestantes = nbrCartes;
		
		listeCartes = new ArrayList<ICarte>(nbrCartes);
		listeCartesMelangees = new ArrayList<ICarte>(nbrCartes);
		
		if(cartesBonus) {
			tirerCartes(nbrSymboles, nbrPairesParSymbole, probabiliteBonus);
		} else {
			tirerCartes(nbrSymboles, nbrPairesParSymbole);
		}

		melangerCartes();
	}
	
	/**
	 * Tire des paires sans bonus et les range de facon ordonnee dans listeCartes
	 * @param nbrSymb int : nombre de symboles differents
	 * @param nbrPairesParSymb int : nombre de paires par symbole
	 */
	public void tirerCartes(int nbrSymb, int nbrPairesParSymb) {
		ESymboleCarte symbole = ESymboleCarte.carre;
		for(int i=0 ; i<nbrSymb ; i++) {
			for(int j=0 ; j<nbrPairesParSymb ; j++) {
				listeCartes.add(new CarteNormale(symbole.choixESymboleCarte(i)));
				listeCartes.add(new CarteNormale(symbole.choixESymboleCarte(i)));
			}
		}
	}
	
	/**
	 * Tire les paires avec et sans bonus et les range de facon ordonnee dans la listeCartes
	 * @param nbrSymb int : nombre de symboles differents
	 * @param nbrPairesParSymb int : nombre de paires par symbole
	 * @param probaBonus int : la probabilite de tirer une paire bonus
	 */
	public void tirerCartes(int nbrSymb, int nbrPairesParSymb, int probaBonus) {
		ESymboleCarte symbole = ESymboleCarte.carre;
		for(int i=0 ; i<nbrSymb ; i++) {
			for(int j=0 ; j<nbrPairesParSymb ; j++) {
				// Determine si on tire paire bonus ou une paire sans effet
				if(tirageBonus(probaBonus)) {
					tirerPaireBonus(symbole.choixESymboleCarte(i));
				} else {
					listeCartes.add(new CarteNormale(symbole.choixESymboleCarte(i)));
					listeCartes.add(new CarteNormale(symbole.choixESymboleCarte(i)));
				}
			}
		}
	}
	
	/**
	 * Determine si la prochaine paire tiree sera avec (true) ou sans (false) effet
	 * Avec une probabilite de 1 (peu probable) a 10 (sur)
	 * @param probabilite int : la probabilite que la paire soit avec effet (entre 1 et 10)
	 * @return boolean : true si la paire est avec effet, false sinon
	 */
	public boolean tirageBonus(int probabilite) {
		Random ran = new Random();
		// Si le nombre aleatoire est inferieur ou egal a la probabilite, retourner vrai
		if((ran.nextInt(10)+1)<=probabilite) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Tire une paire bonus avec un effet aleatoire (choix parmi l'enumeration ECartesBonus)
	 * @param symbole ESymboleCarte : symbole de la paire
	 * @see ECartesBonus
	 */
	public void tirerPaireBonus(ESymboleCarte symbole) {
		ECartesBonus bonus = ECartesBonus.plusDeuxPoints;
		switch(bonus.CartesBonusAleatoire()) {
		case plusDeuxPoints:
			listeCartes.add(new CartePlusDeux(symbole));
			listeCartes.add(new CartePlusDeux(symbole));
			break;
		case plusQuatrePoints:
			listeCartes.add(new CartePlusQuatre(symbole));
			listeCartes.add(new CartePlusQuatre(symbole));
			break;
		case plusDixPoints:
			listeCartes.add(new CartePlusDix(symbole));
			listeCartes.add(new CartePlusDix(symbole));
			break;
		default:
			listeCartes.add(new CartePlusDeux(symbole));
			listeCartes.add(new CartePlusDeux(symbole));
			break;
		}
	}
	
	/**
	 * Melange les cartes contenues dans la liste cartes en les placant aleatoirement dans listeCartesMelangees
	 */
	public void melangerCartes() {
		// creation d'une copie de listeCartes
		ArrayList<ICarte> _copieListeCarte = new ArrayList<ICarte>();
		ListIterator<ICarte> ite = listeCartes.listIterator();
		while (ite.hasNext()) {
			_copieListeCarte.add(ite.next());
		}
		
		int _carteRestantMelanger = nbrCartes;
		int _indice;
		Random _rand = new Random();
		
		while (_carteRestantMelanger>0) {
			_indice = _rand.nextInt(_carteRestantMelanger);
			listeCartesMelangees.add(_copieListeCarte.get(_indice));
			_copieListeCarte.remove(_indice);
			_carteRestantMelanger--;			
		}		
	}
	
	// -- GETTEURS ET SETTEURS -- //

	/**
	 * Obtient le nombre de cartes composant le plateau
	 * @return nbrCartes int : le nombre de cartes composant le plateau 
	 */
	public int getNbrCartes() {
		return this.nbrCartes;
	}

	/**
	 * Modifie le nombre de cartes composant le plateau
	 * @param newNbrCartes int : le nouveau nombre de cartes composant le plateau
	 */
	public void setNbrCartes(int newNbrCartes) {
		this.nbrCartes = newNbrCartes;
	}
	
	/**
	 * Obtient le nombre de symboles de carte differents
	 * @return nbrSymboles int : le nombre de symboles different
	 */
	public int getNbrSymboles() {
		return nbrSymboles;
	}

	/**
	 * Modifie le nombre de symboles de carte differents
	 * @param newNbrSymboles int : le nouveau nombre de symboles differents
	 */
	public void setNbrSymboles(int newNbrSymboles) {
		this.nbrSymboles = newNbrSymboles;
	}

	/**
	 * Obtient le nombre de paires par symbole
	 * @return nbrPairesParSymbole int : le nombre de paires par symbole 
	 */
	public int getNbrPairesParSymbole() {
		return nbrPairesParSymbole;
	}

	/**
	 * Modifie le nombre de paires par symbole
	 * @param newNbrPairesParSymbole : le nouveau nombre de paires par symbole
	 */
	public void setNbrPairesParSymbole(int newNbrPairesParSymbole) {
		this.nbrPairesParSymbole = newNbrPairesParSymbole;
	}
	
	/**
	 * Obtient le nombre de cartes restantes sur le plateau
	 * @return nbrCartesRestantes int : le nombre de cartes restantes sur le plateau
	 */
	public int getNbrCartesRestantes() {
		return nbrCartesRestantes;
	}

	/**
	 * Modifie le nombre de cartes restantes sur le plateau
	 * @param nbrCartesRestantes int : le nouveau nombre de cartes restantes sur le plateau
	 */
	public void setNbrCartesRestantes(int nbrCartesRestantes) {
		this.nbrCartesRestantes = nbrCartesRestantes;
	}
	
	/**
	 * Obtient la liste des cartes melangees composant le plateau
	 * @return listeCarteMelangee ArrayList : liste des cartes mélangees
	 */
	public  ArrayList<ICarte> getListeCartesMelangees(){
		return this.listeCartesMelangees;
	}
	
	/**
	 * Obtient la reference de la premiere carte selectionnee par le joueur
	 * @return carte1 Carte : la premiere carte selectionnee
	 */
	public ICarte getCarte1() {
		return this.carte1;
	}

	/**
	 * Modifie la reference de la premiere carte selectionnee par le joueur
	 * @param newCarte1 Carte : la nouvelle carte selectionnee en premier
	 */
	public void setCarte1(ICarte newCarte1) {
		this.carte1 = newCarte1;
		etatCourant.selectCarte1();
	}

	/**
	 * Obtient la reference de la deuxieme carte selectionnee par le joueur
	 * @return carte2 Carte : la deuxieme carte selectionnee
	 */
	public ICarte getCarte2() {
		return this.carte2;
	}

	/**
	 * Modifie la reference de la deuxieme carte selectionnee par le joueur
	 * @param newCarte2 Carte : la nouvelle carte selectionnee en deuxieme
	 */
	public void setCarte2(ICarte newCarte2) {
		this.carte2 = newCarte2;
		etatCourant.selectCarte2();
	}
	
	// -- COMPORTEMENT -- //
	
	/**
	 * Compare les deux cartes selectionnees par le joueur
	 * @return boolean : true si cartes identiques, false sinon
	 */
	public boolean comparaisonPaire() {
		etatCourant.comparaisonCartes();
		if(carte1.getSymbole() == carte2.getSymbole() &&
				carte1.getBonusCarte() == carte2.getBonusCarte()){
			return true;
		} else {
			return false;
		}
	}

	// -- GESTION DES ETATS -- //
	
	/**
	 * Obtient l'instance de l'etat pasCarteSelectionnee
	 * @return pasCarteSelectionnee IEtatPlateau
	 */
	public IEtatPlateau getpasCarteSelectionnee() {
		return this.pasCarteSelectionnee;
	}
	
	/**
	 * Obtient l'instance de l'etat uneCarteSelectionnee
	 * @return uneCarteSelectionnee IEtatPlateau
	 */
	public IEtatPlateau getuneCarteSelectionnee() {
		return this.uneCarteSelectionnee;
	}
	
	/**
	 * Obtient l'instance de l'etat deuxCartesSelectionnees
	 * @return deuxCartesSelectionnees IEtatPlateau
	 */
	public IEtatPlateau getdeuxCartesSelectionnees() {
		return this.deuxCartesSelectionnees;
	}

	/**
	 * Obtient l'etat courant du plateau
	 * @return etatCourant IEtatPlateau : l'etat courant du plateau
	 */
	public IEtatPlateau getEtatCourant() {
		return this.etatCourant;
	}

	/**
	 * Modifie l'etat courant du plateau
	 * @param newEtatCourant IEtatPlateau : le nouvel etat courant du plateau
	 */
	public void setEtatCourant(IEtatPlateau newEtatCourant) {
		this.etatCourant = newEtatCourant;
	}
	

	// -- OVERRIDE -- //
	
	/**
	 * Returns toStringM.
	 * @return String de la liste cartes (normalement vide)
	 */
	public String toStringM(){
		String phrase = "nombre de cartes sur le plateau " +  this.nbrCartes + '\n';
		for(int i=0;i<listeCartesMelangees.size();i++){
			phrase = phrase + listeCartesMelangees.get(i).toString() + '\n';
		}
		return phrase;
	}
	
	public String toStringCarteSurPlateau(){
		String phrase = "nombre de cartes restantes sur le plateau " +  this.nbrCartesRestantes + '\n';
		for(int i=0;i<listeCartesMelangees.size();i++){
			if(listeCartesMelangees.get(i).getSurPlateau()) phrase = phrase + listeCartesMelangees.get(i).toString() + '\n';
		}
		return phrase;
	}
	
	/**
	 * Redefinition de la fonction toString pour l'affichage du plateau melange
	 * Affiche le plateau de la forme "nombre de carte" + detail de chaque carte
	 * @return String : liste des cartes melangees
	 */
	@Override
	public String toString(){
		String phrase = "nombre de cartes sur le plateau " +  this.nbrCartes + '\n';
		for(int i=0;i<listeCartes.size();i++){
			phrase = phrase + listeCartes.get(i).toString() + '\n';
		}
		return phrase;
	}
}