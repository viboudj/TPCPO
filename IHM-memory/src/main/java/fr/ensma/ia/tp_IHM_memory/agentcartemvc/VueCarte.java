package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe representant une carte de memory.</br>
 * Classe heritant de JButton et abonnee a ActionListener pour la detection des clics sur le bouton.
 * 
 * @author clementdouault
 *
 */
public class VueCarte extends JButton implements ActionListener {

	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Reference du modele de la carte
	 */
	private ModeleCarte modeleCarte;

	/**
	 * Icone representant la face visible de la carte
	 */
	private ImageIcon faceVisible;
	
	/**
	 * Icone representant la face cachee de la carte
	 */
	private ImageIcon faceCachee = new ImageIcon("resources/faceCachee.png");

	/**
	 * Icone representant la carte hors du plateau
	 */
	private ImageIcon horsPlateau = new ImageIcon("resources/horsPlateau.png");


	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur de la vue d'une carte
	 * @param controleurCarte ControleurCarte : le controleur de la carte
	 * @param modeleCarte ModeleCarte : le modele de la carte
	 */
	public VueCarte(ControleurCarte controleurCarte, ModeleCarte modeleCarte) {
		
		this.controleurCarte = controleurCarte;
		this.modeleCarte = modeleCarte;
		
		// recuperation de l'icone de la face visible de la carte
		faceVisible = new ImageIcon(referenceIconeCarte());
		
		// definition des icones par defaut de la carte
		setIcon(faceCachee);
		refreshVue();
		
		// definition des paramtres geometriques de la carte
		setMargin(new Insets(0, 0, 0, 0));
		setPreferredSize(new Dimension(130,130));
		setBorderPainted(false);
		
		// ajout du bouton au ActionListener
		addActionListener(this);
		
	}
	
	/**
	 * Obtient de modeleCarte la reference de l'icone de la face visible de la carte
	 * @return String : la reference de l'icone
	 */
	public String referenceIconeCarte() {
		return "resources/" + modeleCarte.getSymboleCarte() + modeleCarte.getBonusCarte() + ".png";
	}
	
	// -- GESTION DE LA MISE A JOUR DE LA VUE -- //
	
	/**
	 * Rend la carte face cachee cliquable ou pas
	 */
	public void updateActivationFaceCachee() {
		if (modeleCarte.isCarteBloquee()) {
			setDisabledIcon(faceCachee);
			setEnabled(false);
		} else {
			setEnabled(true);
		}
	}
	
	/**
	 * Place la carte face visible
	 */
	public void updateFaceVisible() {
		setDisabledIcon(faceVisible);
		setEnabled(false);
	}
	
	/**
	 * Place la carte face cachee
	 */
	public void updateFaceCachee() {
		setEnabled(true);
	}
	
	/**
	 * Place la carte hors du plateau
	 */
	public void updateHorsPlateau() {
		setDisabledIcon(horsPlateau);
		setEnabled(false);
	}
	
	/**
	 * Recupere de modeleCarte les informations de visibilite de la carte et met a jour la vue en consequence.</br>
	 * Si la carte est sur le plateau : isHorsPlateau == true, false sinon.</br>
	 * Si la carte est face visible : isCarteVisible == true, false sinon.
	 */
	public void refreshVue() {
		if(modeleCarte.isHorsPlateau() == true) {
			updateHorsPlateau();
		} else {
			if (modeleCarte.isCarteVisible() == true) updateFaceVisible();
			else updateFaceCachee();
		}
	}

	/**
	 * Appel du controleur en cas de detection d'un clic de l'utilisateur sur la carte
	 */
	public void actionPerformed(ActionEvent arg0) {
		controleurCarte.getEtatCourantCarte().carteCliquee();
	}
	
	private static final long serialVersionUID = 1L;
}
