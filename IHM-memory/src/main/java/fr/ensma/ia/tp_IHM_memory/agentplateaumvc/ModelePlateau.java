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
	 * Reference du controleur du plateau
	 */
	private ControleurPlateau controleurPlateau;
	
	/**
	 * Nombre de cartes sur le plateau
	 */
	private int nbCartesSurPlateau;
	
	/**
	 * Nombre de ligne de cartes dans la vue
	 */
	private int nbLignes;
	
	/**
	 * Nombre de colonnes de cartes dans la vue
	 */
	private int nbColonnes;
	
	/**
	 * Liste melangee des cartes composant le plateau
	 */
	private ArrayList<ModeleCarte> listeCartesSurPlateau;
	
	/**
	 * Position de la premiere carte cliquee dans la liste des cartes
	 */
	private int positionCarte1;
	
	/**
	 * Position de la seconde carte cliquee dans la liste des cartes
	 */
	private int positionCarte2;
	
	/**
	 * Liste des abonnes au plateau
	 */
	private ArrayList<IObserverPlateau> listeObservateursPlateau;
	
	// -- CONSTRUCTEURS -- //

	/**
	 * Constructeur du modele d'un plateau
	 */
	public ModelePlateau() {
		controleurPlateau = new ControleurPlateau(this);
		
		nbCartesSurPlateau = noyauFonctionnel.getPlateau().getListeCartesMelangees().size();
		// remplissage de listeCartesSurPlateau
		recupererListeCartes();
		// calcul de l'agencement du plateau
		optimisationAgencementCartes();
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
	 * Obtient le nombre de lignes et de colonnes optimal en fonction du nombre total de cartes.</br>
	 * nbLignes et nbColonnes servent ensuite a la vue pour arranger la repartition des cartes.
	 */
	public void optimisationAgencementCartes() {
		ArrayList<Integer> diviseurs = new ArrayList<Integer>();
		
		for(int i=1; i<=nbCartesSurPlateau;i++){
			if(nbCartesSurPlateau%i==0){
				diviseurs.add(i);
			}
		}
		
		if(diviseurs.size()%2==0){
			nbLignes = diviseurs.get(diviseurs.size()/2-1);
			nbColonnes = diviseurs.get(diviseurs.size()/2);
		}else{
			nbLignes = diviseurs.get((diviseurs.size()-1)/2);
			nbColonnes = diviseurs.get((diviseurs.size()-1)/2);
		}
	}
	
	// -- OBERVATION DES CARTES -- //
	
	/**
	 * Permet d'abonner le plateau en tant qu'observateur de chacune des cartes et inversement
	 * @see ModeleCarte
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
	
	public void notificationClic(ModeleCarte modeleCarte) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Definit la position de la premiere carte cliquee
	 * @param carte1 ModeleCarte : la premiere carte cliquee
	 */
	public void setPositionCarte1(ModeleCarte carte1) {
		positionCarte1 = listeCartesSurPlateau.indexOf(carte1);
	}
	
	/**
	 * Definit la position de la seconde carte cliquee
	 * @param carte2 ModeleCarte : la seconde carte cliquee
	 */
	public void setPositionCarte2(ModeleCarte carte2) {
		positionCarte2 = listeCartesSurPlateau.indexOf(carte2);
	}
	
	// -- GESTION DES OBSERVATEURS DU PLATEAU -- //
	
	/**
	 * Ajoute un observateur du plateau a la liste
	 * @param observer IObserverPlateau : l'abservateur a ajouter
	 */
	public void addObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.add(observer);
	}
	
	/**
	 * Supprime un observateur du plateau de la liste
	 * @param observer IObserverPlateau : l'observateur a supprimer
	 */
	public void removeObserverPlateau(IObserverPlateau observer) {
		listeObservateursPlateau.remove(observer);
	}
	
	public void bloquerCartesPasSelectionnees() {
		ListIterator<IObserverPlateau> iterator = listeObservateursPlateau.listIterator();
		while(iterator.hasNext()) {
			iterator.next().bloquerCarte(true);
		}
	}
	
	/**
	 * Informe les cartes selectionnees d'un changement de leur etat
	 */
	public void notifierCartes() {
		ListIterator<IObserverPlateau> iterator = listeObservateursPlateau.listIterator();
		while(iterator.hasNext()) {
			
		}
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le nombre de lignes du plateau
	 * @return nbLignes int : le nombre de lignes
	 */
	public int getNbLignes() {
		return nbLignes;
	}
	
	/**
	 * Obtient le nombre de colonnes du plateau
	 * @return nbColonnes int : le nombre de colonnes
	 */
	public int getNbColonnes() {
		return nbColonnes;
	}
	
	/**
	 * Obtient la reference du modele de la premiere carte cliquee
	 * @return carte1 IObserverPlateau : le modele de la premiere carte cliquee
	 */
	public IObserverPlateau getCarte1() {
		return listeObservateursPlateau.get(positionCarte1);
	}

	/**
	 * Obtient la reference du modele de la seconde carte cliquee
	 * @return carte2 IObserverPlateau : le modele de la seconde carte cliquee
	 */
	public IObserverPlateau getCarte2() {
		return listeObservateursPlateau.get(positionCarte2);
	}
	
}
