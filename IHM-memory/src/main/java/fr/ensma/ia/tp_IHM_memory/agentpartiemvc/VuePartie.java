package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.ModeleInitialisation;

public class VuePartie implements ActionListener {

	private ModelePartie modelePartie;
	
	private ControleurPartie controleurPartie;
	
	// -- ATTRIBUTS RELATIFS A LA FRAME PRINCIPALE -- //
	
	private JFrame frameJeuPrincipale;
		
	private Container containerPrincipal;
	
	private JLabel memory = new JLabel();
	
	private JLabel pairesRestantes = new JLabel();
	
	private JButton recommencerPrincipal = new JButton();
	
	private JButton quitterPrincipal = new JButton();
	
	private JFrame frameJeuVictoire;
	
	private Box ensemblePlateau;
	
	private Container infoJoueurs = new Container();
	
	private Box plateauDeJeu;
	
	private Dimension dimensionBoutons = new Dimension(130, 32);
	
	// -- ATTRIBUTS RELATIFS A LA FRAME DE VICTOIRE

	private Container containerVictoire;
	
	private Box donneesVainqueur;
	
	private JButton recommencerVictoire = new JButton();
	
	private JButton quitterVictoire = new JButton();
	
	public VuePartie(ModelePartie modelePartie, ControleurPartie controleurPartie) {
		this.modelePartie = modelePartie;
		this.controleurPartie = controleurPartie;
		
		frameJeuPrincipale = new JFrame();
		frameJeuPrincipale.setTitle("Memory");
		frameJeuPrincipale.setBounds(50, 50, 800, 800);
		containerPrincipal = frameJeuPrincipale.getContentPane();
		
		// formatage du JLabel pairesRestantes et ajout dans une Box
		updatePairesRestantes();
		Box boxPaires = Box.createVerticalBox();
		boxPaires.add(pairesRestantes);
		boxPaires.add(Box.createVerticalGlue());
		
		// formatage des JButton recommencer et quitter et ajout dans un Box avec pairesRestantes
		recommencerPrincipal.setText("Rejouer");
		recommencerPrincipal.setPreferredSize(dimensionBoutons);
		recommencerPrincipal.addActionListener(this);
		quitterPrincipal.setText("Quitter");
		quitterPrincipal.setPreferredSize(dimensionBoutons);
		quitterPrincipal.addActionListener(this);
		Box pairesPlusBouton = Box.createHorizontalBox();
		pairesPlusBouton.add(boxPaires);
		pairesPlusBouton.add(Box.createHorizontalGlue());
		pairesPlusBouton.add(recommencerPrincipal);
		pairesPlusBouton.add(Box.createHorizontalStrut(5));
		pairesPlusBouton.add(quitterPrincipal);
		
		// ajout de VuePlateau et pairesPlusBouton a la Box plateauJeu
		plateauDeJeu = Box.createVerticalBox();
		plateauDeJeu.add(modelePartie.getModelePlateau().getVuePlateau());
		plateauDeJeu.add(Box.createVerticalStrut(5));
		plateauDeJeu.add(pairesPlusBouton);
		
		// ajout des infos sur les joueurs et le joueur courant au container infoJoueurs
		Container contJoueurs = new Container();
		contJoueurs.setLayout(new BorderLayout());
		contJoueurs.add(modelePartie.getModeleJoueurs().getVueJoueurs(), BorderLayout.CENTER);
		contJoueurs.setPreferredSize(new Dimension(200, 125));
		infoJoueurs.setLayout(new BorderLayout());
		infoJoueurs.add(contJoueurs, BorderLayout.NORTH);
		Box boxJoueurCourant = Box.createVerticalBox();
		boxJoueurCourant.add(modelePartie.getModeleJoueurCourant().getVueJoueurCourant());
		boxJoueurCourant.add(Box.createVerticalStrut(13));
		infoJoueurs.add(boxJoueurCourant, BorderLayout.SOUTH);

		// ajout de plateauDeJeu et infoJoueur a la Box ensemblePlateau
		ensemblePlateau = Box.createHorizontalBox();
		ensemblePlateau.add(Box.createHorizontalStrut(5));
		ensemblePlateau.add(infoJoueurs);
		ensemblePlateau.add(Box.createHorizontalStrut(5));
		ensemblePlateau.add(plateauDeJeu);
		ensemblePlateau.add(Box.createHorizontalStrut(5));
		
		// formatage du JLabel memory et ajout au conteneur
		memory.setText("<html><font color = #F79F81 >MEMORY</font></html>");
		memory.setFont(new Font("Calibri", Font.BOLD, 36));
		JPanel panelLabel = new JPanel();
		panelLabel.add(memory, BorderLayout.CENTER);
		containerPrincipal.add(panelLabel, BorderLayout.NORTH);
		
		// ajout de ensemblePlateau au conteneur
		containerPrincipal.add(ensemblePlateau, BorderLayout.CENTER);
		
		// formatage de la frame principale
		frameJeuPrincipale.pack();
		int _width = frameJeuPrincipale.getWidth();
		int _height = frameJeuPrincipale.getHeight();
		frameJeuPrincipale.setMinimumSize(new Dimension(_width + 5, _height + 5));
		frameJeuPrincipale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameJeuPrincipale.setVisible(true);
	}
	
