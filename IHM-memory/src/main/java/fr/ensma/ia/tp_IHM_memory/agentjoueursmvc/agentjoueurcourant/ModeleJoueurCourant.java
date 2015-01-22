package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.IObserverPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

/**
 * Classe representant le modele du joueur courant conformement a l'architecture MVC.</br>
 * Implemente IObserverPartie afin d'etre informe des changements concernant le joueur courant.
 * 
 * @author clementdouault
 *
 */
public class ModeleJoueurCourant implements IObserverPartie {
	
	/**
	 * Reference du noyau fonctionnel
	 */
	private Partie noyauFonctionnel;
	
	/**
	 * Reference du controleur du joueur courant
	 */
	private ControleurJoueurCourant controleurJoueurCourant;
	
	/**
	 * Nom du joueur courant
	 */
	private String nomCourant;
	
	/**
	 * Valeur du score courant
	 */
	private int scoreCourant;
	
	/**
	 * Valeur de la serie courante
	 */
	private int serieCourante;

	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur du modele de joueur courant
	 * @param noyauFonctionnel Partie : la reference du noyau fonctionnel
	 */
	public ModeleJoueurCourant(Partie noyauFonctionnel) {
		this.noyauFonctionnel = noyauFonctionnel;
		controleurJoueurCourant = new ControleurJoueurCourant(this);
		// initialisation des infos du joueur courant
		updateNomCourant();
		updateScoreCourant();
		updateSerieCourante();
	}
	
	// -- OBSERVATION DE LA PARTIE -- //
	
	public void updateJoueurs() {
		updateNomCourant();
		updateScoreCourant();
		updateSerieCourante();
		controleurJoueurCourant.updateVue();
		
	}
	
	/**
	 * Met a jour le nom courant avec celui contenu dans le noyau
	 */
	public void updateNomCourant() {
		nomCourant = noyauFonctionnel.getJoueurCourant().getNom();
	}

	/**
	 * Met a jour la valeur du score avec  celle contenue dans le noyau
	 */
	public void updateScoreCourant() {
		scoreCourant = noyauFonctionnel.getJoueurCourant().getScore().getScore();
	}
	
	/**
	 * Met a jour la valeur de la serie courante avec celle contenue dans le noyau
	 */
	public void updateSerieCourante() {
		serieCourante = noyauFonctionnel.getJoueurCourant().getNbrPairesSuccessives();
	}
	
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le nom du joueur courant
	 * @return nomCourant String : le nom du joueur courant
	 */
	public String getNomCourant() {
		return nomCourant;
	}
	
	/**
	 * Obtient la valeur du score courant
	 * @return scoreCourant int : le score courant
	 */
	public int getScoreCourant() {
		return scoreCourant;
	}
	
	/**
	 * Obtient la valeur de la serie courante
	 * @return serieCourante int : la serie courante
	 */
	public int getSerieCourante() {
		return serieCourante;
	}
}