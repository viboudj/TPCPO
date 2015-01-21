package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

/**
 * Interface mettant en place un Pattern Observer pour la classe ModeleCarte.</br>
 * Permet de prevenir une liste d'observateurs d'un changement dans une instance de ModeleCarte.</br></br>
 * 
 * Pattern Observer
 * @author clementdouault
 *
 */
public interface IObserverCarte {

	/**
	 * Notifie aux obervateurs que la carte a ete cliquee
	 * @param modeleCarte ModeleCarte : le modele de la carte ayant ete cliquee
	 */
	public void notificationClic(ModeleCarte modeleCarte);
	
}
