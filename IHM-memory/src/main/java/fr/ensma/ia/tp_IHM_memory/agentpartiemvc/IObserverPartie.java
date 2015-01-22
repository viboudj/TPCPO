package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

/**
 * Interface mettant en place un Pattern Observer pour la classe ModelePartie.</br>
 * Permet de prevenir une liste d'observateurs d'un changement dans une instance de ModelePartie.</br></br>
 * 
 * Pattern Observer
 * @author clementdouault
 *
 */
public interface IObserverPartie {

	/**
	 * Notifie aux observers que les attributs des joueurs ont ete modifies
	 */
	public void updateJoueurs();
	
}
