package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

import javax.swing.JTable;

/**
 * Classe representant la vue du joueur courant.</br>
 * Classe heritant de JTable pour l'affichage des informations concernant le joueur courant.
 * 
 * @author clementdouault
 *
 */
public class VueJoueurCourant extends JTable {

	/**
	 * Reference du modele du joueur courant
	 */
	private ModeleJoueurCourant modeleJoueurCourant;
	
	/**
	 * Reference du controleur du joueur courant
	 */
	private ControleurJoueurCourant controleurJoueurCourant;
	
	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur de la vue du joueur courant
	 * @param modeleJoueurCourant ModeleJoueurCourant : la reference du modele
	 * @param controleurJoueurCourant ControleurJoueurCourant : la reference du controleur
	 */
	public VueJoueurCourant(ModeleJoueurCourant modeleJoueurCourant, 
			ControleurJoueurCourant controleurJoueurCourant) {
		// creation d'un tableau a 3 lignes et 2 colonnes
		super(3,2);
		setEnabled(false);
		setValueAt("Nom", 0, 0);
		setValueAt("Score", 1, 0);
		setValueAt("Serie", 2, 0);
		
		this.modeleJoueurCourant = modeleJoueurCourant;
		this.controleurJoueurCourant = controleurJoueurCourant;
		
		updateVueNom();
		updateVueScore();
		updateVueSerie();
	}
	
	// -- GESTION DE LA MISE A JOUR DE LA VUE -- //
	
	/**
	 * Met a jour le champ nom de la vue
	 */
	public void updateVueNom() {
		setValueAt(modeleJoueurCourant.getNomCourant(), 0, 1);
	}
	
	/**
	 * Met a jour le champ score de la vue
	 */
	public void updateVueScore() {
		setValueAt(modeleJoueurCourant.getScoreCourant(), 1, 1);
	}
	
	/**
	 * Met a jour le champ serie de la vue
	 */
	public void updateVueSerie() {
		setValueAt(modeleJoueurCourant.getSerieCourante(), 2, 1);
	}
	
	/**
	 * Met a jour l'ensemble des trois champs de la vue
	 */
	public void refreshVue() {
		updateVueNom();
		updateVueScore();
		updateVueSerie();
	}
	
	private static final long serialVersionUID = 1L;
}
