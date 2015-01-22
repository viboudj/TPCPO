package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ModeleJoueurs;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant.ModeleJoueurCourant;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.IObserverPlateau;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.ModelePlateau;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

public class ModelePartie implements IObserverPlateau {

	private Partie noyauFonctionnel;
	
	private ControleurPartie controleurPartie;
	
	private ModelePlateau modelePlateau;
	
	private ModeleJoueurs modeleJoueurs;
	
	private ModeleJoueurCourant modeleJoueurCourant;
	
	private int nbPairesRestantes;
	
	private ArrayList<IObserverPartie> listeObervateursPartie;

	// -- CONSTRUCTEUR -- //
	
	public ModelePartie() {
		// creation d'une partie par defaut
		noyauFonctionnel = new Partie();
		nbPairesRestantes = noyauFonctionnel.getPlateau().getNbrCartesRestantes();
		
		controleurPartie = new ControleurPartie(this);
		listeObervateursPartie = new ArrayList<IObserverPartie>();
		
		// instantiation de tous les elements du jeu
		modelePlateau = new ModelePlateau(noyauFonctionnel);
		modeleJoueurs = new ModeleJoueurs(noyauFonctionnel);
		modeleJoueurCourant = new ModeleJoueurCourant(noyauFonctionnel);
		
		// abonnement de partie au plateau
		modelePlateau.addObserverPlateau(this);
		
		// abonnement des modeles joueurs et joueurCourant 
		listeObervateursPartie.add(modeleJoueurs);
		listeObervateursPartie.add(modeleJoueurCourant);
	}
	
	// -- OBSERVATION DU PLATEAU -- //
	
	public void notificationComparaison(boolean resultatComparaison) {
		noyauFonctionnel.traitement();
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
	
	public void majComparaison() {
		noyauFonctionnel.traitement();
		nbPairesRestantes = noyauFonctionnel.getPlateau().getNbrCartesRestantes()/2;
		if(nbPairesRestantes == 0) {
			controleurPartie.getEtatCourantPartie().plusPaireRestante();
		}
	}
	
	// -- ACCESSEURS -- //
	
	public ModelePlateau getModelePlateau() {
		return modelePlateau;
	}

	public ModeleJoueurs getModeleJoueurs() {
		return modeleJoueurs;
	}

	public ModeleJoueurCourant getModeleJoueurCourant() {
		return modeleJoueurCourant;
	}

	public int getNbPairesRestantes() {
		return nbPairesRestantes;
	}
}
