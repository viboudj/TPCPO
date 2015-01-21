package fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;

public interface IEtatPlateau {

	/**
	 * 
	 * @param carte
	 */
	public void carteCliquee(ModeleCarte carte);
	
	public void comparaisonCartes();
	
}
