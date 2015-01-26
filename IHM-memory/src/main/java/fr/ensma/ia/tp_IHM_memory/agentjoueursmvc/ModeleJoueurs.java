package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import java.util.ArrayList;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.IObserverPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;

/**
 * Classe representant le modele de la liste des joueurs conformement a l'architecture MVC.</br>
 * Implemente IObserverPartie afin d'etre informe des 
 * changements sur les joueurs ou leurs attributs
 * 
 * @author clementdouault
 *
 */
public class ModeleJoueurs implements IObserverPartie {
	
	/**
	 * Reference du noyau fonctionnel
	 */
	private Partie noyauFonctionnel;
	
	/**
	 * Reference du controleur de la liste des joueurs
	 */
	private ControleurJoueurs controleurJoueurs;
	
	/**
	 * Nombre de joueurs dans la partie
	 */
	private int nbJoueurs;
	
	/**
	 * Liste du nom de chaque joueur
	 */
	private ArrayList<String> listeNomJoueurs;
	
	/**
	 * Liste du score de chaque joueur
	 */
	private ArrayList<Integer> listeScoreJoueurs;

	/**
	 * Liste des paires successivement trouvees par chaque joueur
	 */
	private ArrayList<Integer> listePairesTrouvees;

	/**
	 * Constructeur du modele de la liste des joueurs 
	 * @param noyauFonctionnel Partie : la reference du noyau fonctionnel du jeu
	 */
	public ModeleJoueurs(Partie noyauFonctionnel){
		this.noyauFonctionnel=noyauFonctionnel;		
		
		nbJoueurs = noyauFonctionnel.getListeJoueurs().size();
		// remplissage des listes
		initialisationListes();
		// initialisation des infos des joueurs
		
		controleurJoueurs = new ControleurJoueurs(this);
	}
	
	/**
	 * Initialise les differentes listes 
	 * en fonction des informations contenues dans le noyau fonctionnel
	 */
	public void initialisationListes() {
		listeNomJoueurs = new ArrayList<String>(nbJoueurs);
		listeScoreJoueurs = new ArrayList<Integer>(nbJoueurs);
		listePairesTrouvees = new ArrayList<Integer>(nbJoueurs);
		
		for(int i=0 ; i<nbJoueurs ; i++) {
			listeNomJoueurs.add(noyauFonctionnel.getListeJoueurs().get(i).getNom());
			listeScoreJoueurs.add(noyauFonctionnel.getListeJoueurs().get(i).getScore().getScore());
			listePairesTrouvees.add(noyauFonctionnel.getListeJoueurs().get(i).getNbrPairesTrouvees());
		}
	}
	
	// -- OBSERVATION DE LA PARTIE -- //
	
	public void updateJoueurs() {
		updateListeNomJoueurs();
		updateListeScore();
		updateListePaires();
		controleurJoueurs.updateVue();
	}
	
	/**
	 * Met a jour la liste des noms des joueurs avec les informations
	 * contenues dans le noyau fonctionnel
	 */
	public void updateListeNomJoueurs() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listeNomJoueurs.set(i, noyauFonctionnel.getListeJoueurs().get(i).getNom()); 
		}
	}
	
	/**
	 * Met a jour la liste des scores des joueurs avec les informations
	 * contenues dans le noyau fonctionnel
	 */
	public void updateListeScore() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listeScoreJoueurs.set(i, noyauFonctionnel.getListeJoueurs().get(i).getScore().getScore()); 
		}	
	}
	
	/**
	 * Met a jour la liste des paires successivements trouvees
	 * par chaque joueurs avec les informations contenues 
	 * dans le noyau fonctionnel
	 */
	public void updateListePaires() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listePairesTrouvees.set(i, noyauFonctionnel.getListeJoueurs().get(i).getNbrPairesTrouvees()); 
		}
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le nombre de joueur
	 * @return nbJoueur int : le nombre de joueurs
	 */
	public int getNbJoueurs(){
		return nbJoueurs;
	}

	/**
	 * Obtient la liste des noms de chaque joueur
	 * @return listeNomJoueurs ArrayList &lsaquo;String&rsaquo; : la liste des noms
	 */
	public ArrayList<String> getListeNomJoueurs() {
		return listeNomJoueurs;
	}

	/**
	 * Obtient la liste du score de chaque joueur
	 * @return listeNomJoueurs ArrayList &lsaquo;Integer&rsaquo; : la liste des scores
	 */
	public ArrayList<Integer> getListeScoreJoueurs() {
		return listeScoreJoueurs;
	}

	/**
	 * Obtient la liste des paires trouvees par chaque joueur
	 * @return listeNomJoueurs ArrayList &lsaquo;Integer&rsaquo; : la liste des paires successivement trouvees
	 */
	public ArrayList<Integer> getListePairesTrouvees() {
		return listePairesTrouvees;
	}
	
	/**
	 * Obtient la reference de la vue de la liste des joueurs
	 * @return vueJoueurs VueJoueurs : la vue de la liste des joueurs
	 */
	public VueJoueurs getVueJoueurs() {
		return controleurJoueurs.getVueJoueurs();
	}
}
