package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe decrivant une carte bonus, c.a.d avec effet
 * Pattern Strategy
 * Classe fille de Carte
 * @see Carte 
 * 
 * @author douaultc
 */
public class CartePlusDeux extends Carte implements ICarte {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de carte
	 */
	public CartePlusDeux(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public int effetCarte() {
		return 2;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Bonus : plus 2 points"+"\n";
	}
}
