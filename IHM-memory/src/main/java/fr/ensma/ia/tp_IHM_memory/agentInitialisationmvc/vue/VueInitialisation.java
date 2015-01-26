package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.ControleurInitialisation;
import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.ModeleInitialisation;


/**
 * Classe representant la vue de l'initialisation d'une partie de memory.</br>
 * Classe heritant de JFrame et compose entre autre d'un tableau dynamique pour la gestion
 * des parametres des joueurs.
 * @see InitialisationJoueurs
 * 
 * @author clementdouault
 *
 */
public class VueInitialisation extends JFrame implements ActionListener, KeyListener {
	
	/**
	 * Reference du modele de l'initialisation
	 */
	private ModeleInitialisation modeleInitialisation;
	
	/**
	 * Reference du controleur de l'initialisation
	 */
	private ControleurInitialisation controleurInitialisation;
	
	/**
	 * Parametre du Memory :</br>
	 * Champ permettant d'acquerir le nombre de symboles.
	 */
	private JTextField texteNbSymboles;
	
	/**
	 * Parametre du Memory :</br>
	 * Champ permettant d'acquerir le nombre de paires par symbole.
	 */
	private JTextField texteNbPaires;
	
	/**
	 * Parametre du Memory :</br>
	 * Champ permettant d'acquerir la probabilite d'apparition des cartes bonus.
	 */
	private JTextField texteProbaBonus;
	
	/**
	 * Parametre du Memory :</br>
	 * Bouton indiquant la presence de cartes bonus dans le jeu.
	 */
	private JRadioButton radioAvecBonus;
	
	/**
	 * Parametre du Memory :</br>
	 * Bouton indiquant l'absence de cartes bonus dans le jeu.
	 */
	private JRadioButton radioSansBonus;

	/**
	 * Tableau contenant les donnees relatives aux joueurs (nombres, nom, IA, etc.)
	 * @see InitialisationJoueurs
	 */
	private InitialisationJoueurs tableauParamJoueurs;
	
	/**
	 * Bouton de validation de l'ensemble des donnees saisie
	 */
	private JButton boutonTerminer;
	
	/**
	 * Expression reguliere :</br>
	 * Permet de generer tous les nombres entiers de 1 a 14.</br>
	 * S'applique au controle de la saisie du nombre de symboles.
	 */
	private String regexUnAQuatorze = "[1-9]|1[0-4]";
	
	/**
	 * Expression reguliere :</br>
	 * Permet de generer tous les nombres entiers a partir de 1.</br>
	 * S'applique au controle de la saisie du nombre de paires par symbole.
	 */
	private String regexUnASansLim = "[1-9]+";
	
	/**
	 * Expression reguliere :</br>
	 * Permet de generer tous les nombres entiers de 0 a 10.</br>
	 * S'applique au controle de la saisie de la probabilite d'apparition des cartes bonus.
	 */
	private String regexZeroADix = "[0-9]|10";
	
	/**
	 * Conteneur global contenant les donnees relatives aux cartes
	 */
	private Container contParamCartes;
	
	/**
	 * Dimension des champs de texte
	 */
	private Dimension dimensionTexte = new Dimension(40,20);
	
	/**
	 * Bordure entourant les parametres relatifs au nombre de cartes sur le jeu
	 */
	private Border bordureParamCartes;
	
	/**
	 * Bordure entourant les parametres relatifs a l'appartition des cartes bonus
	 */
	private Border bordureParamBonus;
	
	/**
	 * Police appliquee aux bordures
	 */
	private Font fontBordure = new Font("Calibri", Font.BOLD, 13);
	
	/**
	 * Couleur appliquee aux bordures
	 */
	private Color couleurBordure = new Color(182, 48, 4);
	
