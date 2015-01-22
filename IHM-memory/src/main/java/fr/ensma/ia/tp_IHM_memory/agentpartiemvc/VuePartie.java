package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VuePartie extends JFrame implements ActionListener {

	private ModelePartie modelePartie;
	
	private ControleurPartie controleurPartie;
	
	private Container container;
	
	private Box infoJoueurs;
	
	private Box infoPlateau;
		
	private JLabel memory = new JLabel();
	
	private JLabel pairesRestantes = new JLabel();
	
	private JButton recommencer = new JButton();
	
	public VuePartie(ModelePartie modelePartie, ControleurPartie controleurPartie) {
		this.modelePartie = modelePartie;
		this.controleurPartie = controleurPartie;
		container = getContentPane();
		
		// formatage du JLabel memory et ajout au conteneur
		memory.setText("<html><font color = #F79F81 >MEMORY</font></html>");
		memory.setFont(new Font("Calibri", Font.BOLD, 36));
		container.add(memory, BorderLayout.NORTH);
		
		// formatage du JLabel pairesRestantes et du JButton
		updatePairesRestantes();
		recommencer.setText("Rejouer");
		recommencer.addActionListener(this);
		
		// organisation des infos sur les joueurs et le joueur courant
		infoJoueurs = Box.createVerticalBox();
		infoJoueurs.add(modelePartie.getModeleJoueurs().getVueJoueurs());
		infoJoueurs.add(Box.createVerticalGlue());
		infoJoueurs.add(modelePartie.getModeleJoueurCourant().getVueJoueurCourant());
		
		// or
	}
	
	public void updatePairesRestantes() {
		pairesRestantes.setText("Paires restantes : " + modelePartie.getNbPairesRestantes());
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
