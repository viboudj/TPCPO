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
import javax.swing.ButtonGroup;
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
			// TODO : getData de toute la vue
			
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
}


//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.Box;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.ControleurInitialisation;
//import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.ModeleInitialisation;
//
//
//
//public class VueInitialisation implements ActionListener {
//	
//	private ModeleInitialisation modele;
//	
//	private ControleurInitialisation controleur;
//	
//	private JFrame fenetreInitialisation ;
//	
//	private JButton boutonPartieClassique = new JButton();
//	
//	private JButton boutonPartiePerso = new JButton();
//	
//	private Dimension dimBouton = new Dimension(200,50);
//	
//	private Box boite1 = new Box(0);
//	
//	private Box boite2 = new Box(1);
//	
//	private JLabel titre = new JLabel();
//	
//	ActionListener e;
//	
//	public VueInitialisation(ModeleInitialisation modele,ControleurInitialisation controleur) {
//		this.modele=modele;
//		this.controleur=controleur;
//		
//		//definition de la fenetre principale
//		fenetreInitialisation=new JFrame();
//		fenetreInitialisation.setTitle("Bonjour");
//		fenetreInitialisation.setBounds(100, 100, 400, 100);
//		Container container = fenetreInitialisation.getContentPane();
//		container.setLayout(new BorderLayout());
//		
//	
//		//définition du bouton partie classique
//		boutonPartieClassique.setText("Partie Classique");
//		boutonPartieClassique.setPreferredSize(dimBouton);
//		boutonPartieClassique.addActionListener(this);
//		
//		//définition du bouton partie personalisée
//		boutonPartiePerso.setText("Partie Personnalisée");
//		boutonPartiePerso.setPreferredSize(dimBouton);
//		boutonPartiePerso.addActionListener(this);
//		
//		
//		//définition du titre
//		titre.setText("Bienvenue au jeu du memory!");
//		
//		
//		//définition de la deuxième boite
//		boite2 = Box.createHorizontalBox();
//		boite2.add(boutonPartieClassique);
//		boite2.add(Box.createHorizontalStrut(5));
//		boite2.add(boutonPartiePerso);
//		boite2.add(Box.createHorizontalBox());
//			
//		//definition de la première boite
//		boite1 = Box.createVerticalBox();
//		boite1.add(titre);
//		boite1.add(boite2);
//		boite1.add(Box.createVerticalGlue());
//		
//		//définition du titre
//		titre.setText("Bienvenue au jeu du memory!");
//		titre.setFont(new Font("Calibri", Font.BOLD, 18));
//		
//		container.add(boite1,BorderLayout.CENTER);
//		
//		fenetreInitialisation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		fenetreInitialisation.setVisible(true);
//						
//	}
//	
//	
//	
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()==boutonPartieClassique) {
//			controleur.partieClassique();
//		}
//		
//		if (e.getSource()==boutonPartiePerso) {
//			controleur.partiePerso();
//		}
//		
//	}
//	
//
//
//
//	public ModeleInitialisation getModele() {
//		return modele;
//	}
//
//
//
//	public void setModele(ModeleInitialisation modele) {
//		this.modele = modele;
//	}
//
//
//
//	public ControleurInitialisation getControleur() {
//		return controleur;
//	}
//
//
//
//	public void setControleur(ControleurInitialisation controleur) {
//		this.controleur = controleur;
//	}
//
//
//
//	public JFrame getFenetreInitialisation() {
//		return fenetreInitialisation;
//	}
//
//
//
//	public void setFenetreInitialisation(JFrame fenetreInitialisation) {
//		this.fenetreInitialisation = fenetreInitialisation;
//	}
//
//
//
//	public JButton getBoutonPartieClassique() {
//		return boutonPartieClassique;
//	}
//
//
//
//	public void setBoutonPartieClassique(JButton boutonPartieClassique) {
//		this.boutonPartieClassique = boutonPartieClassique;
//	}
//
//
//
//	public JButton getBoutonPartiePerso() {
//		return boutonPartiePerso;
//	}
//
//
//
//	public void setBoutonPartiePerso(JButton boutonPartiePerso) {
//		this.boutonPartiePerso = boutonPartiePerso;
//	}
//
//
//
//	public Dimension getDimBouton() {
//		return dimBouton;
//	}
//
//
//
//	public void setDimBouton(Dimension dimBouton) {
//		this.dimBouton = dimBouton;
//	}
//
//
//
//	public Box getBoite1() {
//		return boite1;
//	}
//
//
//
//	public void setBoite1(Box boite1) {
//		this.boite1 = boite1;
//	}
//
//
//
//	public Box getBoite2() {
//		return boite2;
//	}
//
//
//
//	public void setBoite2(Box boite2) {
//		this.boite2 = boite2;
//	}
//
//
//
//	public JLabel getTitre() {
//		return titre;
//	}
//
//
//
//	public void setTitre(JLabel titre) {
//		this.titre = titre;
//	}
//	
//
//}
