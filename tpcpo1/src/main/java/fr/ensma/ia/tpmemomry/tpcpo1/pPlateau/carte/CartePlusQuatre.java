package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe decrivant une carte bonus, c.a.d avec effet
 * Pattern Strategy
 * Classe fille de Carte
 * @see Carte 
 * 
 * @author douaultc
 */
public class CartePlusQuatre extends Carte implements ICarte {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de carte
	 * @param symboleCarte ESymboleCarte : le symbole de la carte
	 */
	public CartePlusQuatre(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public int effetCarte() {
		// offre quatre points de score supplementaires
		return 4;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Bonus : plus 4 points" + "\n";
	}
}
