/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Collections;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Carte;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.DeuxCartes;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.PasCarte;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.UneCarte;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Plateau.
 * 
 * @author douaultc
 */
public class Plateau {
	/**
	 * Description of the property nbrCartes.
	 */
	private int nbrCartes = 0;

	/**
	 * Description of the property carte1.
	 */
	private Carte carte1 = null;

	/**
	 * Description of the property carte2.
	 */
	private Carte carte2 = null;

	/**
	 * Description of the property etatPasCarte.
	 */
	private PasCarte etatPasCarte = null;

	/**
	 * Description of the property etatDeuxCartes.
	 */
	private DeuxCartes etatDeuxCartes = null;

	/**
	 * Description of the property etatUneCarte.
	 */
	private UneCarte etatUneCarte = null;

	/**
	 * Description of the property etatCourant.
	 */
	private IEtatPlateau etatCourant = null;

	/**
	 * Description of the property cartes.
	 */
	public List<Carte> cartes =null;

	/**
	 * Description of the property listeCartesMelangees.
	 */
	private List<Carte> listeCartesMelangees = null;
	
	// Start of user code (user defined attributes for Plateau)

	// End of user code

	/**
	 * The constructor.
	 */
	public Plateau(int nbr) {
		
		super();
		
		cartes= new ArrayList(nbr);
		listeCartesMelangees = new ArrayList(nbr);
		if(nbr%2==1){
		this.nbrCartes=nbr-1;
		} else {
			this.nbrCartes=nbr;
		}
		
		this.etatPasCarte= new PasCarte(this);
		this.etatUneCarte= new UneCarte(this);
		this.etatDeuxCartes= new DeuxCartes(this);
		this.etatCourant=this.etatPasCarte;
		 
		
		Random r = new Random();
		
		for(int i=0; i<nbr/2; i++  ){
			
			ESymboleCarte symb;
			symb=choixESymboleCartealea();
			Carte c = new Carte(symb,r.nextInt());
			cartes.add(c);
			Carte d = new Carte(symb,r.nextInt());
			cartes.add(d);
		}
		distribueCarte();
	
	}
	
	public Plateau(){
		super();
		
		Random r = new Random();
		int v = r.nextInt();
		
		this.nbrCartes=32;
		cartes= new ArrayList(this.nbrCartes);
		listeCartesMelangees = new ArrayList(this.nbrCartes);
		this.etatPasCarte= new PasCarte(this);
		this.etatUneCarte= new UneCarte(this);
		this.etatDeuxCartes= new DeuxCartes(this);
		this.etatCourant=this.etatPasCarte;
		
		for(int i=v;i<v+8;i++){
			for(int j=0; j<4;j++){
				cartes.add( new Carte(choixESymboleCarte(i),r.nextInt()));
			}
			
		}
		distribueCarte();

		
		
		
	}

	/**
	 * Description of the method comparaisonCartes.
	 * @return 
	 */
	public boolean comparaisonCartes() {
		// Start of user code for method comparaisonCartes
		boolean comparaisonCartes = false;
		return comparaisonCartes;
		// End of user code
	}

	/**
	 * Description of the method Melanger.
	 */
	public void Melanger() {
		// Start of user code for method Melanger
		// End of user code
	}

	// Start of user code (user defined methods for Plateau)

	// End of user code
	/**
	 * Returns nbrCartes.
	 * @return nbrCartes 
	 */
	public int getNbrCartes() {
		return this.nbrCartes;
	}

	/**
	 * Sets a value to attribute nbrCartes. 
	 * @param newNbrCartes 
	 */
	public void setNbrCartes(int newNbrCartes) {
		this.nbrCartes = newNbrCartes;
	}

	/**
	 * Returns carte1.
	 * @return carte1 
	 */
	public Carte getCarte1() {
		return this.carte1;
	}

	/**
	 * Sets a value to attribute carte1. 
	 * @param newCarte1 
	 */
	public void setCarte1(Carte newCarte1) {
		this.carte1 = newCarte1;
	}

	/**
	 * Returns carte2.
	 * @return carte2 
	 */
	public Carte getCarte2() {
		return this.carte2;
	}

	/**
	 * Sets a value to attribute carte2. 
	 * @param newCarte2 
	 */
	public void setCarte2(Carte newCarte2) {
		this.carte2 = newCarte2;
	}

	/**
	 * Returns etatPasCarte.
	 * @return etatPasCarte 
	 */
	public PasCarte getEtatPasCarte() {
		return this.etatPasCarte;
	}

	/**
	 * Sets a value to attribute etatPasCarte. 
	 * @param newEtatPasCarte 
	 */
	public void setEtatPasCarte(PasCarte newEtatPasCarte) {
		this.etatPasCarte = newEtatPasCarte;
	}

	/**
	 * Returns etatDeuxCartes.
	 * @return etatDeuxCartes 
	 */
	public DeuxCartes getEtatDeuxCartes() {
		return this.etatDeuxCartes;
	}

	/**
	 * Sets a value to attribute etatDeuxCartes. 
	 * @param newEtatDeuxCartes 
	 */
	public void setEtatDeuxCartes(DeuxCartes newEtatDeuxCartes) {
		this.etatDeuxCartes = newEtatDeuxCartes;
	}

	/**
	 * Returns etatUneCarte.
	 * @return etatUneCarte 
	 */
	public UneCarte getEtatUneCarte() {
		return this.etatUneCarte;
	}

	/**
	 * Sets a value to attribute etatUneCarte. 
	 * @param newEtatUneCarte 
	 */
	public void setEtatUneCarte(UneCarte newEtatUneCarte) {
		this.etatUneCarte = newEtatUneCarte;
	}

	/**
	 * Returns etatCourant.
	 * @return etatCourant 
	 */
	public IEtatPlateau getEtatCourant() {
		return this.etatCourant;
	}

	/**
	 * Sets a value to attribute etatCourant. 
	 * @param newEtatCourant 
	 */
	public void setEtatCourant(IEtatPlateau newEtatCourant) {
		this.etatCourant = newEtatCourant;
	}
	
	public  List<Carte> getListeCartesMelangees(){
		return this.listeCartesMelangees;
	}
	
	
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
	



	private ESymboleCarte choixESymboleCartealea(){
		Random r=new Random();
		int val= r.nextInt(10);
		return choixESymboleCarte(val);
	}
	
	/**
	 * Returns distribueCarte.
	 * @return vide la première liste cartes pour placer les cartes dans la seconde liste listeCartesMelangees 
	 * selon la valeur aléatoire de chaque carte
	 */

	
	public void distribueCarte(){
		
		Carte c = null;
		List<Carte> listeTempo = new ArrayList(nbrCartes) ;
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
	 * Returns toStringM.
	 * @return String de la liste des cartes mélangées
	 */
	
	public String toString(){
		String phrase = "nombre de cartes sur le plateau " +  this.nbrCartes + '\n';
		for(int i=0;i<this.nbrCartes;i++){
			phrase = phrase + listeCartesMelangees.get(i).toString() + '\n';
		}
		return phrase;
	}
	

}
