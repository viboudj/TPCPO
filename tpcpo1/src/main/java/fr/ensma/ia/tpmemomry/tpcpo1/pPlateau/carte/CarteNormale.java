package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe decrivant une carte normale, c.a.d sans effet
 * Pattern Strategy
 * Classe fille de Carte
 * @see Carte
 * 
 * @author douaultc
 */
public class CarteNormale extends Carte implements ICarte {
	
	/**
	 * Constructeur a un parametre
	 * Cree une instance de carteNormale
	 */
	public CarteNormale(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public void effetCarte() {
		// Pas d'effet pour une carte normale
	}
}
