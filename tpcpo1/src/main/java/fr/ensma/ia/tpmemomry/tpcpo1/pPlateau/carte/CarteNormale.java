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
	 * @param symboleCarte ESymboleCarte : le symbole de la carte
	 */
	public CarteNormale(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public int effetCarte() {
		return 0;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Bonus : pas d'effet" + "\n";
	}
}
