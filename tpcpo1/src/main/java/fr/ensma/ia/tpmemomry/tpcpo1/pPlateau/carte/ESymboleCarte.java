/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;



// Start of user code (user defined imports)

// End of user code

/**
 * Description of ESymboleCarte.
 * 
 * @author douaultc
 */
public enum ESymboleCarte {


	croix,
	losange,
	cercle,
	carre,
	rectangle,
	etoile,
	soleil,
	lune,
	venus,
	mars,
	pic,
	coeur,
	carreau,
	trefle;
	
	/**
	 * Nombre total d'elements dans l'enumeration
	 */
	private static int nombreESymboles = 14;
	
	/**
	 * Obtient le nombre total d'elements de l'enumeration
	 * @return nombreESymboles int : le nombre d'elements de l'enumeration
	 */
	public int getNombreESymboles() {
		return nombreESymboles;
	}
	
	/**
	 * Retourne un symbole de carte parmi l'enumeration ESymboleCarte en fonction de la valeur val d'entree
	 * @param val int : valeur
	 * @return ESymboleCarte : un symbole de carte
	 * @see ESymboleCarte
	 */
	public ESymboleCarte choixESymboleCarte(int val){		
		switch(Math.abs(val) % nombreESymboles) {
			case 0 : return ESymboleCarte.croix; 
			case 1 : return ESymboleCarte.losange;
			case 2 : return ESymboleCarte.cercle;
			case 3 : return ESymboleCarte.carre;
			case 4 : return ESymboleCarte.rectangle;
			case 5 : return ESymboleCarte.etoile;
			case 6 : return ESymboleCarte.soleil;
			case 7 : return ESymboleCarte.lune;
			case 8 : return ESymboleCarte.venus;
			case 9 : return ESymboleCarte.mars;
			case 10 : return ESymboleCarte.pic;
			case 11 : return ESymboleCarte.coeur;
			case 12 : return ESymboleCarte.carreau;
			case 13 : return ESymboleCarte.trefle;
		}
		return null;
	}
}
