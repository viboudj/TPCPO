package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

public enum ECartesBonus {

	plusDeuxPoints,
	plusQuatrePoints,
	plusSixPoints;
	
	/**
	 * Nombre total d'elements dans l'enumeration
	 */
	private static int nombreECartesBonus = 3;
	
	/**
	 * Obtient le nombre total d'elements de l'enumeration
	 * @return nombreECartesBonus int : le nombre d'elements de l'enumeration
	 */
	public int getNombreESCartesBOnus() {
		return nombreECartesBonus;
	}
	
	/**
	 * Retourne un element de l'enumeration en fonction de la valeur d'entree
	 * @param val int : valeur d'entree
	 * @return ECartesBonus : une carte bonus
	 */
	public ECartesBonus choixECartesBonus(int val){		
		switch(Math.abs(val) % nombreECartesBonus) {
			case 0 : return ECartesBonus.plusDeuxPoints; 
			case 1 : return ECartesBonus.plusQuatrePoints;
			case 2 : return ECartesBonus.plusSixPoints;
		}
		return null;
	}	
}
