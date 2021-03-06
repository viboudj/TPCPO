package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.IObserverCarte;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

/**
 * Classe representant le modele du plateau conformement a l'architecture MVC.</br>
 * Implemente IObserverCarte afin d'etre informe des clics sur les cartes.
 * 
 * @author clementdouault
 *
 */
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
	 * Delai entre la selection de la deuxieme carte et le retournement de la paire 
	 */
	private long delai = 1300;
	
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
	 * Booleen a vrai si les cartes comparees sont identiques
	 */
	private boolean cartesIdentiques;
	
	/**
	 * Liste des abonnes au plateau
	 */
	private ArrayList<IObserverPlateau> listeObservateursPlateau;
	
	// -- CONSTRUCTEURS -- //

	/**
	 * Constructeur du modele d'un plateau
	 * @param noyauFonctionnel Partie : la reference du noyau fonctionnel
	 */
	public ModelePlateau(Partie noyauFonctionnel) {
		this.noyauFonctionnel = noyauFonctionnel;
		
		nbCartesSurPlateau = noyauFonctionnel.getPlateau().getListeCartesMelangees().size();
		// remplissage de listeCartesSurPlateau
		recupererListeCartes();
		// calcul de l'agencement du plateau
		optimisationAgencementCartes();
		// abonnement du plateau aux cartes et inversement
		listeObservateursPlateau = new ArrayList<IObserverPlateau>();
		abonnementCartes();	
		
		controleurPlateau = new ControleurPlateau(this);
	}

	/**
	 * Remplit la liste des cartes sur le plateau en recuperant les informations necessaires dans listeCartesMelangees
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
	
	// -- OBSERVATION DES CARTES -- //
	
	/**
	 * Permet d'abonner le plateau en tant qu'observateur de chacune des cartes et inversement
	 * @see ModeleCarte
	 */
	public void abonnementCartes() {
		ListIterator<ModeleCarte> iterator = listeCartesSurPlateau.listIterator();
		ModeleCarte _carte;
		while(iterator.hasNext()) {
			_carte = iterator.next();
			// ajout du pateau comme observateur de chacune des cartes
			_carte.addObserverCarte(this);
			// ajout de chaque carte comme observatrice du plateau
			addObserverPlateau(_carte);
		}
	}
	
	// -- OBSERVATION DE LA PARTIE -- //
	
	public void nouveauTourCommence() {
		if(!noyauFonctionnel.getPlateau().getCartesSelectionnees()) {
			// ne rien faire : le joueur courant est humain
		} else {
			// le joueur courant est une IA qui a selectionne les 2 cartes
			jouerTourIA();
		}
	}
	
	/**
	 * Traite la selection d'une carte
	 * @param carte ModeleCarte : la carte selectionnee
	 */
	public void notificationClic(ModeleCarte carte) {
		controleurPlateau.getEtatCourantPlateau().carteCliquee(carte);
	}
	
	// -- GESTION DES OBSERVATEURS DU PLATEAU -- //
	
	/**
	 * Ajoute un observateur du plateau a la liste
	 * @param observer IObserverPlateau : l'observateur a ajouter
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
	
	/**
	 * Bloquer l'ensemble des cartes non selectionnees du plateau.</br>
	 * Permet d'eviter de selectionner plus de cartes qu'il ne faut.
	 */
	public void bloquerCartesPasSelectionnees() {
		ListIterator<IObserverPlateau> iterator = listeObservateursPlateau.listIterator();
		while(iterator.hasNext()) {
			iterator.next().bloquerCarte(true);
		}
	}
	
	/**
	 * Met a jour les cartes conformement au resultat de la comparaison de la paire selectionnee
	 */
	public void miseAJourCartes() {
		
		Thread attente = new Thread() {
			public void run() {
				//Attente pendant "delai" millisecondes
				long reveil = System.currentTimeMillis();
				while(System.currentTimeMillis() <= (reveil +delai)) {}
				
				// Mise a jour des cartes
				ListIterator<IObserverPlateau> iterator = listeObservateursPlateau.listIterator();
				IObserverPlateau _observer;
				while(iterator.hasNext()) {
					_observer = iterator.next();
					// debloque les cartes
					_observer.bloquerCarte(false);
					// informe les observateurs du resultat de la comparaison
					_observer.notificationComparaison(cartesIdentiques);
				}
			}
		};
		attente.start();
	}
	
	// -- COMPORTEMENT -- //
	
	/**
	 * Lance les actions suites a la selection de la premiere carte
	 * @param carte1 ModeleCarte : la premiere carte cliquee
	 */
	public void setCarte1(ModeleCarte carte1) {
		// enregistre la position de la carte dans la liste
		positionCarte1 = listeCartesSurPlateau.indexOf(carte1);
		
		// indique au noyau fonctionnel quelle carte a ete selectionnee en premiere
		noyauFonctionnel.getPlateau().setCarte1(noyauFonctionnel.getPlateau().getListeCartesMelangees().get(positionCarte1));
	}
	
	/**
	 * Lance les actions suites a la selection de la seconde carte
	 * @param carte2 ModeleCarte : la seconde carte cliquee
	 */
	public void setCarte2(ModeleCarte carte2) {
		// enregistre la position de la carte dans la liste
		positionCarte2 = listeCartesSurPlateau.indexOf(carte2);
		
		// indique au noyau fonctionnel quelle carte a ete selectionnee en seconde
		noyauFonctionnel.getPlateau().setCarte2(noyauFonctionnel.getPlateau().getListeCartesMelangees().get(positionCarte2));
		
		// bloque l'ensemble des cartes non selectionnees
		bloquerCartesPasSelectionnees();
		
		// lance la comparaison des deux cartes selectionnes
		controleurPlateau.getEtatCourantPlateau().comparaisonCartes();
	}
	
	public void jouerTourIA() {
		// bloquage de toutes les cartes pour eviter les clics utilisateurs
		bloquerCartesPasSelectionnees();
		
		// Thread de gestion de l'attente durant le tour d'un joueur IA
		Thread attente = new Thread() {
			public void run() {
				//Attente pendant 800 millisecondes
				long reveil1 = System.currentTimeMillis();
				while(System.currentTimeMillis() <= (reveil1 + 800)) {}
				
				// debloquage de la premiere carte selectionnee par l'IA et simuation d'un clic sur elle
				int _positionCarte1IA = noyauFonctionnel.getPlateau().getListeCartesMelangees().
						indexOf(noyauFonctionnel.getJoueurCourant().getCarte1());
				listeCartesSurPlateau.get(_positionCarte1IA).bloquerCarte(false);
				listeCartesSurPlateau.get(_positionCarte1IA).getVueCarte().doClick();
				
				//Attente pendant 800 millisecondes
				long reveil2 = System.currentTimeMillis();
				while(System.currentTimeMillis() <= (reveil2 + 800)) {}
			
				// debloquage de la seconde carte selectionnee par l'IA et simulation d'un clic sur elle
				int _positionCarte2IA = noyauFonctionnel.getPlateau().getListeCartesMelangees().
						indexOf(noyauFonctionnel.getJoueurCourant().getCarte2());
				listeCartesSurPlateau.get(_positionCarte2IA).bloquerCarte(false);
				listeCartesSurPlateau.get(_positionCarte2IA).getVueCarte().doClick();
			}
		};
		attente.start();
	}
	
	public void compareCartes() {
		cartesIdentiques = noyauFonctionnel.getPlateau().comparaisonPaire();
		miseAJourCartes();
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le nombre de cartes composant le plateau
	 * @return nbCartesSurPlateau int : le nombre de carte sur le plateau
	 */
	public int getNbCartesSurPlateau() {
		return nbCartesSurPlateau;
	}
	
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
	 * Obtient la liste des cartes composant le plateau
	 * @return listeCartesSurPlateau ArrayList&lsaquo;ModeleCarte&rsaquo; : la liste des cartes sur le plateau
	 */
	public ArrayList<ModeleCarte> getListeCartesSurPlateau() {
		return listeCartesSurPlateau;
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
	
	/**
	 * Obtient la reference de la vue de l'agent plateau
	 * @return vuePlateau VuePlateau : la vue de l'agent plateau
	 */
	public VuePlateau getVuePlateau() {
		return controleurPlateau.getVuePlateau();
	}
	
}
