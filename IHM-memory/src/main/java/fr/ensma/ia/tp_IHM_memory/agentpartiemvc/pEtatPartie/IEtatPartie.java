package fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie;

public interface IEtatPartie {
	/**
	 * passage de la vue initialiation de la partie à la vue de la partie
	 */
	public void lancementDeLaPartie();
	
	/**
	 * passage de la vue partie à la vue de conclusion
	 */
	public void FinDeLaPartie();
	/**
	 * relancement de la partie, relancement de la vue d'initialisation
	 */
	public void ReLancementDeLaPartie();
}
