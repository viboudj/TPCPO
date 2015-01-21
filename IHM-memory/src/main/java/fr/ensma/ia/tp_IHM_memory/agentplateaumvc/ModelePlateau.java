package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import java.util.ArrayList;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

public class ModelePlateau {

	/**
	 * Reference du noyau fonctionnel du memory
	 */
	private Partie noyauFonctionnel;
	
	/**
	 * Nombre de cartes sur le plateau
	 */
	private int nbCartesSurPlateau;
	
	/**
	 * Liste melangee des cartes composant le plateau
	 */
	private ArrayList<ModeleCarte> listeCartesSurPlateau;
	
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