	public void updatePairesRestantes() {
		pairesRestantes.setText("Paires restantes : " + modelePartie.getNbPairesRestantes());
	}
	
	public void updateVictoire() {
		updatePairesRestantes();
		
		frameJeuVictoire = new JFrame();
		frameJeuVictoire.setTitle("And the winner is...");
		containerVictoire = frameJeuVictoire.getContentPane();
		donneesVainqueur = Box.createVerticalBox();

		// Annonce du vainqueur
		JPanel panelTitre = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel titre = new JLabel("<html><font color = #F79F81 >GAGNANT :</font></html>");
		titre.setFont(new Font("Calibri",Font.BOLD,36));
		panelTitre.add(titre);
		containerVictoire.add(panelTitre,BorderLayout.NORTH);
		
		// Organisation des donnees du vainqueur
		// le nom du vainqueur
		JPanel panelNomVainqueur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel nomVainqueur = new JLabel(modelePartie.getNomVainqueur());
		nomVainqueur.setFont(new Font("Calibri",Font.PLAIN, 36));
		panelNomVainqueur.add(nomVainqueur);
		donneesVainqueur.add(panelNomVainqueur);
		
		// le score du vainqueur
		JPanel panelScoreVainqueur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel scoreVainqueur = new JLabel("Score : " + modelePartie.getScoreVainqueur());
		scoreVainqueur.setFont(new Font("Calibri",Font.PLAIN,26));
		panelScoreVainqueur.add(scoreVainqueur);
		donneesVainqueur.add(panelScoreVainqueur);

		// le nombre de paires trouvees par le vainqueur
		JPanel panelNbPaires = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel nbPairesVainqueur = new JLabel("Nombre de paires : " + modelePartie.getPairesVainqueurs());
		nbPairesVainqueur.setFont(new Font("Calibri",Font.PLAIN,26));
		panelNbPaires.add(nbPairesVainqueur);
		donneesVainqueur.add(panelNbPaires);
				
		// ajout des JButton recommencer et quitter
		recommencerVictoire.setText("Recommencer");
		recommencerVictoire.setPreferredSize(dimensionBoutons);
		recommencerVictoire.addActionListener(this);
		quitterVictoire.setText("Quitter");
		quitterVictoire.setPreferredSize(dimensionBoutons);
		quitterVictoire.addActionListener(this);
		Box boxBoutons = Box.createHorizontalBox();
		boxBoutons.add(recommencerVictoire);
		boxBoutons.add(Box.createHorizontalStrut(5));
		boxBoutons.add(quitterVictoire);
		donneesVainqueur.add(boxBoutons);
		
		containerVictoire.add(donneesVainqueur, BorderLayout.CENTER);
		
		// formatage de la frame victoire
		frameJeuVictoire.pack();
		int _width = frameJeuVictoire.getWidth();
		int _height = frameJeuVictoire.getHeight();
		frameJeuVictoire.setBounds(
				frameJeuPrincipale.getX()+frameJeuPrincipale.getWidth()/2-_width/2,
				frameJeuPrincipale.getY()+frameJeuPrincipale.getHeight()/2-_height/2, _width, _height);
		frameJeuVictoire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameJeuVictoire.setVisible(true);
		frameJeuVictoire.setResizable(false);
		
		frameJeuPrincipale.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == recommencerPrincipal) {
			// demande de confirmation
			if(confirmation("Une partie est en cours, voulez-vous la recommencer ?")) {
				frameJeuPrincipale.dispose();
				new ModeleInitialisation();			
			} 
		} else if (e.getSource() == quitterPrincipal) {
			//demande de confirmation
			if(confirmation("Une partie est en cours, voulez-vous la quitter ?")) {
				frameJeuPrincipale.dispose();
			}
		} else if (e.getSource() == recommencerVictoire) {
			frameJeuPrincipale.dispose();
			frameJeuVictoire.dispose();
			new ModeleInitialisation();	
		} else if (e.getSource() == quitterVictoire) {
			frameJeuPrincipale.dispose();
			frameJeuVictoire.dispose();
		}
	}
	
	public boolean confirmation(String message) {
		JOptionPane confirmation = new JOptionPane();
		int option = JOptionPane.showConfirmDialog(null,
				message, "Confirmation", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(option != JOptionPane.NO_OPTION 
				&& option != JOptionPane.CLOSED_OPTION
				&& option != JOptionPane.CANCEL_OPTION) {
			return true;
		} 
		return false;
	}
}
