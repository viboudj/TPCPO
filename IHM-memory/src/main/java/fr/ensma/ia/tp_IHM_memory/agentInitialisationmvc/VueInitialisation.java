package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class VueInitialisation implements ActionListener {
	
	private ModeleInitialisation modele;
	
	private ControleurInitialisation controleur;
	
	private JFrame fenetreInitialisation ;
	
	private JButton boutonPartieClassique = new JButton();
	
	private JButton boutonPartiePerso = new JButton();
	
	private Dimension dimBouton = new Dimension(200,50);
	
	private Box boite1 = new Box(0);
	
	private Box boite2 = new Box(1);
	
	private JLabel titre = new JLabel();
	
	ActionListener e;
	
	public VueInitialisation(ModeleInitialisation modele,ControleurInitialisation controleur) {
		this.modele=modele;
		this.controleur=controleur;
		
		//definition de la fenetre principale
		fenetreInitialisation=new JFrame();
		fenetreInitialisation.setTitle("Bonjour");
		fenetreInitialisation.setBounds(100, 100, 400, 100);
		Container container = fenetreInitialisation.getContentPane();
		container.setLayout(new BorderLayout());
		
	
		//définition du bouton partie classique
		boutonPartieClassique.setText("Partie Classique");
		boutonPartieClassique.setPreferredSize(dimBouton);
		boutonPartieClassique.addActionListener(this);
		
		//définition du bouton partie personalisée
		boutonPartiePerso.setText("Partie Personnalisée");
		boutonPartiePerso.setPreferredSize(dimBouton);
		boutonPartiePerso.addActionListener(this);
		
		
		//définition du titre
		titre.setText("Bienvenue au jeu du memory!");
		
		
		//définition de la deuxième boite
		boite2 = Box.createHorizontalBox();
		boite2.add(boutonPartieClassique);
		boite2.add(Box.createHorizontalStrut(5));
		boite2.add(boutonPartiePerso);
		boite2.add(Box.createHorizontalBox());
			
		//definition de la première boite
		boite1 = Box.createVerticalBox();
		boite1.add(titre);
		boite1.add(boite2);
		boite1.add(Box.createVerticalGlue());
		
		//définition du titre
		titre.setText("Bienvenue au jeu du memory!");
		titre.setFont(new Font("Calibri", Font.BOLD, 18));
		
		container.add(boite1,BorderLayout.CENTER);
		
		fenetreInitialisation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetreInitialisation.setVisible(true);
						
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boutonPartieClassique) {
			controleur.partieClassique();
		}
		
		if (e.getSource()==boutonPartiePerso) {
			controleur.partiePerso();
		}
		
	}
	



	public ModeleInitialisation getModele() {
		return modele;
	}



	public void setModele(ModeleInitialisation modele) {
		this.modele = modele;
	}



	public ControleurInitialisation getControleur() {
		return controleur;
	}



	public void setControleur(ControleurInitialisation controleur) {
		this.controleur = controleur;
	}



	public JFrame getFenetreInitialisation() {
		return fenetreInitialisation;
	}



	public void setFenetreInitialisation(JFrame fenetreInitialisation) {
		this.fenetreInitialisation = fenetreInitialisation;
	}



	public JButton getBoutonPartieClassique() {
		return boutonPartieClassique;
	}



	public void setBoutonPartieClassique(JButton boutonPartieClassique) {
		this.boutonPartieClassique = boutonPartieClassique;
	}



	public JButton getBoutonPartiePerso() {
		return boutonPartiePerso;
	}



	public void setBoutonPartiePerso(JButton boutonPartiePerso) {
		this.boutonPartiePerso = boutonPartiePerso;
	}



	public Dimension getDimBouton() {
		return dimBouton;
	}



	public void setDimBouton(Dimension dimBouton) {
		this.dimBouton = dimBouton;
	}



	public Box getBoite1() {
		return boite1;
	}



	public void setBoite1(Box boite1) {
		this.boite1 = boite1;
	}



	public Box getBoite2() {
		return boite2;
	}



	public void setBoite2(Box boite2) {
		this.boite2 = boite2;
	}



	public JLabel getTitre() {
		return titre;
	}



	public void setTitre(JLabel titre) {
		this.titre = titre;
	}
	

}
