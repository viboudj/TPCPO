package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Interface regroupant les comportements des cartes sans et avec effet
 * Pattern Strategy
 * 
 * @author douaultc
 */
public interface ICarte {

	/**
	 * Obtient le symbole de la carte
	 * @return symboleCarte ESymboleCarte : le symbole de la carte
	 */
	public ESymboleCarte getSymbole();
	
	/**
	 * Obtient le bonus de la carte au format chaine de caracteres
	 * @return bonusCarte Srting : le bonus de la carte (vaut "" si la carte n'a pas de bonus)
	 */
	public String getBonusCarte();

	/**
	 * Modifie le symbole de la carte 
	 * @param newSymbole ESymboleCarte : le nouveau symbole de la carte
	 */
	public void setSymbole(ESymboleCarte newSymbole);

	/**
	 * Obtient la visibilite de la carte (true=face visible, false sinon)
	 * @return visible boolean : la visibilite de la carte
	 */
	public boolean getVisible();

	/**
	 * Modifie la visibilite de la carte (true=face visible, false sinon)
	 * @param newVisible boolean : la visibilite de la carte
	 */
	public void setVisible(boolean newVisible);
		
	/**
	 * Indique si la carte est sur le plateau (true si oui, false sinon)
	 * @return surPlateau boolean : carte sur le plateau ou non
	 */
	public boolean getSurPlateau();
	
	/**
	 * Laisse/enleve la carte du plateau (true=laisse, false sinon)
	 * @param surPlateau boolean : carte sur le plateau ou non
	 */
	public void setSurPlateau(boolean surPlateau);
	
	/**
	 * Produit un effet si la carte est trouvee avec une carte identique
	 * @return int
	 */
	public int effetCarte();
	
	/**
	 * Redefinition de la methode toString pour ICarte
	 * @return String
	 */
	@Override
	public String toString();
}
