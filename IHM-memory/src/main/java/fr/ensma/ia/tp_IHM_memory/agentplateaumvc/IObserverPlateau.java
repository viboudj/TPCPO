package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

/**
 * Interface mettant en place un Pattern Observer pour la classe ModelePlateau.</br>
 * Permet de prevenir une liste d'observateurs d'un changement dans une instance de ModelePlateau.</br></br>
 * 
 * Pattern Observer
 * @author clementdouault
 *
 */
public interface IObserverPlateau {

	/**
	 * Notifie aux observateurs d'un changement de visibilite de la carte
	 * @param horsPlateau boolean : false si la carte reste sur le plateau, false sinon
	 */
	public void updateVisibiliteCarte(boolean horsPlateau);
	
	/**
	 * Notifie aux cartes observatrices qu'elles doivent se desactiver.</br>
	 * Methode utilisee lorsque deux cartes ont deja ete selectionnees.
	 * @param carteBloquee boolean : vrai si la carte doit etre bloquee, faux si elle doit etre debloquee
	 */
	public void bloquerCarte(boolean carteBloquee);
}
