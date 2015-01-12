package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte;

import java.util.Random;

public enum ECartesBonus {

	plusDeuxPoints,
	plusQuatrePoints,
	plusDixPoints;
	
	/**
	 * Nombre total d'elements dans l'enumeration
	 */
	private static int nombreECartesBonus = 3;
	
	/**
	 * Obtient le nombre total d'elements de l'enumeration
	 * @return nombreECartesBonus int : le nombre d'elements de l'enumeration
	 */
	public int getNombreECartesBOnus() {
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
			case 2 : return ECartesBonus.plusDixPoints;
		}
		return null;
	}
	
	/**
	 * Retourne un ECarteBonus aleatoire parmi ceux de l'enumeration
	 * @return
	 */
	public ECartesBonus CartesBonusAleatoire(){
		Random ran = new Random();
		int val= ran.nextInt(nombreECartesBonus);
		return choixECartesBonus(val);
}

}
