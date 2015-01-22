package fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie;

public interface IEtatPartie {
	
	/**
	 * Transition de l'etat PartieEnCours a l'etat FinPartie.</br>
	 * Transition activee lorsqu'il n'y a plus de carte sur le plateau.
	 */
	public void plusPaireRestante();
	/**
	 * Permet de relancer une partie.</br>
	 * Transition de l'etat PartieEnCours a lui-même et transition de FinPartie a PartieEnCours
	 */
	public void ReLancerPartie();
}
