package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Classe representant la vue des informations sur les joueurs.</br>
 * Classe heritant de Container et contenant une JTable pour l'organisation des informations 
 * sur les joueurs.
 * 
 * @author clementdouault
 *
 */
public class VueJoueurs extends Container {

	/**
	 * Reference du modele de joueurs
	 */
	private ModeleJoueurs modeleJoueurs;
	
	/**
	 * Reference du controleur de joueurs
	 */
	private ControleurJoueurs controleurJoueurs;
	
	/**
	 * Tableau contenant les informations sur les joueurs : 
	 * nom, score et nombre total de paires trouvees par chacun
	 */
	private JTable infoJoueurs;
	
	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur de la vue des informations des joueurs
	 * @param modeleJoueurs ModeleJoueurs : la reference du modele de joueurs
	 * @param controleurJoueurs ControleurJoueurs : la reference du controleur de joueurs
	 */
	public VueJoueurs(ModeleJoueurs modeleJoueurs, ControleurJoueurs controleurJoueurs) {
		this.modeleJoueurs = modeleJoueurs;
		this.controleurJoueurs = controleurJoueurs;
		
		String[] columnNames = {"Joueur","Score","Nb paires trouvées"};
		Object[][] data = new Object[modeleJoueurs.getNbJoueurs()][3];
		for(int i=0 ; i<modeleJoueurs.getNbJoueurs() ; i++){
			data[i][0] = modeleJoueurs.getListeNomJoueurs().get(i);
			data[i][1] = modeleJoueurs.getListeScoreJoueurs().get(i).toString();
			data[i][2] = modeleJoueurs.getListePairesTrouvees().get(i).toString();
		}
		
		infoJoueurs = new JTable(data, columnNames);
		infoJoueurs.setEnabled(false);
		setLayout(new BorderLayout());
		add(new JScrollPane(infoJoueurs), BorderLayout.CENTER);
		
	}

	// -- GESTION DE LA MISE A JOUR DE LA VUE -- //
	
	/**
	 * Met a jour le champ nom du i-eme joueur
	 * @param numeroJoueur int : le numero du joueur
	 */
	public void updateVueListeNom(int numeroJoueur) {
		infoJoueurs.setValueAt(modeleJoueurs.getListeNomJoueurs().get(numeroJoueur), numeroJoueur, 0);
	}
	
	/**
	 * Met a jour le champ score du i-eme joueur
	 * @param numeroJoueur int : le numero du joueur
	 */
	public void updateVueListeScore(int numeroJoueur) {
		infoJoueurs.setValueAt(modeleJoueurs.getListeScoreJoueurs().get(numeroJoueur).toString(), numeroJoueur, 1);
	}
	
	/**
	 * Met a jour le champ listePaires du i-eme joueur
	 * @param numeroJoueur int : le numero du joueur
	 */
	public void updateVueListePaires(int numeroJoueur) {
		infoJoueurs.setValueAt(modeleJoueurs.getListePairesTrouvees().get(numeroJoueur).toString(), numeroJoueur, 2);
	}
	
	/**
	 * Met a jour l'ensemble des champs de la vue
	 */
	public void refreshVue() {
		for (int i=0 ; i<modeleJoueurs.getNbJoueurs() ; i++) {
			updateVueListeNom(i);
			updateVueListeScore(i);
			updateVueListePaires(i);
		}
	}
}
