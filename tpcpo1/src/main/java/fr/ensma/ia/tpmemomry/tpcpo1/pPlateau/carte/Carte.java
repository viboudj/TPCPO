/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Carte.
 * 
 * @author douaultc
 */
public class Carte {
	/**
	 * Description of the property symbole.
	 */
	private ESymboleCarte symbole = null;

	/**
	 * Description of the property type.
	 */
	private ITypeCarte type = null;

	/**
	 * Description of the property visible.
	 */
	private boolean visible = false;
	
	private boolean surPlateau= false;
	
	private int randValue;



	/**
	 * The constructor.
	 */
	public Carte(ESymboleCarte symbole,int rdVal) {
		
		// Start of user code constructor for Carte)
		super();
		this.type= new CarteNormale();
		this.visible=false;
		this.symbole=symbole;
		this.surPlateau=false;
		this.randValue=rdVal;
		// End of user code
	}

	// Start of user code (user defined methods for Carte)

	// End of user code
	/**
	 * Returns symbole.
	 * @return symbole 
	 */
	public ESymboleCarte getSymbole() {
		return this.symbole;
	}

	/**
	 * Sets a value to attribute symbole. 
	 * @param newSymbole 
	 */
	public void setSymbole(ESymboleCarte newSymbole) {
		this.symbole = newSymbole;
	}

	/**
	 * Returns type.
	 * @return type 
	 */
	public ITypeCarte getType() {
		return this.type;
	}

	/**
	 * Sets a value to attribute type. 
	 * @param newType 
	 */
	public void setType(ITypeCarte newType) {
		this.type = newType;
	}

	/**
	 * Returns visible.
	 * @return visible 
	 */
	public boolean getVisible() {
		return this.visible;
	}

	/**
	 * Sets a value to attribute visible. 
	 * @param newVisible 
	 */
	public void setVisible(boolean newVisible) {
		this.visible = newVisible;
	}
		
	public boolean getSurPlateau(){
		return this.surPlateau;
	}
	
	public void setSurPlateau(boolean val){
		this.surPlateau=val;
	}
	
	public int getRandValue(){
		return this.randValue;
	}
	
	public void setRandValue(int val){
		this.randValue=val;
	}
	
	public String toString(){
		return "symbole de la carte " + symbole + '\n' 
				+ "valeur associée à ma carte " + randValue +'\n'
				;
	}

}
