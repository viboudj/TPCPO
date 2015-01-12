package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

/**
 * Classe mere des cartes
 * Regroupe les attributs commun aux cartes sans effet et aux cartes avec effet
 * 
 * @author douaultc
 */
public abstract class Carte {

	/**
	 * Symbole de la carte permettant sa comparaion avec d'autres
	 */
	private ESymboleCarte symboleCarte;
	
	/**
	 * Booleen a "true" si la carte est face visible sur le plateau, "false" sinon
	 */
	private boolean visible = false;
	
	/**
	 * Booleen a "true" si la carte est sur le plateau, "false" sinon (c.a.d carte trouvee dans une paire)
	 */
	private boolean surPlateau = true;

	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur a un parametre
	 * Cree une instance de Carte
	 * @param symboleCarte ESymboleCarte : le symbole de la carte
	 * @see ESymboleCarte
	 */
	public Carte(ESymboleCarte symboleCarte) {
		super();
		this.symboleCarte = symboleCarte;
	}

	// -- GETTEURS ET SETTEURS -- //
	
	/**
	 * Obtient le symbole de la carte
	 * @return symboleCarte ESymboleCarte : le symbole de la carte
	 */
	public ESymboleCarte getSymbole() {
		return this.symboleCarte;
	}

	/**
	 * Modifie le symbole de la carte 
	 * @param newSymbole ESymboleCarte : le nouveau symbole de la carte
	 */
	public void setSymbole(ESymboleCarte newSymbole) {
		this.symboleCarte = newSymbole;
	}

	/**
	 * Obtient la visibilite de la carte (true=face visible, false sinon)
	 * @return visible boolean : la visibilite de la carte
	 */
	public boolean getVisible() {
		return this.visible;
	}

	/**
	 * Modifie la visibilite de la carte (true=face visible, false sinon)
	 * @param newVisible boolean : la visibilite de la carte
	 */
	public void setVisible(boolean newVisible) {
		this.visible = newVisible;
	}
		
	/**
	 * Indique si la carte est sur le plateau (true si oui, false sinon)
	 * @return surPlateau boolean : carte sur le plateau ou non
	 */
	public boolean getSurPlateau(){
		return this.surPlateau;
	}
	
	/**
	 * Laisse/enleve la carte du plateau (true=laisse, false sinon)
	 * @param surPlateau boolean : carte sur le plateau ou non
	 */
	public void setSurPlateau(boolean surPlateau){
		this.surPlateau=surPlateau;
	}
	
	// -- OVERRIDE -- //
	
	@Override
	public String toString(){
		return "symbole de la carte " + symboleCarte + "\n";
	}

}
