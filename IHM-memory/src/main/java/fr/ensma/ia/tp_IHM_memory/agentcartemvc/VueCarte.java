package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe representant une carte de memory.
 * La carte est un JButton abonne a ActionListener pour la detection des clics sur le bouton.
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
	 * Icone representant la face cachee de la carte
	 */
	private ImageIcon faceCachee = new ImageIcon("resources/faceCachee.png");
	
	/**
	 * Icone representant la face visible de la carte
	 */
	private ImageIcon faceVisible;

	/**
	 * Icone representant la carte hors du plateau
	 */
	private ImageIcon horsPlateau = new ImageIcon("resources/horsPlateau.png");


	/**
	 * Constructeur d'une carte.
	 * symboleCarte et bonusCarte permettent de trouver la reference de l'icone faceVisible dans le dossier resources
	 * @param controleurCarte ControleurCarte : le controleur de la carte
	 * @param modeleCarte ModeleCarte : le modele de la carte
	 * @param symboleCarte String : le symbole de la carte
	 * @param bonusCartes String : le bonus de la carte (vaut "" si la carte n'a pas de bonus)
	 */
	public VueCarte(ControleurCarte controleurCarte, ModeleCarte modeleCarte,
			String symboleCarte, String bonusCartes) {
		
		this.controleurCarte = controleurCarte;
		this.modeleCarte = modeleCarte;
		
		faceVisible = new ImageIcon("resources/" + symboleCarte + bonusCartes + ".png");
		
		// definition des icones par defaut de la carte
		setIcon(faceCachee);
		setDisabledIcon(faceVisible);
		
		// definition des paramtres geometriques de la carte
		setMargin(new Insets(0, 0, 0, 0));
		setPreferredSize(new Dimension(130,130));
		setBorderPainted(false);
		
		// ajout du bouton au ActionListener
		addActionListener(this);
		
	}
	
	/**
	 * Recupere les informations de visibilite de la carte et met a jour la vue en consequence.
	 * Si la carte est sur le plateau : isHorsPlateau == true, false sinon.
	 * Si la carte est face visible : isCarteVisible == true, false sinon.
	 */
	public void updateVue() {
		if(modeleCarte.isHorsPlateau() == true) {
			setDisabledIcon(horsPlateau);
			setEnabled(false);
		} else {
			if (modeleCarte.isCarteVisible() == true) setEnabled(false);
			else setEnabled(true);
		}
	}

	/**
	 * Appel du controleur en cas de detection d'un clic de l'utilisateur sur la carte.
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	private static final long serialVersionUID = 1L;
}
