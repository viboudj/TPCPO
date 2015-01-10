package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe decrivant une carte bonus, c.a.d avec effet
 * Pattern Strategy
 * Classe fille de Carte
 * @see Carte 
 * 
 * @author douaultc
 */
public class CarteBonus1 extends Carte implements ICarte {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de carte
	 */
	public CarteBonus1(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public void effetCarte() {
		// TODO effet de la carte
	}
}
