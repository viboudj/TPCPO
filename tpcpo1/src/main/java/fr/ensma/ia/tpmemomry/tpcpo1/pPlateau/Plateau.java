package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau;

import java.util.ArrayList;
import java.util.Random;

import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.*;


/**
 * Plateau : classe gerant le plateau de jeu
 * @author clementdouault
 *
 */
public class Plateau {

	/**
	 * La reference de la partie a laquelle le plateau appartient
	 */
	private Partie partie;
	
	/**
	 * Nombre de cartes dont est compose le plateau
	 */
	private int nbrCartes = 0;
	
	/**
	 * Nombre de cartes restantes sur le plateau
	 */
	private int nbrCartesRestantes;
	
	/**
	 * Liste des cartes composant le plateau
	 */
	private ArrayList<Carte> cartes =null;

	/**
	 * Liste des cartes melangees composant le plateau
	 */
	private ArrayList<Carte> listeCartesMelangees = null;

	/**
	 * Reference de la premiere carte selectionnee par le joueur
	 */
	private Carte carte1 = null;

	/**
	 * Reference de la deuxieme carte selectionnee par le joueur
	 */
	private Carte carte2 = null;

	/**
	 * Instance de l'Žtat PasCarteSelectionnee
	 */
	private IEtatPlateau pasCarteSelectionnee = new PasCarteSelectionnee(this);
	
	/**
	 * Instance de l'Žtat UneCarteSelectionnee
	 */
	private IEtatPlateau uneCarteSelectionnee = new UneCarteSelectionnee(this);

	/**
	 * Instance de l'Žtat DeuxCartesSelectionnees
	 */
	private IEtatPlateau deuxCartesSelectionnees = new DeuxCartesSelectionnees(this);

	/**
	 * Etat actuel du plateau
	 */
	private IEtatPlateau etatCourant = null;

	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur avec un parametre
	 * Cree un plateau compose de 32 cartes avec 8 symboles differents (2 paires par symbole)
	 */
	public Plateau(Partie partie){
		super();
		this.partie = partie;
		etatCourant = pasCarteSelectionnee;
		
		Random r = new Random();
		int v = r.nextInt();
		
		this.nbrCartes=32;
		cartes= new ArrayList<Carte>(this.nbrCartes);
		listeCartesMelangees = new ArrayList<Carte>(this.nbrCartes);
		
		for(int i=v;i<v+8;i++){
			for(int j=0; j<4;j++){
				cartes.add( new Carte(choixESymboleCarte(i),r.nextInt()));
			}
			
		}
		
		melangerCartes();
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree un plateau compose de nbr (ou nbr-1 si nbr est impair) cartes avec des symboles choisis alŽatoirement 
	 * @param nbr int : nombre de cartes composant le plateau
	 */
	public Plateau(Partie partie, int nbr) {
		super();
		this.partie = partie;
		etatCourant = pasCarteSelectionnee;
		
		if(nbr%2==1){
		this.nbrCartes=nbr-1; 
		} else {
			this.nbrCartes=nbr;
		}
		
		cartes= new ArrayList<Carte>(nbrCartes);
		listeCartesMelangees = new ArrayList<Carte>(this.nbrCartes); 
		
		Random r = new Random();
		
		for(int i=0; i<nbr/2; i++  ){
			
			ESymboleCarte symb;
			symb=choixESymboleCartealea();
			Carte c = new Carte(symb,r.nextInt());
			cartes.add(c);
			Carte d = new Carte(symb,r.nextInt());
			cartes.add(d);
		}
		
		melangerCartes();
	}
	
	/**
	 * Melange les cartes contenues dans la liste cartes en les placant aleatoirement dans listeCartesMelangees
	 */
	public void melangerCartes() {
		
		Carte c = null;
		ArrayList<Carte> listeTempo = new ArrayList<Carte>(nbrCartes) ;
		listeTempo=cartes;
		
		for(int j=0;j<this.nbrCartes;j++){
			c=listeTempo.get(0);
			
			for(int i=0;i<listeTempo.size();i++){
				if(c.getRandValue()>listeTempo.get(i).getRandValue())  c=listeTempo.get(i);
				}
			
			listeCartesMelangees.add(c);
			listeTempo.remove(c);
		}		
		
	}
	
	/**
	 * Retour un symbole de carte parmi l'enumeration ESymboleCarte en fonction de la valeur val d'entree
	 * @param val int : valeur
	 * @return ESymboleCarte : un symbole de carte
	 * @see ESymboleCarte
	 */
	private ESymboleCarte choixESymboleCarte(int val){
		switch(Math.abs(val) % 10){
		case 1 : return ESymboleCarte.croix; 
		case 2 : return ESymboleCarte.losange;
		case 3 : return ESymboleCarte.carré;
		case 4 : return ESymboleCarte.cercle;
		case 5 : return ESymboleCarte.rectangle;
		case 6 : return ESymboleCarte.étoile;
		case 7 : return ESymboleCarte.soleil;
		case 8 : return ESymboleCarte.lune;
		case 9 : return ESymboleCarte.venus;
		case 0 : return ESymboleCarte.mars;
	}
		return null;
	}
	
	/**
	 * Retourne un symbole de carte aleatoire parmi l'enumeration ESymboleCarte
	 * @return ESymboleCarte : un symbole de carte
	 * @see ESymboleCarte
	 */
	private ESymboleCarte choixESymboleCartealea(){
		Random r=new Random();
		int val= r.nextInt(10);
		return choixESymboleCarte(val);
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
	 * @return listeCarteMelangee ArrayList : liste des cartes mŽlangees
	 */
	public  ArrayList<Carte> getListeCartesMelangees(){
		return this.listeCartesMelangees;
	}
	
	/**
	 * Obtient la reference de la premiere carte selectionnee par le joueur
	 * @return carte1 Carte : la premiere carte selectionnee
	 */
	public Carte getCarte1() {
		return this.carte1;
	}

	/**
	 * Modifie la reference de la premiere carte selectionnee par le joueur
	 * @param newCarte1 Carte : la nouvelle carte selectionnee en premier
	 */
	public void setCarte1(Carte newCarte1) {
		this.carte1 = newCarte1;
		etatCourant.selectCarte1();
	}

	/**
	 * Obtient la reference de la deuxieme carte selectionnee par le joueur
	 * @return carte2 Carte : la deuxieme carte selectionnee
	 */
	public Carte getCarte2() {
		return this.carte2;
	}

	/**
	 * Modifie la reference de la deuxieme carte selectionnee par le joueur
	 * @param newCarte2 Carte : la nouvelle carte selectionnee en deuxieme
	 */
	public void setCarte2(Carte newCarte2) {
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
		if(carte1.getSymbole() == carte2.getSymbole()){
			partie.paireCartesIdentiques();
			return true;
		} else {
			partie.paireCartesDifferentes();
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
		for(int i=0;i<cartes.size();i++){
			phrase = phrase + cartes.get(i).toString() + '\n';
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
		for(int i=0;i<this.nbrCartes;i++){
			phrase = phrase + listeCartesMelangees.get(i).toString() + '\n';
		}
		return phrase;
	}
}