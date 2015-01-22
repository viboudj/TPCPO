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

	private ModeleJoueurCourant modele;
	
	private ControleurJoueurCourant controler;
	
	public VueJoueurCourant(ModeleJoueurCourant modele, ControleurJoueurCourant controleur) {
		// creation d'un tableau a 3 lignes et 2 colonnes
		super(3,2);
		setEnabled(false);
		setValueAt("Nom", 1, 1);
		setValueAt("Score", 2, 1);
		setValueAt("Serie", 3, 1);
		
		this.modele = modele;
		this.controler = controleur;
	}
	
	public void updateVueNom() {
		setValueAt(modele.getNomCourant(), 1, 2);
	}
	
	public void updateVueScore() {
		setValueAt(modele.getScoreCourant(), 2, 2);
	}
	
	public void updateVueSerie() {
		setValueAt(modele.getSerieCourante(), 3, 2);
	}
	
	public void refreshVue() {
		updateVueNom();
		updateVueScore();
		updateVueSerie();
	}
	
	private static final long serialVersionUID = 1L;
}