	/**
	 * Style de la ligne des bordures
	 */
	private Border ligneBordure = new LineBorder(new Color(247, 159, 129), 2, false);

	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur de la vue d'initialisation de la partie
	 * @param modeleInitialisation ModeleInitialisation : le modele de l'initialisation
	 * @param controleurInitialisation v : le controleur de l'initialisation
	 */
	public VueInitialisation(ModeleInitialisation modeleInitialisation, 
			ControleurInitialisation controleurInitialisation) {
		this.modeleInitialisation = modeleInitialisation;
		this.controleurInitialisation = controleurInitialisation;
		
		setTitle("Initialisation");
		setBounds(450,300, 300, 300);
		
		// creation des deux parties de la frame : 
		// 		les parametres de joueurs 
		// 		les parametres de cartes
		creationParametreCartes();
		tableauParamJoueurs = new InitialisationJoueurs();
		tableauParamJoueurs.setBackground(this.getBackground());
		
		// mise en commun des deux parties dans la frame
		Box boitePrincipale = Box.createHorizontalBox();
		boitePrincipale.add(Box.createHorizontalStrut(5));
		boitePrincipale.add(tableauParamJoueurs);
		boitePrincipale.add(Box.createHorizontalStrut(5));
		boitePrincipale.add(contParamCartes);
		boitePrincipale.add(Box.createHorizontalStrut(5));
		getContentPane().add(boitePrincipale, BorderLayout.CENTER);
		pack();
		int x = getWidth();
		int y = getHeight();
		setMinimumSize(new Dimension(x+5, y+5));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	/**
	 * Methode permettant de creer la vue de gauche contenant 
	 * les parametres relatifs aux cartes
	 */
	public void creationParametreCartes() {
		// creation de la Box contenant les parametres de nombres de cartes
		Box boiteParamNbCartes = Box.createVerticalBox();
			
			// creation de la zone de saisie du nombre de symboles
			Container contSymbole = new Container();
			contSymbole.setLayout(new BorderLayout());
			JLabel labelSymbole = new JLabel(" Nombre de symboles : ");
			texteNbSymboles = new JFormattedTextField(new NumberFormatter());
			texteNbSymboles.setText("8"); // valeur par default
			texteNbSymboles.setPreferredSize(dimensionTexte);
			texteNbSymboles.addKeyListener(this);
			contSymbole.add(labelSymbole, BorderLayout.WEST);
			contSymbole.add(texteNbSymboles, BorderLayout.EAST);
			boiteParamNbCartes.add(contSymbole);
			
			// commentaire lie a la saisie du nombre de symboles
			JPanel panelCommentaireSymb = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelCommentaireSymb = new JLabel("(entre 1 et 14)");
			labelCommentaireSymb.setFont(new Font("Calibri",Font.ITALIC,10));
			panelCommentaireSymb.add(labelCommentaireSymb);
			boiteParamNbCartes.add(panelCommentaireSymb);

			// creation de la zone de saisie du nombre de paires par symbole
			Container contNbPaires = new Container();
			contNbPaires.setLayout(new BorderLayout());
			JLabel labelNbPaires = new JLabel(" Nombre paires/symbole : ");
			texteNbPaires = new JFormattedTextField(new NumberFormatter());
			texteNbPaires.setText("2"); // valeur par default
			texteNbPaires.setPreferredSize(dimensionTexte);
			texteNbPaires.addKeyListener(this);
			contNbPaires.add(labelNbPaires, BorderLayout.WEST);
			contNbPaires.add(texteNbPaires, BorderLayout.EAST);
			boiteParamNbCartes.add(contNbPaires);
			
			// mise en forme de boiteParamCartes avec une bordure
			bordureParamCartes = new TitledBorder(ligneBordure, 
					"Parametres : Nombre de cartes", 
					0, 0, 
					fontBordure, 
					couleurBordure);
			boiteParamNbCartes.setBorder(bordureParamCartes);

		// creation de la boite contenant les parametres relatifs aux cartes bonus
		Box boiteParamBonus = Box.createVerticalBox();
		
			// creation des boutons radios pour la prise en compte ou non des bonus
			radioAvecBonus = new JRadioButton("Avec", true);
			radioAvecBonus.addActionListener(this);
			radioSansBonus = new JRadioButton("Sans", false);
			radioSansBonus.addActionListener(this);
			JPanel panelRadioBonus = new JPanel(new FlowLayout(FlowLayout.CENTER));
			panelRadioBonus.add(radioAvecBonus);
			panelRadioBonus.add(radioSansBonus);
			boiteParamBonus.add(panelRadioBonus);
			
			// creation de la zone de saisie de la probabilite des bonus
			Container contProbaBonus = new Container();
			contProbaBonus.setLayout(new BorderLayout());
			JLabel labelProbaBonus = new JLabel(" Nombre de symboles : ");
			texteProbaBonus = new JFormattedTextField(new NumberFormatter());
			texteProbaBonus.setText("2"); // valeur par default
			texteProbaBonus.setPreferredSize(dimensionTexte);
			texteProbaBonus.addKeyListener(this);
			contProbaBonus.add(labelProbaBonus, BorderLayout.WEST);
			contProbaBonus.add(texteProbaBonus, BorderLayout.EAST);
			boiteParamBonus.add(contProbaBonus);
			
			// commentaire lie a la saisie de la probabilite
			JPanel panelCommentaireProba = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelCommentaireProba = new JLabel("(entre 0 et 10)");
			labelCommentaireProba.setFont(new Font("Calibri",Font.ITALIC,10));
			panelCommentaireProba.add(labelCommentaireProba);
			boiteParamBonus.add(panelCommentaireProba);
			
			// mise en forme de boiteParamCartes avec une bordure
			bordureParamBonus = new TitledBorder(ligneBordure, 
					"Parametres : Cartes Bonus", 
					0, 0, 
					fontBordure, 
					couleurBordure);
			boiteParamBonus.setBorder(bordureParamBonus);
		
		// creation du bouton de validation des parametres
		JPanel panelBoutonTerminer = new JPanel(new FlowLayout(FlowLayout.CENTER));
		boutonTerminer = new JButton("Terminer");
		boutonTerminer.addActionListener(this);
		boutonTerminer.setEnabled(true);
		panelBoutonTerminer.add(boutonTerminer);
		
		// mise en commun des trois zones principales dans le container contParamCartes
		Box boiteParamCartes = Box.createVerticalBox();
		boiteParamCartes.add(boiteParamNbCartes);
		boiteParamCartes.add(Box.createVerticalStrut(5));
		boiteParamCartes.add(boiteParamBonus);
		contParamCartes = new Container();
		contParamCartes.setLayout(new BorderLayout());
		contParamCartes.add(boiteParamCartes, BorderLayout.CENTER);
		contParamCartes.add(panelBoutonTerminer, BorderLayout.SOUTH);
	}
	
	// -- OVERRIDE DES METHODES DES LISTENERS -- //
	
	public void actionPerformed(ActionEvent ev) {
		// traitement du clic sur le bouton terminer
		if (ev.getSource() == boutonTerminer) {
			controleurInitialisation.acquerirParametresPartie();
			dispose();
			
		// inversion des boutons radios lors d'un clic sur l'un des deux
		} else if (ev.getSource() == radioSansBonus) {
			radioSansBonus.setSelected(true);
			radioAvecBonus.setSelected(false);
			texteProbaBonus.setEnabled(false);
			// controle de l'activation du bouton terminer
			if(texteNbSymboles.getText().matches(regexUnAQuatorze) &&
					texteNbPaires.getText().matches(regexUnASansLim)) {
				boutonTerminer.setEnabled(true);
			} else {
				boutonTerminer.setEnabled(false);
			}
			
		// inversion des boutons radios lors d'un clic sur l'un des deux
		} else if (ev.getSource() == radioAvecBonus) {
			radioSansBonus.setSelected(false);
			radioAvecBonus.setSelected(true);
			texteProbaBonus.setEnabled(true);
			// controle de l'activation du bouton terminer
			if(texteNbSymboles.getText().matches(regexUnAQuatorze) &&
					texteNbPaires.getText().matches(regexUnASansLim)) {
				boutonTerminer.setEnabled(true);
			} else {
				boutonTerminer.setEnabled(false);
			}
		}
	}

	public void keyPressed(KeyEvent ev) {}

	public void keyReleased(KeyEvent ev) {
		// controle du contenu des JTextFields des l'ecriture :
		// 		le nombre de paires doit etre de 1 mimimum
		//		le nombre de symbole doit etre compris entre 1 et 14
		//		la probabilite des bonus doit etre comprise entre 0 et 10
		if (ev.getSource() == texteNbPaires || ev.getSource() == texteNbSymboles) {
			if(texteNbSymboles.getText().matches(regexUnAQuatorze) &&
					texteNbPaires.getText().matches(regexUnASansLim)) {
				boutonTerminer.setEnabled(true);
			} else {
				boutonTerminer.setEnabled(false);
			}
		} else {
			if (radioAvecBonus.isSelected()) {
				if(texteProbaBonus.getText().matches(regexZeroADix)) {
					boutonTerminer.setEnabled(true);
				} else
					boutonTerminer.setEnabled(false);
			}
		}

	}

	public void keyTyped(KeyEvent ev) {}
	
	// -- ACCESSEURS DES CHAMPS DE PARAMETRAGES -- //
	
	/**
	 * Obtient la valeur du champ acquerant le nombre de symboles dans la partie
	 * @return texteNbSymboles String : le nombre de symboles
	 */
	public JTextField getTexteNbSymboles() {
		return texteNbSymboles;
	}

	/**
	 * Obtient la valeur du champ acquerant le nombre de paires par symbole dans la partie
	 * @return texteNbPaires String : le nombre de paires par symbole
	 */
	public JTextField getTexteNbPaires() {
		return texteNbPaires;
	}

	/**
	 * Obtient la valeur du champ acquerant la valeur de la probablits d'appartition des cartes bonus
	 * @return texteProbaBonus String : la probabilite d'apparition des cartes bonus
	 */
	public JTextField getTexteProbaBonus() {
		return texteProbaBonus;
	}

	/**
	 * Obtient la valeur booleene du bouton radio avecBonus
	 * @return radioAvecBonus Boolean : true si le partie se jouera avec des bonus, false sinon
	 */
	public JRadioButton getRadioAvecBonus() {
		return radioAvecBonus;
	}

	/**
	 * Obtient la reference du tableau de parametrages des joueurs
	 * @return tableauParamJoueurs InitialisationJoueurs : le tableau contenant les parametres de joueurs
	 * @see InitialisationJoueurs
	 */
	public InitialisationJoueurs getTableauParamJoueurs() {
		return tableauParamJoueurs;
	}
	
}
