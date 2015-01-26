package fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie;

/**
 * Classe representant un etat de la partie.</br></br>
 * 
 * Pattern Strategy
 * @author clementdouault
 *
 */
public interface IEtatPartie {
	
	/**
	 * Indique a la vue de se mettre a jour.</br>
	 * Transition de l'etat PartieEnCours a lui-meme et de l'etatFinPartie a lui-meme.
	 */
	public void updateVue();
	
	/**
	 * Transition de l'etat PartieEnCours a l'etat FinPartie.</br>
	 * Transition activee lorsqu'il n'y a plus de carte sur le plateau.
	 */
	public void plusPaireRestante();
}
