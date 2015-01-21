package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.FaceCachee;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.FaceVisible;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.HorsPlateau;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.IEtatCarte;

/**
 * Classe representant le controleur d'une carte conformement a l'architecture MVC.</br>
 * Automate gerant les differents etats d'une carte.
 * 
 * @author clementdouault
 *
 */
public class ControleurCarte {
	
	/**
	 * Reference du modele de la carte
	 */
	private ModeleCarte modeleCarte;
	
	/**
	 * Reference de la vue de la carte
	 */
	private VueCarte vueCarte;
	
	/**
	 * Etat courant de la carte
	 */
	private IEtatCarte etatCourantCarte;
	
	/**
	 * Instance de l'etat FaceCachee
	 */
	private IEtatCarte faceCachee = new FaceCachee(this);
	
	/**
	 * Instance de l'etat FaceVisible
	 */
	private IEtatCarte faceVisible = new FaceVisible(this);
	
	/**
	 * Instance de l'etat HorsPlateau
	 */
	private IEtatCarte horsPlateau = new HorsPlateau(this);

	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur du controleur de la carte
	 * @param modeleCarte
	 */
	public ControleurCarte(ModeleCarte modeleCarte) {
		this.modeleCarte = modeleCarte;
		vueCarte = new VueCarte(this, modeleCarte);
		
		// initialisation de l'automate gerant les etats de la carte
		etatCourantCarte = faceCachee;
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient la reference de la carte
	 * @return vueCarte VueCarte : la reference de la carte
	 */
	public VueCarte getVueCarte() {
		return vueCarte;
	}
	
	// -- GESTION DES ETATS DE L'AUTOMATE -- //
	
	/**
	 * Obtient l'etat courant de la carte
	 * @return etatCourantCarte IEtatCarte : l'etat courant de la carte
	 */
	public IEtatCarte getEtatCourantCarte() {
		return etatCourantCarte;
	}

	/**
	 * Modifie l'etat courant de la carte
	 * @param etatCourantCarte IEtatCarte : le nouvel etat courant de la carte
	 */
	public void setEtatCourantCarte(IEtatCarte etatCourantCarte) {
		this.etatCourantCarte = etatCourantCarte;
	}

	/**
	 * Obtient l'instance de l'etat FaceCachee
	 * @return faceCachee IEtatCarte
	 */
	public IEtatCarte getFaceCachee() {
		return faceCachee;
	}

	/**
	 * Obtient l'instance de l'etat FaceVisible
	 * @return faceVisible IEtatCarte
	 */
	public IEtatCarte getFaceVisible() {
		return faceVisible;
	}

	/**
	 * Obtient l'instance de l'etat HorsPlateau
	 * @return horsPlateau IEtatCarte
	 */
	public IEtatCarte getHorsPlateau() {
		return horsPlateau;
	}
}
