package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe decrivant une carte bonus, c.a.d avec effet
 * Pattern Strategy
 * Classe fille de Carte
 * @see Carte 
 * 
 * @author douaultc
 */
public class CartePlusDix extends Carte implements ICarte {

	/**
	 * Constructeur a un parametre
	 * Cree une instance de carte
	 * @param symboleCarte ESymboleCarte : le symbole de la carte
	 */
	public CartePlusDix(ESymboleCarte symboleCarte) {
		super(symboleCarte);
	}

	/**
	 * Effet de la carte
	 */
	public int effetCarte() {
		// offre dix points de score supplementaires
		return 10;
	}
	
	/**
	 * Obtient le bonus de la carte au format chaine de caracteres
	 * @return bonusCarte Srting : le bonus de la carte
	 */
	public String getBonusCarte() {
		return "bonus10";
	}
	
	@Override
	public String toString() {
		return super.toString() + "Bonus : plus 10 points"+"\n";
	}
}
