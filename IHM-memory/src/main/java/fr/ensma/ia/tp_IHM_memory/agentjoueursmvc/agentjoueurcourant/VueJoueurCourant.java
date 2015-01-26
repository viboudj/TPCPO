package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

/**
 * Classe representant la vue du joueur courant.</br>
 * Classe heritant de JTable pour l'affichage des informations concernant le joueur courant.
 * 
 * @author clementdouault
 *
 */
public class VueJoueurCourant extends Container {

	/**
	 * Reference du modele du joueur courant
	 */
	private ModeleJoueurCourant modeleJoueurCourant;
	
	/**
	 * Reference du controleur du joueur courant
	 */
	private ControleurJoueurCourant controleurJoueurCourant;
	
	/**
	 * Tableau contenant les informations du joueur courant
	 */
	private JTable infoJoueurCourant;
	
	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur de la vue du joueur courant
	 * @param modeleJoueurCourant ModeleJoueurCourant : la reference du modele
	 * @param controleurJoueurCourant ControleurJoueurCourant : la reference du controleur
	 */
	public VueJoueurCourant(ModeleJoueurCourant modeleJoueurCourant, 
			ControleurJoueurCourant controleurJoueurCourant) {
		setPreferredSize(new Dimension(200,100));
		setLayout(new BorderLayout());
		
		// creation d'un tableau a 3 lignes et 2 colonnes
		infoJoueurCourant = new JTable(3,2);
		infoJoueurCourant.setBorder(new LineBorder(Color.LIGHT_GRAY));
		infoJoueurCourant.setEnabled(false);
		infoJoueurCourant.setValueAt("Nom", 0, 0);
		infoJoueurCourant.setValueAt("Score", 1, 0);
		infoJoueurCourant.setValueAt("Serie", 2, 0);
		
		this.modeleJoueurCourant = modeleJoueurCourant;
		this.controleurJoueurCourant = controleurJoueurCourant;
		
		updateVueNom();
		updateVueScore();
		updateVueSerie();
		
		// ajout du tableau dans le container
		Box colonne = Box.createVerticalBox();
		JLabel titre = new JLabel();
		titre.setText("<html><font color = #F79F81 >Joueur courant :</font></html>");
		titre.setFont(new Font("Calibri", Font.BOLD, 20));
		colonne.add(titre);
		colonne.add(infoJoueurCourant);
		add(colonne);
	}
	
	// -- GESTION DE LA MISE A JOUR DE LA VUE -- //
	
	/**
	 * Met a jour le champ nom de la vue
	 */
	public void updateVueNom() {
		infoJoueurCourant.setValueAt(modeleJoueurCourant.getNomCourant(), 0, 1);
	}
	
	/**
	 * Met a jour le champ score de la vue
	 */
	public void updateVueScore() {
		infoJoueurCourant.setValueAt(modeleJoueurCourant.getScoreCourant(), 1, 1);
	}
	
	/**
	 * Met a jour le champ serie de la vue
	 */
	public void updateVueSerie() {
		infoJoueurCourant.setValueAt(modeleJoueurCourant.getSerieCourante(), 2, 1);
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
