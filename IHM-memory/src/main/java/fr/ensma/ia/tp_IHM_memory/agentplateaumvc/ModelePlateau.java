package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.IObserverCarte;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

public class ModelePlateau implements IObserverCarte {

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
	 * Nombre de colonnes de cartes dans la vue
	 */
	private int nbColonnes;
	
	/**
	 * Nombre de ligne de cartes dans la vue
	 */
	private int nbLignes;
	
	/**
	 * Liste des observateurs du plateau
	 */
	private ArrayList<IObserverPlateau> listeObservateursPlateau;
	
	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur du modele d'un plateau
	 */
	public ModelePlateau() {
		nbCartesSurPlateau = noyauFonctionnel.getPlateau().getListeCartesMelangees().size();
		// remplissage de listeCartesSurPlateau
		recupererListeCartes();
		// abonnement du plateau aux cartes et inversement
		abonnementCartes();
		
	}
	
	/**
	 * Remplit la iste des cartes sur le plateau en recuperant les informations necessaires dans listeCartesMelangees
	 * @see Plateau
	 */
	public void recupererListeCartes() {
		listeCartesSurPlateau = new ArrayList<ModeleCarte>(nbCartesSurPlateau);
		
		for (int i=0 ; i<nbCartesSurPlateau ; i++) {
			listeCartesSurPlateau.add(new ModeleCarte(
					noyauFonctionnel.getPlateau().getListeCartesMelangees().get(i).getSymbole().toString(), 
					noyauFonctionnel.getPlateau().getListeCartesMelangees().get(i).getBonusCarte()));
		}
	}
	
	/**
	 * Permet d'abonner le plateau en tant qu'observateur de chacune des cartes et inversement
	 */
	public void abonnementCartes() {
		ListIterator<ModeleCarte> iterator = listeCartesSurPlateau.listIterator();
		while(iterator.hasNext()) {
			// ajout du pateau comme observateur de chacune des cartes
			iterator.next().addObserverCarte(this);
			// ajout de chaque carte comme observatrice du plateau
			addObserverPlateau(iterator.next());
		}
	}
	
	// -- GESTION DES OBSERVATEURS DU PLATEAU -- //
	
	public void addObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.add(observer);
	}
	
	public void removeObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.remove(observer);
	}

	public void notificationClic(ModeleCarte modeleCarte) {
		// TODO Auto-generated method stub
		
	}
	
}
