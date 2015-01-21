package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import java.util.ArrayList;

public class ModelePlateau {

	/**
	 * Liste des observateurs du plateau
	 */
	private ArrayList<IObserverPlateau> listeObservateursPlateau;
	
	
	// -- GESTION DES OBSERVATEURS DU PLATEAU -- //
	
	public void addObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.add(observer);
	}
	
	public void removeObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.remove(observer);
	}
	
}
