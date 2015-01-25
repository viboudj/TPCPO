package fr.ensma.ia.tp_IHM_memory.Personnalisation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VuePersonnalisation implements ActionListener, FocusListener,ItemListener {
	
	private ControleurPersonnalisation controleur;
	
	private ModelePersonnalisation modele;
	
	private JFrame fenetrePrincipale;
	
	private Container boite1 = new Container();
	
	private Container boite2 = new Container();
	
	private Container boite3 =new Container();
	
	private JTable listeJoueur = new JTable(5, 2);
	
	private JTextField nbrCartePaire = new JTextField();
	
	private JTextField nbrPaire = new JTextField();
	
	private JTextField probaBonus = new JTextField();
	
	private JTextField nomJoueur = new JTextField();
	
	private JCheckBox possibilitéBonus = new JCheckBox();
	
	private JButton bCreationJoueur = new JButton();
	
	private JButton bAjoutJoueur = new JButton();
	
	private JButton bSupprimeJoueur = new JButton();
	
	private JButton bLancementPartie = new JButton();
	
	ActionListener e;
	

	
	public VuePersonnalisation(ModelePersonnalisation modele,ControleurPersonnalisation controleur){		
		this.modele=modele;
		this.controleur=controleur;
		
		fenetrePrincipale=new JFrame();
		Container c = fenetrePrincipale.getContentPane();
		fenetrePrincipale.setBounds(100, 100, 600, 300);
		c.setLayout(new BorderLayout());
		JLabel titre = new JLabel();
		titre.setText("Personnalisation de la partie");
		titre.setFont(new Font("Calibri", Font.BOLD, 18));
		
		c.add(titre,BorderLayout.NORTH);
		
		boite1.setLayout(new GridLayout(2,2));
	
		boite1.add(listeJoueur);
		
		
		boite2.setLayout(new GridLayout(4,2));
		
		bCreationJoueur.addActionListener(e);
	
		boite2.add(new JLabel("nombre de carte par paire: "));
		boite2.add(nbrCartePaire);
		boite2.add(new JLabel("nombre de symbole: "));
		boite2.add(nbrPaire);
		boite2.add(possibilitéBonus);
		probaBonus.setEnabled(false);
		boite2.add(probaBonus);		
		bCreationJoueur.setText("Création des Joueurs");
		boite2.add(bCreationJoueur);
		
		boite1.add(boite2);
		
		nomJoueur.setEnabled(false);
		bAjoutJoueur.setEnabled(false);
		bSupprimeJoueur.setEnabled(false);
		
		boite3.setLayout(new GridLayout(1,3));
		boite3.add(nomJoueur);
		bAjoutJoueur.setText("Ajouter un joueur");;
		boite3.add(bAjoutJoueur);
		bSupprimeJoueur.setText("Supprime un joueur");
		boite3.add(bSupprimeJoueur);
		
		boite1.add(boite3);
		
		
		bLancementPartie.setEnabled(false);
		bLancementPartie.setText("Lancement de la partie");
		boite1.add(bLancementPartie, BorderLayout.SOUTH);
		c.add(boite1);
		
		
		fenetrePrincipale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetrePrincipale.setVisible(true);	
	
		
				
		
		}



	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==bCreationJoueur){
			boite2.setEnabled(false);
			boite3.setEnabled(true);
			if ( possibilitéBonus.isSelected()==false){
				controleur.CreationPartie(Integer.parseInt(nbrPaire.getText()), 
					Integer.parseInt(nbrCartePaire.getText()), false, 0);
			} else{
				controleur.CreationPartie(Integer.parseInt(nbrPaire.getText()), 
						Integer.parseInt(nbrCartePaire.getText()), true,
						Integer.parseInt(probaBonus.getText()));
			}
			
			System.out.println("bouton clické");
			nomJoueur.setEnabled(true);
			bAjoutJoueur.setEnabled(true);
			bSupprimeJoueur.setEnabled(true);
			
			bCreationJoueur.setEnabled(false);
			possibilitéBonus.setEnabled(false);
			nbrPaire.setEnabled(false);
			nbrCartePaire.setEnabled(false);
		}
		
	}



	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
