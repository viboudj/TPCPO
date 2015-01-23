package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Classe representant la vue du plateau de memory.</br>
 * Classe heritant de JPanel et comportant un conteneur affecte d'un agent GridLayout 
 * pour la disposition des cartes sur le plateau.
 * 
 * @author clementdouault
 *
 */
public class VuePlateau extends JPanel {
	
	/**
	 * Reference du modele du plateau
	 */
	private ModelePlateau modelePlateau;
	
	/**
	 * Reference du controleur du plateau
	 */
	private ControleurPlateau controleurPlateau;
	
	/**
	 * Grille comportant la vue des cartes
	 */
	private Container grilleCartes = new Container();
	
	/**
	 * Couleur de la bordure du plateau
	 */
	private Color couleurBordure = new Color(247, 159, 129);
	
	/**
	 * Bordure du plateau
	 */
	private Border bordure = new LineBorder(couleurBordure, 2, false);
	
	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur de la vue du plateau
	 * @param modelePlateau ModelePlateau : le modele du plateau
	 * @param controleurPlateau ControleurPlateau : le controleur du plateau
	 */
	public VuePlateau(ModelePlateau modelePlateau, ControleurPlateau controleurPlateau) {
		this.modelePlateau = modelePlateau;
		this.controleurPlateau = controleurPlateau;
		
		// creation de la grille avec le nombre de lignes et colonnes adequat
		grilleCartes.setLayout(new GridLayout(modelePlateau.getNbLignes(), modelePlateau.getNbColonnes()));
		
		// remplissage de la grille
		remplissageGrille();
		
		// mise en forme du JPanel
		setBorder(bordure);
		setBackground(Color.WHITE);
		add(grilleCartes, BorderLayout.CENTER);
	}
	
	/**
	 * Remplit la grille avec la vue de chacune des cartes du plateau
	 */
	public void remplissageGrille() {
		for (int i=0 ; i < modelePlateau.getNbCartesSurPlateau() ; i++) {
			grilleCartes.add(modelePlateau.getListeCartesSurPlateau().get(i).getVueCarte(), BorderLayout.CENTER);
		}
	}
	
	private static final long serialVersionUID = 1L;
}
