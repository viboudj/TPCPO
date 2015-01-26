package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ModeleJoueurs;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant.ModeleJoueurCourant;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.IObserverPlateau;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.ModelePlateau;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

/**
 * Classe representant le modele de la partie conformement a l'architecture MVC.</br>
 * Implemente IObserverPlateau afin
 * d'etre informe du resultat de la comparaison des deux cartes selectionnees
 * 
 * @author clementdouault
 *
 */
public class ModelePartie implements IObserverPlateau {

	/**
	 * Reference du noyau fonctionnel
	 */
	private Partie noyauFonctionnel;
	
	/**
	 * Reference du controleur de la partie
	 */
	private ControleurPartie controleurPartie;
	
	/**
	 * Reference du modele du plateau
	 */
	private ModelePlateau modelePlateau;
	
	/**
	 * Reference du modele de la liste des joueurs
	 */
	private ModeleJoueurs modeleJoueurs;
	
	/**
	 * Reference du modele du joueur courant
	 */
	private ModeleJoueurCourant modeleJoueurCourant;
	
	/**
	 * Nombre de paires restantes sur le plateau
	 */
	private int nbPairesRestantes;
	
	/**
	 * Nom du joueur vainqueur
	 */
	private String nomVainqueur;
	
	/**
	 * Score du joueur vainqueur
	 */
	private int scoreVainqueur;
	
	/**
	 * Nombre total de paires trouvees par le joueur vainqueur
	 */
	private int pairesVainqueurs;
	
	/**
	 * Liste des observateurs de la partie
	 */
	private ArrayList<IObserverPartie> listeObervateursPartie;

	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur du modele de la partie
	 * @param noyauFonctionnel Partie : reference du noyau fonctionnel du jeu
	 */
	public ModelePartie(Partie noyauFonctionnel) {
		this.noyauFonctionnel = noyauFonctionnel;
		nbPairesRestantes = noyauFonctionnel.getPlateau().getNbrCartesRestantes()/2;		
		listeObervateursPartie = new ArrayList<IObserverPartie>();
		
		// instantiation de tous les elements du jeu
		modelePlateau = new ModelePlateau(noyauFonctionnel);
		modeleJoueurs = new ModeleJoueurs(noyauFonctionnel);
		modeleJoueurCourant = new ModeleJoueurCourant(noyauFonctionnel);
		
		// abonnement de partie au plateau
		modelePlateau.addObserverPlateau(this);
		
		// abonnement des modeles joueurs et joueurCourant 
		listeObervateursPartie = new ArrayList<IObserverPartie>();
		listeObervateursPartie.add(modeleJoueurs);
		listeObervateursPartie.add(modeleJoueurCourant);
		
		controleurPartie = new ControleurPartie(this);
		debutNouveauTour();
	}
	
	// -- OBSERVATION DU PLATEAU -- //
	
	public void notificationComparaison(boolean resultatComparaison) {
		majComparaison();
	}

	/**
	 * Methode vide car sans effet pour le modele de partie
	 * @param carteBloquee
	 */
	public void bloquerCarte(boolean carteBloquee) {		
	}
	
	// -- GESTION DES OBSERVATEURS DE LA PARTIE -- //
	
	/**
	 * Ajoute un observateur de la partie a la liste des observateurs
	 * @param observer IObserverPartie : l'observateur a ajouter
	 */
	public void addObserverPartie(IObserverPartie observer) {
		listeObervateursPartie.add(observer);
	}
	
	/**
	 * Supprimer un observateur de la partie de la liste des observateurs
	 * @param observer IObserverPartie : l'observateur a ajouter
	 */
	public void removeObserverPartie(IObserverPartie observer) {
		listeObervateursPartie.remove(observer);
	}
	
	/**
	 * Previens les observateurs d'un changement dans la partie
	 */
	public void notifierObservateur() {
		ListIterator<IObserverPartie> iterator = listeObervateursPartie.listIterator();
		while(iterator.hasNext()) {
			iterator.next().updateJoueurs();
		}
	}
	
	// -- COMPORTEMENT -- //
	
	/**
	 * Lance les actions necessaire en fonction du resultat de la comparaison
	 * des deux cartes selectionnees ce tour.</br>
	 * S'il reste des cartes sur le jeu, lance un nouveau tour de jeu
	 */
	public void majComparaison() {
		noyauFonctionnel.traitement();
		nbPairesRestantes = noyauFonctionnel.getPlateau().getNbrCartesRestantes()/2;
		if(nbPairesRestantes != 0) {
			debutNouveauTour();
		} else {
			controleurPartie.getEtatCourantPartie().plusPaireRestante();
			enregistrementVainqueur();
		}
		controleurPartie.getEtatCourantPartie().updateVue();
		notifierObservateur();
	}
	
	/**
	 * Lance un nouveau tour permettant aux IA de selectionner les deux cartes.</br>
	 * Previent ensuite le plateau
	 */
	public void debutNouveauTour() {
		noyauFonctionnel.getJoueurCourant().jouer();
		modelePlateau.nouveauTourCommence();
	}
	
	/**
	 * Methode enregistrant les donnees du joueur vainqueur en fonction
	 * des informations contenues dans le noyau fonctionnel
	 */
	public void enregistrementVainqueur() {
		nomVainqueur = noyauFonctionnel.joueurGagant().getNom();
		scoreVainqueur = noyauFonctionnel.joueurGagant().getScore().getScore();
		pairesVainqueurs = noyauFonctionnel.joueurGagant().getNbrPairesTrouvees();
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient la reference du modele du plateau
	 * @return modelePlateau ModelePlateau : la reference du modele du plateau
	 */
	public ModelePlateau getModelePlateau() {
		return modelePlateau;
	}

	/**
	 * Obtient la reference du modele de la liste des joueurs
	 * @return modeleJoueurs ModeleJoueurs : la reference du modele de la liste des joueurs
	 */
	public ModeleJoueurs getModeleJoueurs() {
		return modeleJoueurs;
	}

	/**
	 * Obtient la reference du modele du joueur courant
	 * @return modeleJoueurCourant ModeleJoueurCourant : la reference du modele du joueur courant
	 */
	public ModeleJoueurCourant getModeleJoueurCourant() {
		return modeleJoueurCourant;
	}

	/**
	 * Obtient le nombre de paires restantes
	 * @return nbPairesRestantes int : le nombre de paires restantes
	 */
	public int getNbPairesRestantes() {
		return nbPairesRestantes;
	}

	/**
	 * Obtient le nom du vainqueur
	 * @return nomVainqueur String : le nom du vainqueur
	 */
	public String getNomVainqueur() {
		return nomVainqueur;
	}

	/**
	 * Obtient le score du vainqueur
	 * @return scoreVainqueur int : le score du vainqueur
	 */
	public int getScoreVainqueur() {
		return scoreVainqueur;
	}

	/**
	 * Obtient le nombre total de paires trouvees par le vainqueur
	 * @return pairesVainqueurs int : le nombre total de paires trouvees par le vainqueur
	 */
	public int getPairesVainqueurs() {
		return pairesVainqueurs;
	}
}
